package kalah.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import kalah.exceptions.KalahInvalidPitIdException;
import kalah.gamelogic.Pit;
import kalah.gamelogic.Player;




@Entity
public class GameContext implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Game ID
     */
    @Id
    @GeneratedValue
    private Long id;
    
    /**
     * Number of Pits per player
     */
    private int pitCount;
    
    
    /**
     * Counts List
     */
    private Integer[] counts;
    
    /**
     * Next turn
     * @return
     */
    @Enumerated(EnumType.ORDINAL)
    private Player nextTurn;
    
    /**
     * Constructor
     * @param pitCount
     * @param initialSeedCount
     */
    public GameContext(int pitCount, int initialSeedCount)
    {
        this.pitCount = pitCount;
        
        int length = pitCount * 2 + 2;
        int southStore = pitCount;
        int northStore = 2*pitCount + 1;
        this.counts = new Integer[length];
        
        for(int i = 0; i < length; ++i)
        {
            this.counts[i] = initialSeedCount;
        }
        this.counts[southStore] = 0;
        this.counts[northStore] = 0;      
        
        nextTurn = Player.Unspecified;
    }
    
    /**
     * Default Constructor
     */
    public GameContext()
    {
        
    }
   

    public Integer[] getCounts()
    {
        return counts;
    }
    
    public void setCounts(Integer[] counts)
    {
       this.counts = counts;   
    }
    
    public Integer getCount(int index)
    {
        return counts[index];
    }
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Player getNextTurn()
    {
        return nextTurn;
    }

    public void setNextTurn(Player nextTurn)
    {
        this.nextTurn = nextTurn;
    }
//
//    public void setStatus(Integer[] counts)
//    {
//        this.counts = counts;
//    }
//
//    public int getPitCount()
//    {
//        return pitCount;
//    }
//
//    public void setPitCount(int pitCount)
//    {
//        this.pitCount = pitCount;
//    }
//    
//    
//    public boolean isStore(int index)
//    {
//        return(index == pitCount || index == 2*pitCount + 1);
//    }
//    
//    public int getStore(Player player)
//    {
//        if(player == Player.South)
//        {
//            return pitCount + 1;
//        }
//        else
//        {
//            return 2 * pitCount + 1;
//        }
//    }
//    
//    public boolean isEmpty(int index)
//    {
//        return counts[index] == 0;
//    }
//    
//    public int getOwnStore()
//    {
//        return getStore(nextTurn);
//    }    
//    
//    
//    public Player getOpponent()
//    {
//        if(nextTurn == Player.South)
//        {
//            return Player.North;
//        }
//        else
//        {
//            return Player.South;
//        }      
//    }
//    public int getOpponentStore()
//    {
//        return getStore(getOpponent());
//    }
//    
//    public int getOppositePit(int index)
//    {
//        return ( index + pitCount + 1 ) % counts.length;
//    }
//    
//    /**
//     * Determine which player should be playing based on the supplied Pit index
//     * @param index
//     * @return
//     * @throws KalahInvalidPitIdException
//     */
//    public Player getPlayer(int index) throws KalahInvalidPitIdException
//    {
//        if(index < pitCount - 1)
//        {
//            return Player.South;
//        }
//        else if(index > pitCount && index < 2*pitCount-1)
//        {
//            return Player.North;
//        }
//        else
//        {
//            throw new KalahInvalidPitIdException("Invalid Pit index");             
//        }
//    }
//    
//    public BoardIterator iterator(int startindex)
//    {
//        return new BoardIterator(startindex);
//    }
    
}
