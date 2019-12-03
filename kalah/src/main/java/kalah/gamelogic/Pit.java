package kalah.gamelogic;

public class Pit
{
    private int count = 0;
    private boolean isStore = false;
    private Player owner;
       
    public Pit(int initialCount, boolean isStore, Player owner)
    {
        this.count = initialCount;
        this.isStore = isStore;
        this.owner = owner;
    }
    
    public int getCount()
    {
     return count;
    }
       
    public void add(int seeds)
    {
        count += seeds;
    }
       
    public boolean isEmpty()
    {
        return count == 0;
    }
       
    public int takeAll()
    {
        int temp = count;
      	count = 0;
      	return temp;
    }
    
    public boolean isStore(Player owner)
    {
        return isStore && this.owner == owner;
    }
    
    public void setStore(boolean isStore)
    {
        this.isStore = isStore;
    }
    public boolean isStore()
    {
        return this.isStore;
    }
    
    public Player getOwner()
    {
        return owner;
    }
        
    public void setOwner(Player owner)
    {
        this.owner = owner;
    }

    public void setCount(int i)
    {
        count = i;
    }
}