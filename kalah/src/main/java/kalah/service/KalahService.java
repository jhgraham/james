

package kalah.service;

import java.util.Map;
import kalah.exceptions.KalahGameNotFoundException;
import kalah.exceptions.KalahInvalidPitIdException;
import kalah.exceptions.KalahNotCurrentTurnException;


public interface KalahService
{
    /**
     * Create a new Game of Kalah
     * @return Unique Game ID
     */
	public Long newGame();

	/**
	 * Make a move
	 * @param gameId - ID of the Game
	 * @param pitID  - ID of the Pit
	 * @return Status of the Kalah Game
	 * @throws KalahGameNotFoundException
	 * @throws KalahInvalidPitIdException
	 * @throws KalahNotCurrentTurnException
	 */
	public Integer[]  move(Long gameId, int pitID) throws KalahGameNotFoundException,
														  KalahInvalidPitIdException,
														  KalahNotCurrentTurnException;
	
	/**
	 * Retrieve the status of the Kalah Game
	 * @param gameId - ID of the game
	 * @return
	 * @throws KalahGameNotFoundException
	 */
	public Map<Integer, Integer> get(Long gameId) throws KalahGameNotFoundException;

}
