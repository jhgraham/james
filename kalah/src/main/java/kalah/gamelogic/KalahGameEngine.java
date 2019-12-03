package kalah.gamelogic;

import kalah.exceptions.KalahException;
import kalah.exceptions.KalahInvalidPitIdException;
import kalah.exceptions.KalahNotCurrentTurnException;

/**
 * This class contains the logic and enforces the rules when a move is made in the Kalah game.
 * @author James
 *
 */
public class KalahGameEngine
{
    
    /**
     * Make a move in the Kalah game
     * @param board Board Object
     * @param startIndex index of the pit from where the move will start
     * @param currentTurn the player turn (North / South)
     * @return the next PLayer turn
     * @throws KalahInvalidPitIdException
     * @throws KalahNotCurrentTurnException
     */
    public static Player move(KalahGameBoard board, int startIndex, Player currentTurn) throws KalahInvalidPitIdException, KalahNotCurrentTurnException
    {
        Pit pit = null;
        int boardSize = board.getCounts().length;
        try
        {
            pit = board.getPit(startIndex);           
        }
        catch(ArrayIndexOutOfBoundsException ex)
        {
            throw new KalahInvalidPitIdException("Invalid Pit index");             
        }
        
        //check pit is not a store
        if(pit.isStore())
        {
            throw new KalahInvalidPitIdException("Cannot start a move in a store."); 
        }
        
        if(currentTurn == Player.Unspecified)
        {
            //turn not set yet
            currentTurn = pit.getOwner();
        }
        
        Player pitOwner = pit.getOwner();
        
        if(currentTurn == Player.South && Player.North == pitOwner ||
                currentTurn == Player.North && Player.South == pitOwner )
        {
            //wrong index supplied for the turn
            throw new KalahNotCurrentTurnException("Invalid index for player turn.");    
        }
        
        Player opponent = KalahGameBoard.getOpponent(currentTurn);
        Player nextTurn = opponent;
        int numSeeds = pit.getCount();
        pit.setCount(0);
        int index = startIndex + 1;
        
        while(numSeeds > 0)
        {
            pit = board.getPit(index);
            //avoid opponents Kalah
            if(!pit.isStore(opponent))
            {
                //is this the last seed?
                if(numSeeds == 1)
                {
                    if(pit.isStore(currentTurn))
                    {
                        //current player landed on the store, gets another go
                        nextTurn = currentTurn;
                    }
                    else
                    {
                        //do we have an empty pit on the current player's side? 
                        if(pit.isEmpty() && pit.getOwner() == currentTurn)
                        {
                            try
                            {
                              //take the opponent's seeds
                                int opposite = board.getOpposite(index);
                                Pit opponentsPit = board.getPit(opposite);
                                pit.add(opponentsPit.takeAll());
                                
                            }
                            catch (KalahException e)
                            {
                                //carry on?
                                throw new KalahInvalidPitIdException("Error tried to land on a store."); 
                            }
                        }
                    }
                }
                
                pit.add(1);
                
                --numSeeds;          
            }
            
            index = (index + 1) % boardSize;
        }
        
        return nextTurn;
    }
    

    
    
}
