package bowling;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

	//define post end point
	@RequestMapping(value = "/api/v0/platform/get_bowling_score", method = RequestMethod.POST)
	public ResponseEntity<GameOutput> update(@RequestBody Game game) {
		GameOutput gameOut = new GameOutput();
		ArrayList<Frame> frameList = new ArrayList<Frame>();
		
		String supportedCharsString = "xX/0123456789-";
		// validation of input string start
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
	    		
	    		char spare = '/';
	    		char lowerStrike = 'x';
	    		for (int i = 0; i < frameParts.length; i++) {
	    			//validation for last frame
	    			String frame = frameParts[i];
	    			
	    			if (i == 9){
	    				//if 10th frame used two throws
	    				if (frame.length() == 2){
	    					
	    					char firstCharofFrame = Character.toLowerCase(frame.charAt(0)); 
	    					char secondCharofFrame = Character.toLowerCase(frame.charAt(1)); 
	    					
	    					//first or second char cant be x or \
	    					//validate the first throw in a frame cant be spare
	    					if (firstCharofFrame == spare || firstCharofFrame == lowerStrike || secondCharofFrame == lowerStrike || secondCharofFrame == spare){
	    						System.out.println("code 500 10 frame with two throws cannot be a spare or strike " + frame);
	    						return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    					}
	    					// if 10th frame is open sum of throws must be less than 10
	    					int firstCharInt = Character.getNumericValue(firstCharofFrame);
	    					int secondCharInt = Character.getNumericValue(secondCharofFrame);
	    					int sum = firstCharInt + secondCharInt;
	    					if (sum > 10 || sum < 0){
	    						System.out.println("code 500 open 10th frame sum is greater than 10 or less than 0 for the first and second throw (sum,frame) " + sum + " " + frame);
	    						return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    					}
   
	    				   //if 10th frame used three throws
	    				} else if (frame.length() == 3){
	    					char firstCharofFrame = Character.toLowerCase(frame.charAt(0)); 
	    					char secondCharofFrame = Character.toLowerCase(frame.charAt(1)); 
	    					char thirdCharofFrame = Character.toLowerCase(frame.charAt(2)); 
	    					//first char cannot be a spare
	    					if (firstCharofFrame == spare){
	    						System.out.println("code 500 10 frame with three throws cannot have spare as first throw " + frame);
	    						return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    					}
	    					
	    					Boolean isFirstCharNumber = Character.isDigit(firstCharofFrame);
	    					
	    					//if first char is a number second char must be a spare
	    					if (isFirstCharNumber && secondCharofFrame != '/' ){
	    						System.out.println("code 500 10 frame with three throws with first throw open must have a spare for the second throw " + frame);
	    						return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    					}
	    					
	    					//if strike middle char cant be spare
	    					if (firstCharofFrame == 'x' && secondCharofFrame == '/' ){
	    						System.out.println("code 500 10 frame with three throws with first throw strike cannot have a spare for the second throw " + frame);
	    						return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    					}
	    					
	    					//2nd throw and third throw cannot both be spares
	    					if (secondCharofFrame == '/' && thirdCharofFrame == '/' ){
	    						System.out.println("code 500 10 frame with three throws cannot have second and third throws as spares " + frame);
	    						return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    					}
	    					
	    					int secondCharInt = Character.getNumericValue(secondCharofFrame);
	    					int thirdCharInt = Character.getNumericValue(thirdCharofFrame);
	    					//if the second and third throw are numbers they cannot be greater than 10 or less than 0
	    					if (secondCharInt != -1 && thirdCharInt != -1){
		    					int sum = secondCharInt + thirdCharInt;
		    					if (sum > 10 || sum < 0){
		    						System.out.println("code 500 open 10th frame sum is greater than 10 or less than 0 for the second and third throw (sum,frame) " + sum + " " + frame);
		    						return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
		    					}
	    					}
	    					//third char can be spare
	    					//middle and last char can be x or number
	    					
	    			    //if 10th frame didnt use two or three throws we have an error
	    				}else{
	    					System.out.println("code 500 10th frame must have 2 or 3 rolls");
	    					return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    				}
	    				
	    			}else{
	    				if (frame.length() == 1){
	    					//validate if there is one char in a frame that it is a strike
	    					if (!frame.equalsIgnoreCase("x")){
	    						System.out.println("code 500 one shot thrown and wasnt marked as a strike "+ frame);
	    						return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    					}
	    				} else if (frame.length() == 2){
	    					
	    					if (frame.toLowerCase().contains("x")){
	    						System.out.println("code 500 cannot have two throws and contain a strike " + frame);
	    						return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    					}
	    					char firstCharofFrame = frame.charAt(0);
	    					char secondCharofFrame = frame.charAt(1);
	    					
	    					//validate the first throw in a frame cant be spare
	    					if (firstCharofFrame == spare){
	    						System.out.println("code 500 first throw of frame cannot be a spare " + frame);
	    						return new ResponseEntity<GameOutput>(gameOut, HttpStatus.CONFLICT);
	    					}
	    					
	    					if(secondCharofFrame != spare){
		    					int firstCharInt = Character.getNumericValue(firstCharofFrame);
		    					int secondCharInt = Character.getNumericValue(secondCharofFrame);
		    					int sum = firstCharInt + secondCharInt;
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
	    			//frames have been validated, add them to framelist for processing
	    			Integer frameCounter = i + 1;
	    			Frame processFrame = new Frame();
	    			processFrame.setFrameNumber(frameCounter);
	    			processFrame.setFrameString(frame.toLowerCase());
	    			frameList.add(processFrame);
	    			
	    		}

	    		Integer totalScore = calculateTotalScore(frameList);

	    		gameOut.setScore(totalScore);
	    	}else {
	    		System.out.println("code 500 bowling game string does not exist");
	    	}
	    }else{
	    	System.out.println("code 500 game not sent in request");
	    }
	    return new ResponseEntity<GameOutput>(gameOut, HttpStatus.OK);
	}//end post end point
	

//	process frames, calculate the score of each on them individually
//	X-7/-72-9/-X-X-X-23-6/-7/3
//	Frame:			1	2	3	4	5	6	7	8	9	10
//	Result:			X	7/	72	9/	X	X	X	23	6/	7/3
//	Frame Score:	20	17	9	20	30	22	15	5	17	13
//	Running Total:	20	37	46	66	96	118	133	138	155	168
	public static int calculateTotalScore(ArrayList<Frame> frameList) {
	   int totalScore = 0;
	   
		for (int i = 0; i < frameList.size(); i++) {
		   Frame currentBowlingframe = frameList.get(i);
		   String currentFrameString = currentBowlingframe.getFrameString();
		   char firstThrowOfCurrentFrame = currentFrameString.charAt(0);
		  
		   //if not the last frame
		   if (i != 9){
			   
			   //handle strike case for current frame
			   if (firstThrowOfCurrentFrame == 'x'){
				   Frame nextBowlingFrame = frameList.get(i+1);
				   String nextFrameString = nextBowlingFrame.getFrameString();
				   char firstThrowOfNextFrame = nextFrameString.charAt(0);
				   
				   //handle strike case for next frame, indicating two strikes in a row
				   if (firstThrowOfNextFrame == 'x'){
					   Frame lastBowlingFrame = frameList.get(i+2);
					   String lastFrameString = lastBowlingFrame.getFrameString();
					   char lastThrowOfLastFrame = lastFrameString.charAt(0);
					   
					   //handle three strikes in a row, a turkey has been hit
					   if (lastThrowOfLastFrame == 'x'){
						   currentBowlingframe.setFrameScore(30);
						   
					   //if the first and second throw were a strike but the third one wasnt
					   }else{
						   int thirdThrowOfLastFrameInteger = Character.getNumericValue(lastThrowOfLastFrame);
						   int sum = 20 + thirdThrowOfLastFrameInteger;
						   currentBowlingframe.setFrameScore(sum);
					   }
				   //if the first throw was a strike but the second one wasnt
				   }else{
					   char secondThrowOfNextFrame = nextFrameString.charAt(1);
					   int secondThrowOfNextFrameInteger = Character.getNumericValue(secondThrowOfNextFrame);
					   if (secondThrowOfNextFrameInteger == -1){
						   //second throw of next frame is spare
						   currentBowlingframe.setFrameScore(20);
						   
					   }else{
						   //second throw of next frame is open add the value of the first throw on the next frame and setscore
						   int firstThrowOfNextFrameInteger = Character.getNumericValue(firstThrowOfNextFrame);
						   int sum = secondThrowOfNextFrameInteger + firstThrowOfNextFrameInteger;
						   currentBowlingframe.setFrameScore(sum);
					   } 
				   }
				   //if the first throw was not a strike
			   }else{
				   char secondThrowOfCurrentFrame = currentFrameString.charAt(1);  
				   if (secondThrowOfCurrentFrame == '/' ){
					   Frame nextBowlingFrame = frameList.get(i+1);
					   String nextFrameString = nextBowlingFrame.getFrameString();
					   char firstThrowOfNextFrame = nextFrameString.charAt(0);
					   //if the first throw of the next frame is a strike, current score is 20
					   if (firstThrowOfNextFrame == 'x'){
						   currentBowlingframe.setFrameScore(20);
					   //if the first throw of next frame is not a strike add 10 for the spare and sum in the open value
					   }else{
						   int firstThrowOfNextFrameInteger = Character.getNumericValue(firstThrowOfNextFrame);
						   int sum = 10 + firstThrowOfNextFrameInteger;
						   currentBowlingframe.setFrameScore(sum);
					   }
					   //handle spare case
				   
				   }else{
					   //handle open case
					   }
			   }
		   }
			   
		}
		

	   
	   return totalScore; 
	}
}//end class gameController
