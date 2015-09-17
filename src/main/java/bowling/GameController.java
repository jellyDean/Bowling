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
		String supportedCharsString = "xX/0123456789-";
		// validate there is an option in the request
	    if (game != null) {
	    	String gameString = game.getBowlingGame();
	    	// validate the bowlingGame string was sent
	    	if (gameString != null){	
	    		for (int i = 0; i < gameString.length(); i++){
	    		    char c = gameString.charAt(i);
	    		    //validate the chars are supported
	    		    if(supportedCharsString.indexOf(c) == -1){
	    		    	System.out.println("code 500 invalid chars");
	    		    	return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    		    }
	    		}
	    		String[] frameParts = gameString.split("-");
	    		//validate a complete game was played
	    		if (frameParts.length != 10){
	    			System.out.println("code 500 partial game");
	    			return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    		}
	   
	    		for (int i = 0; i < frameParts.length; i++) {
	    			//validation for last frame
	    			String frame = frameParts[i];
	    			if (i == 9){
	    				System.out.println("last frame " + frame);	
	    			}else{
	    				if (frame.length() == 1){
	    					//validate if there is one char in a frame that it is a strike
	    					if (!frame.equalsIgnoreCase("x")){
	    						System.out.println("code 500 one shot thrown and wasnt marked as a strike "+ frame);
	    						return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    					}else{System.out.println("one shot thrown and was marked as a strike " + frame);
	    						}
	    				} else if (frame.length() == 2){
	    					System.out.println("valid number of throws in frame " + frame);
	    					
	    					if (frame.toLowerCase().contains("x")){
	    						System.out.println("code 500 cannot have two throws and contain a strike " + frame);
	    						return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    					}
	    					char spare = '/';
	    					char firstCharofFrame = frame.charAt(0);
	    					char secondCharofFrame = frame.charAt(1);
	    					

	    					
	    					//validate the first throw in a frame cant be spare
	    					if (firstCharofFrame == spare){
	    						System.out.println("code 500 first throw of frame cannot be a spare " + frame);
	    						return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    					}
	    					
	    					if(secondCharofFrame != spare){
		    					int firstCharInt = Character.getNumericValue(firstCharofFrame);
		    					System.out.println("firstCharInt firstCharInt " + firstCharInt);
		    					int secondCharInt = Character.getNumericValue(secondCharofFrame);
		    					int sum = firstCharInt + secondCharInt;
		    					System.out.println("secondCharInt secondCharInt " + secondCharInt);
		    					if (sum > 10 || sum < 0){
		    						System.out.println("code 500 open frame sum is greater than 10 or less than 0 (sum,frame) " + sum + " " + frame);
		    						return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
		    					}
	   
	    					}
	    				}
	    				else{
	    					//validate that any frame that is not a strike and not frame 10 should contain two throws
	    					System.out.println("code 500 iregular number of throws in frame "+ frame);
	    					return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    				}
	    				
	    			}
	    			//process frame
	    		}
	    		
	    		gameOut.setScore(200);
	    	}else {
	    		System.out.println("code 500 bowling game string does not exist");
	    	}
	    }else{
	    	System.out.println("code 500 game not sent in request");
	    }
	    return new ResponseEntity<GameOutput>(gameOut, HttpStatus.OK);
	}	
	
	
}
