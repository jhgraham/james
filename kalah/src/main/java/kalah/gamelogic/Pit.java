package kalah.gamelogic;

/**
 * This class represents a Pit in the Kalah gameboard
 * @author James
 *
 */

public class Pit
{
    /**
     * Seed count
     */
    private int count = 0;
    
    /**
     * Flag to denote if the Pitt is a store (Kalah) or not
     */
    private boolean isStore = false;
    
    /**
     * Owner of the Pit (North / South)
     */
    private Player owner;
       
    /**
     * Constructor
     * @param initialCount
     * @param isStore
     * @param owner
     */
    public Pit(int initialCount, boolean isStore, Player owner)
    {
        this.count = initialCount;
        this.isStore = isStore;
        this.owner = owner;
    }
    
    /**
     * Return the seed count
     * @return
     */
    public int getCount()
    {
        return count;
    }
       
    /**
     * Add seeds to the Pit
     * @param seeds
     */
    public void add(int seeds)
    {
        count += seeds;
    }
       
    /**
     * Determine if the pit is empty of seeds
     * @return
     */
    public boolean isEmpty()
    {
        return count == 0;
    }
       
    /**
     * Remove all seeds from the Pit
     * @return
     */
    public int takeAll()
    {
        int temp = count;
      	count = 0;
      	return temp;
    }
    
    /**
     * Determine if the Pit is a store of the supplied player
     * @param owner
     * @return
     */
    public boolean isStore(Player owner)
    {
        return isStore && this.owner == owner;
    }
    
    /**
     * Set whether the pit is a store
     * @param isStore
     */
    public void setStore(boolean isStore)
    {
        this.isStore = isStore;
    }
    
    /**
     * Determine if the pit is a store
     * @return
     */
    public boolean isStore()
    {
        return this.isStore;
    }
    
    /**
     * Return the owner of the pit
     * @return
     */
    public Player getOwner()
    {
        return owner;
    }
        
    /**
     * Set the owner of the pit
     * @param owner
     */
    public void setOwner(Player owner)
    {
        this.owner = owner;
    }

    /**
     * Set the seed count
     * @param i
     */
    public void setCount(int count)
    {
        this.count = count;
    }
}