package kalah.gamelogic;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import kalah.exceptions.KalahException;

import org.junit.Test;


public class KalahGameBoard_Tests
{
    
    
    
    @Test
    public void TestInit()
    {
        //Pit size = 3, Total length = (3 * 2 + 2) = 8
        Integer[] counts = {0,0,0,0,0,0,0,0};
        KalahGameBoard board = new KalahGameBoard(1L, counts);
        
        try
        {
            Pit pit = board.getPit(0);
            assertEquals(0, pit.getCount());
            assertEquals(Player.South, pit.getOwner());
            assertFalse(pit.isStore());
            pit = board.getPit(1);
            assertEquals(0, pit.getCount());
            assertEquals(Player.South, pit.getOwner());
            assertFalse(pit.isStore());
            pit = board.getPit(2);
            assertEquals(0, pit.getCount());
            assertEquals(Player.South, pit.getOwner());
            assertFalse(pit.isStore());
            pit = board.getPit(3);
            assertEquals(0, pit.getCount());
            assertEquals(Player.South, pit.getOwner());
            assertTrue(pit.isStore()); //should be a store
            
            pit = board.getPit(4);
            assertEquals(0, pit.getCount());
            assertEquals(Player.North, pit.getOwner());
            assertFalse(pit.isStore());
            pit = board.getPit(5);
            assertEquals(0, pit.getCount());
            assertEquals(Player.North, pit.getOwner());
            assertFalse(pit.isStore());
            pit = board.getPit(6);
            assertEquals(0, pit.getCount());
            assertEquals(Player.North, pit.getOwner());
            assertFalse(pit.isStore());
            pit = board.getPit(7);
            assertEquals(0, pit.getCount());
            assertEquals(Player.North, pit.getOwner());
            assertTrue(pit.isStore());   
        }
        catch(KalahException ex)
        {
            //no exception expected
            assertTrue(false);
        }
    }
    
    @Test
    public void testGetOppositePit()
    {
        Integer[] counts = {0,0,0,0,0,0,0,0};
        KalahGameBoard board = new KalahGameBoard(1L, counts);  
        
        try
        {
            assertEquals(6, board.getOpposite(0));
            assertEquals(5, board.getOpposite(1));
            assertEquals(4, board.getOpposite(2));
            
            assertEquals(0, board.getOpposite(6));
            assertEquals(1, board.getOpposite(5));
            assertEquals(2, board.getOpposite(4));
        }
        catch(KalahException ex)
        {
            //no exception expected
            assertTrue(false);
        }
    }
    
    @Test
    public void testInvalidOppositePit()
    {
        Integer[] counts = {0,0,0,0,0,0,0,0};
        KalahGameBoard board = new KalahGameBoard(1L, counts);  
        
        assertEquals(8, board.getBoardSize());
  
        try
        {
            board.getOpposite(7);
            board.getOpposite(3);
            assertTrue(false);
        }
        catch(KalahException ex)
        {
            //no exception expected
            assertTrue(true);
        }
    }
    
}