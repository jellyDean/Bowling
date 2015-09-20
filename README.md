# Bowling
describes how to build, run, and interact the service
http://localhost:8080/api/v0/platform/get_bowling_score

Build:
	Importing the project into STS (Spring Tool Suite):
		1.) Download Spring Tool Suite and create a new web service project named Bowling.
			a.) Open STS and select File->New->Import Spring Getting Started Content
			b.) Select Rest Service from the list and check "inital" and "complete"
			c.) Click Finish
		2.) Clone the "git@github.com:jellyDean/Bowling.git" repo from GitHub
		3.) Copy the code from "Bowling/src/main/java/bowling/" inside the repo to "/gs-rest-service-initial/src/main/java/hello/"
		4.) Right click on the "hello" folder at "/gs-rest-service-initial/src/main/java/hello/" and rename it to "bowling"
		5.) Right click on the "gs-rest-service-initial" project and select Refractor->Rename and rename it to "Bowling"
	Create an JAR file with embedded web server:
		1.) After importing the project into STS we can now use Maven to create an executabe JAR file with embedded web server
		2.) Right mouse button on the "Bowling" project name select Run As-> Maven install
		3.) "/bowling/target/gs-rest-service-0.1.0.jar" will be created in the target directory 
		
Run:
	Running with STS
		1.) Right click on "bowling" project and select Run As->Spring Boot App
		2.) The web service can now be interacted with
	Running stand alone JAR
		1.) Open terminal/command prompt=
		2.) Navigate to "/bowling/target/" where gs-rest-service-0.1.0.jar is located
		3.) Type "java -jar gs-rest-service-0.1.0.jar"
		4.) The web service will start and can now be interacted with. This JAR file can be used anywhere and is not directory specific.
		
		
Interact:
	1.) Open a web browser with a REST client
		a.) I used Google Chrome with the Advanced Rest Client plugin located here "https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo?hl=en-US"
	2.) Type "http://localhost:8080/api/v0/platform/get_bowling_score" into the URL box
	3.) Select "POST" as the method type
	4.) Type in your pay load with bowlingGame input e.g. {"bowlingGame": "X-34-x-9/-x-x-x-90-X-xxx"}
	5.) Select "application/json" as content type
	6.) Click Send
	7.) Assuming your input is valid the response will be {"score":211,"code":200,"message":"Success","turkeys":2,"frameScores":[17,7,20,20,30,29,19,9,30,30]}
	
	
		
		

