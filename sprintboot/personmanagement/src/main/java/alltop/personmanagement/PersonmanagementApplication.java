package alltop.personmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PersonmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonmanagementApplication.class, args);
	}
	
//	POST /records - Post a single data line in any of the 3 formats supported by your existing code
//	GET /records/gender - returns records sorted by gender
//	GET /records/birthdate - returns records sorted by birthdate
//	GET /records/name - returns records sorted by name

	@RequestMapping(value="/")
	public String name() {
		return "Avaliable operations:\n" +
				"POST /records - Post a single data line in any of the 3 formats supported by your existing code\n" + 
				"GET /records/gender - returns records sorted by gender\n" + 
				"GET /records/birthdate - returns records sorted by birthdate\n" + 
				"GET /records/name - returns records sorted by name";
	}

}