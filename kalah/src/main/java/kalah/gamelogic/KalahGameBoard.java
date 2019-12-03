package kalah.gamelogic;

import java.util.ArrayList;
import java.util.List;

import kalah.exceptions.KalahException;
import kalah.persistence.GameContext;

public class KalahGameBoard
{
    
    /**
     * Array of Pits on the Board
     */
    private final Pit[] pits;
    
    /**
     * Game ID
     */
    private final Long id;
    
   

    /**
     * Constructor
     * @param id
     * @param counts
     * @param currentTurn
     */
    public KalahGameBoard(Long id, Integer[] counts)
    {
        this.id = id;
        this.pits = init(counts);
    }
    
    /**
     * Initialise the pits
     * @param counts
     * @return
     */
    private static Pit[] init(Integer[] counts)
    {
        List<Pit> tempPits = new ArrayList<Pit>();
        
        int pitCount = (counts.length - 2) / 2; 
        
        for(int i=0; i<counts.length; ++i)
        {
            if(i < pitCount)
            {
                tempPits.add(new Pit(counts[i],  false, Player.South));
            }
            else if(i == pitCount)
            {
                //South Kalah
                tempPits.add(new Pit(counts[i],  true, Player.South));                
            }
            else if(i == 2 * pitCount + 1)
            {
                //North Kalah
                tempPits.add(new Pit(counts[i],  true, Player.North));              
            }
            else
            {
                tempPits.add(new Pit(counts[i],  false, Player.North));                 
            }
        }
        
        return tempPits.toArray(new Pit[tempPits.size()]);
    }
    
    public Integer[] getCounts()
    {
        Integer[] counts = new Integer[pits.length];
        for(int i=0; i<pits.length; ++i)
        {
            counts[i] = pits[i].getCount();
        }
        return counts;
    }
    
    /**
     * Return the index of the Opposite Pit to the one of the supplied index
     * @param index
     * @return the Pit opposite
     * @throws KalahException 
     */
    public int getOpposite(int index) throws KalahException
    {
        int pitCount = (pits.length - 2) / 2;
        
        //avoid the stores 
        if(index == pitCount || index == pits.length -1)
        {
            throw new KalahException("Invalid index for Pit");
        }
        
        return 2 * pitCount - index;
    }
    
    /**
     * Return the size of the Kalah board (including stores)
     * @return
     */
    public int getBoardSize()
    {
        return pits.length;
    }
    

    public Long getId()
    {
        return id;
    }

    public Pit getPit(int index)
    {
        return pits[index];
    }
    
    public static Player getOpponent(Player player)
    {
        if(player == Player.South)
        {
            return Player.North;
        }
        else
        {
            return Player.South;
        }
    }
    
}
