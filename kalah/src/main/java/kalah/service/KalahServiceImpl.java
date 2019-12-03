

package kalah.service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import kalah.exceptions.KalahException;
import kalah.exceptions.KalahGameNotFoundException;
import kalah.exceptions.KalahInvalidPitIdException;
import kalah.exceptions.KalahNotCurrentTurnException;
import kalah.gamelogic.KalahGameBoard;
import kalah.gamelogic.KalahGameEngine;
import kalah.gamelogic.Player;
import kalah.persistence.GameContext;
import kalah.persistence.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("kalah")
public class KalahServiceImpl implements KalahService
{
    
    @Autowired
    GameRepository repo;
    
    
    private static final int NUM_PITS = 6;
    private static final int INITIAL_SEED_COUNT = 6;
    
    /***
     * Create a new Kalah game
     * 
     */
	public Long newGame()
	{
	    GameContext gameCxt = new GameContext(NUM_PITS, INITIAL_SEED_COUNT);
	    repo.save(gameCxt);
        
		return gameCxt.getId();
	}
	
	/**
	 * Make a move
	 */
	public Integer[] move(Long gameId, int pitIndex) throws KalahGameNotFoundException,
															KalahInvalidPitIdException,
															KalahNotCurrentTurnException
	{
	    if(!repo.existsById(gameId))
	    {
            throw new KalahGameNotFoundException("Game with ID " + gameId + " does not exist.");        
	    }
	    
	    GameContext gameCxt = repo.findById(gameId).get();
	    if(gameCxt == null)
	    {
            throw new KalahGameNotFoundException("Game with ID " + gameId + " does not exist.");     
	    }
	    
        //create a game board from the saved Game context
        KalahGameBoard board = new KalahGameBoard(gameCxt.getId(), gameCxt.getCounts());
        
        //perform the move
        Player nextTurn = KalahGameEngine.move(board, pitIndex, gameCxt.getNextTurn());
        gameCxt.setNextTurn(nextTurn);
        gameCxt.setCounts(board.getCounts());
        
        repo.save(gameCxt);
        
        return gameCxt.getCounts();
	}


	@Override
	public Map<Integer, Integer> get(Long gameId)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
