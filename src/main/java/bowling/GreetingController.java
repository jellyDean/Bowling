package bowling;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    	
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
    
    //api/v0/platform/get_bowling_score
	@RequestMapping(value = "/")
	public ResponseEntity<Car> get() {
	    Car car = new Car();
	    car.setColor("Blue");
	    car.setMiles(100);
	    car.setVIN("1234");

	    return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
}
