Bowling Score calculator exercise
=================

Write a web service using Spring that calculates the score of a bowling game.

# Resources

How to score bowling:
http://slocums.homestead.com/gamescore.html

Bowling score calculator (use this to verify your solution):
http://tralvex.com/pub/bowling/BSC.htm

# Input Format
The game will be provided to your service via POST. The endpoint path can be whatever you'd like. The request body will be a JSON message like this:

    {
      "bowlingGame": "<game string>"
    }
    
The game string will have this format:

    f-f-f-f-f-f-f-f-f-f

where `f` is a single frame of the game, and each frame is separated by a single hyphen (`-`) character. Each frame is represented by at least one character, representing the roll(s) of the frame.

Frames 1-9 can have **either** one or two characters:

* A strike is represented by a single 'X'.
* A spare is represented by any number less than 10 (1-9), followed by a '/'.
* An open frame is represented by two numbers less than 10, whose sum is also less than 10.

Frame 10 can have **either** two or three characters:

* If the first roll of the tenth frame is a Strike, the frame will contain three characters. The last two characters of the frame represent the bonus rolls used to resolve the score of the strike.
* If the first two rolls of the tenth frame are a Spare, the frame will contain three characters. The last character of the frame is the bonus roll used to resolve the score of the spare.
* Otherwise, the frame is an open frame and it will contain only two characters.

## Example frames:
* `X` - is a strike
* `8/` - is a spare, where the first roll knocked down 8 pins
* `70` - is an open frame, where the first roll knocked down 7 pins, and the second roll knocked down 0 pins
* `00` - is an open frame, where both rolls knocked down zero pins
* `5/5` - is the tenth frame, containing a bonus roll to resolve the score of the spare.
* `X17` - is the tenth frame, containing two bonus rolls to resolve the score of the strike

## Example Games

* `X-X-X-X-X-X-X-X-X-XXX` Score: 300

* `5/-5/-5/-5/-5/-5/-5/-5/-5/-5/5` Score: 150

* `X-0/-23-71-9/-63-00-90-X-XX3` Score: 132

* `00-00-00-00-00-00-00-00-00-00` Score: 0. Note the absence of a third roll in the tenth frame - since it is an open frame, there are no bonus rolls needed.

# Requirements

## Response
1. Your response must be a JSON object.
2. Your response must contain a key, "score", which contains the total score of the game. For example,

    {
      "score": 300
    }

## Bonus Challenges
1. In addition to the total score, report the total score at each frame individually. For example,

    5/-5/-5/-5/-5/-5/-5/-5/-5/-5/5
    Frame:	1	2	3	4	5	6	7	8	9	10
    Score:	15	30	45	60	75	90	105	120	135	150
  
  This information must be contained in a new key of your response, "frameScores". This key must map to an array of 10 elements,
  where each element is the total score at the frame matching that index. The above example would look like this:
  
    {
      "score": 150,
      "frameScores": [15, 30, 45, 60, 75, 90, 105, 120, 135, 150]
    }
  

2. In addition to the total score, report the number of "turkeys" scored by the player.
   A turkey is scored for each mutually exclusive, consecutive trio of strikes.
   For reference, a perfect game (all strikes) has a total of four turkeys.
   Frames 1-3, 4-6, 7-9, and the tenth frame (consisting of a strike and two bonus strike rolls)
   are each a turkey.
   
   This information must be contained in a new key of your response, "turkeys". This key must map to the number of turkeys in the game.
   For example,   
   
    {
      "score": 300,
      "turkeys": 4
    }
    
# Submission
You may submit your code in any format you wish, as long as we can see the code and run it. You should package a build script for whatever build tool you like. Preferably, the application should build with an embedded application server, but if it simply produces a war file or similar object that is fine as well.

You are also encouraged to submit your code through some kind of source control system, such as git. Create a repository on Github, Bitbucket, or any hosting of your choosing that you can send a link to.

Finally, include a README that describes how to build, run, and interact with your service