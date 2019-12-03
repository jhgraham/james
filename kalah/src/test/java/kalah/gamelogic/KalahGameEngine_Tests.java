package kalah.gamelogic;

import java.util.Arrays;

import kalah.exceptions.KalahInvalidPitIdException;
import kalah.exceptions.KalahNotCurrentTurnException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class KalahGameEngine_Tests
{

    @Test
    public void testMove()
    {

        
        try
        {
            Integer[] counts = {3,3,3,0,3,3,3,0};
            KalahGameBoard board = new KalahGameBoard(1L, counts);  
            
            testMove1(board);
            testMove2(board);
            testMove3(board);
            testMove4(board);
            testMove5(board);
        }
        catch (KalahInvalidPitIdException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (KalahNotCurrentTurnException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    void testMove1(KalahGameBoard board) throws KalahInvalidPitIdException, KalahNotCurrentTurnException
    {
        Player nextTurn = KalahGameEngine.move(board, 0, Player.South);
        
        Integer[] result = board.getCounts();
        Integer[] expected = {0,4,4,1,3,3,3,0};
        
        assertTrue(Arrays.equals(expected, result));
        assertEquals(Player.South, nextTurn);
    }
    
    void testMove2(KalahGameBoard board) throws KalahInvalidPitIdException, KalahNotCurrentTurnException
    {
        Player nextTurn = KalahGameEngine.move(board, 1, Player.South);
        
        Integer[] result = board.getCounts();
        Integer[] expected = {0,0,5,2,4,4,3,0};
        
        assertTrue(Arrays.equals(expected, result));
        assertEquals(Player.North, nextTurn);
    }    
    
    void testMove3(KalahGameBoard board) throws KalahInvalidPitIdException, KalahNotCurrentTurnException
    {
        Player nextTurn = KalahGameEngine.move(board, 2, Player.South);
        
        Integer[] result = board.getCounts();
        Integer[] expected = {5,0,0,3,5,5,0,0};
        
        assertTrue(Arrays.equals(expected, result));
        assertEquals(Player.North, nextTurn);
    }
    void testMove4(KalahGameBoard board) throws KalahInvalidPitIdException, KalahNotCurrentTurnException
    {
        Player nextTurn = KalahGameEngine.move(board, 4, Player.North);
        
        Integer[] result = board.getCounts();
        Integer[] expected = {6,1,0,3,0,6,1,1};
        
        assertTrue(Arrays.equals(expected, result));
        assertEquals(Player.South, nextTurn);
    }
    void testMove5(KalahGameBoard board) throws KalahInvalidPitIdException, KalahNotCurrentTurnException
    {
        Player nextTurn = KalahGameEngine.move(board, 5, Player.North);
        
        Integer[] result = board.getCounts();
        Integer[] expected = {7,2,0,3,2,0,2,2}; 
        
        assertTrue(Arrays.equals(expected, result));
        assertEquals(Player.South, nextTurn);
        
    }
    
}
