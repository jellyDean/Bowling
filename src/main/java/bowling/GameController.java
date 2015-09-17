package bowling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

	@RequestMapping(value = "/api/v0/platform/get_bowling_score", method = RequestMethod.POST)
	public ResponseEntity<GameOutput> update(@RequestBody Game game) {
		GameOutput gameOut = new GameOutput();
	    if (game != null) {
	    	String gameString = game.getBowlingGame();
	    	if (gameString != null){	    		
	    		gameOut.setScore(65);
	    	}//else return error code 500
	    }//else return error code 500
	    return new ResponseEntity<GameOutput>(gameOut, HttpStatus.OK);
	}	
	
	
}
