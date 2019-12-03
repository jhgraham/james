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


@RestController
public class KalahController
{
	
	@Autowired
	KalahService service;

    @PostMapping("/games")
    public ResponseEntity<Object> create()
    {
	  Long newGameId = service.newGame();
	  
	  // Make Game URL
	  String gameLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{gameId}").buildAndExpand(newGameId.toString()).toUriString();
	  
      return new ResponseEntity<>(new CreateGameResponseBody(newGameId.toString(), gameLocation), HttpStatus.CREATED);
    }
  
  @PutMapping("/games/{gameId}/pits/{pitId}")
  public ResponseEntity<Object> move(@PathVariable Long gameId, @PathVariable Integer pitId)
  {
	  try
	  {
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

