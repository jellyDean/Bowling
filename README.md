# Bowling readme
Build:<br />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Importing the project into STS (Spring Tool Suite):<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.) Download Spring Tool Suite and create a new web service project named Bowling.  <br />
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; a.) Open STS and select File->New->Import Spring Getting Started Content <br /> 
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; b.) Select Rest Service from the list and check "inital" and "complete"  <br />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; c.) Click Finish  <br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.) Clone the "git@github.com:jellyDean/Bowling.git" repo from GitHub  <br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.) Copy the code from "Bowling/src/main/java/bowling/" inside the repo to "/gs-rest-service-initial/src/main/java/hello/"<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4.) Right click on the "hello" folder at "/gs-rest-service-initial/src/main/java/hello/" and rename it to "bowling"<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.) Right click on the "gs-rest-service-initial" project and select Refractor->Rename and rename it to "Bowling"<br />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Create an JAR file with embedded web server:<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.) After importing the project into STS we can now use Maven to create an executabe JAR file with embedded web server<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.) Right mouse button on the "Bowling" project name select Run As-> Maven install<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.) "/bowling/target/gs-rest-service-0.1.0.jar" will be created in the target directory <br />
		
Run:<br />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Running with STS<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.) Right click on "bowling" project and select Run As->Spring Boot App<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.) The web service can now be interacted with<br />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Running stand alone JAR<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.) Open terminal/command prompt<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.) Navigate to "/bowling/target/" where gs-rest-service-0.1.0.jar is located<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.) Type "java -jar gs-rest-service-0.1.0.jar"<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4.) The web service will start and can now be interacted with. This JAR file can be used anywhere and is not directory specific.<br />
		
		
Interact:<br />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.) Open a web browser with a REST client<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; a.) I used Google Chrome with the Advanced Rest Client plugin located here "https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo?hl=en-US"<br />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.) Type "http://localhost:8080/api/v0/platform/get_bowling_score" into the URL box<br />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.) Select "POST" as the method type<br />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4.) Type in your pay load with bowlingGame input e.g. {"bowlingGame": "X-34-x-9/-x-x-x-90-X-xxx"}<br />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.) Select "application/json" as content type<br />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 6.) Click Send<br />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 7.) Assuming your input is valid the response will be {"score":211,"code":200,"message":"Success","turkeys":2,"frameScores":[17,7,20,20,30,29,19,9,30,30]}<br />
	
	
		
		

