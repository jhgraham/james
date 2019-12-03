package kalah.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import kalah.exceptions.KalahGameNotFoundException;
import kalah.exceptions.KalahInvalidPitIdException;
import kalah.exceptions.KalahNotCurrentTurnException;
import kalah.service.KalahService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * REST Controller for the Kalah Web Service
 * @author James
 *
 */
@RestController
public class KalahController
{
	
	@Autowired
	KalahService service;

	/** 
	 * Handler for create new games
	 * @return
	 */
    @PostMapping("/games")
    public ResponseEntity<Object> create()
    {
	  Long newGameId = service.newGame();
	  
	  // Make Game URL
	  String gameLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{gameId}").buildAndExpand(newGameId.toString()).toUriString();
	  
      return new ResponseEntity<>(new CreateGameResponseBody(newGameId.toString(), gameLocation), HttpStatus.CREATED);
    }
  
    /**
     * Handler for making moves in a game.
     * @param gameId
     * @param pitId
     * @return
     */
  @PutMapping("/games/{gameId}/pits/{pitId}")
  public ResponseEntity<Object> move(@PathVariable Long gameId, @PathVariable Integer pitId)
  {
	  try
	  {
	      //convert to zero based arrays
	      int pitIndex = --pitId;
	      
	      Integer[] pitCounts = service.move(gameId, pitIndex);
	      
	      String gameLocation = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/games/{gameId}").buildAndExpand(gameId.toString()).toUriString();

		  //Convert to expected output
		  Map<String, String> status = createStatusArray(pitCounts);
		  
	      return new ResponseEntity<>(new MoveResponseBody(gameId.toString(), gameLocation, status), HttpStatus.OK);
	  }
	  catch(KalahGameNotFoundException ex)
	  {
	      return new ResponseEntity<>(new ErrorResponseBody(ex.getMessage()), HttpStatus.NOT_FOUND);
	  }
	  catch(KalahInvalidPitIdException ex)
	  {
	      return new ResponseEntity<>(new ErrorResponseBody(ex.getMessage()), HttpStatus.BAD_REQUEST);
	  }	  
	  catch(KalahNotCurrentTurnException ex)
	  {
	      return new ResponseEntity<>(new ErrorResponseBody(ex.getMessage()), HttpStatus.FORBIDDEN);
	  }  
  }
  
/**
 * Convert a zero-based Pit array to a Map which uses the Pit ID as a key in order to return the board status to the client
 * @param pitArray
 * @return
 */
  private Map<String, String> createStatusArray(Integer[] pitArray)
  {
      Map<String, String> status = new TreeMap<String, String>(new NumericalOrderStringComparator());
      for(Integer i=0; i<pitArray.length;++i)
      {
          Integer pitId = i + 1; //Pit ID not zero-based
          status.put(pitId.toString(), pitArray[i].toString());
      }
      
      return status;
  }
}

