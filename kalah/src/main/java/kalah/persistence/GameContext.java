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


/**
 * Represents a saved Game context
 * @author James
 *
 */

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
}
