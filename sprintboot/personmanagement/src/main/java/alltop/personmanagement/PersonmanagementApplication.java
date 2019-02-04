package alltop.personmanagement;

import java.io.IOException;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import alltop.personmanagement.personManagement.controller.FileReaderController;
import alltop.personmanagement.personManagement.controller.SortingController;
import alltop.personmanagement.personManagement.dto.Person;
import alltop.personmanagment.personManagement.transformer.PersonTransformer;

@SpringBootApplication
@RestController
public class PersonmanagementApplication {
	
	private final FileReaderController fileReaderController = new FileReaderController();
	private final PersonTransformer personTransformer = new PersonTransformer();
	private final SortingController sortingController = new SortingController();
	private final ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) {
		SpringApplication.run(PersonmanagementApplication.class, args);
	}
	
//	POST /records - Post a single data line in any of the 3 formats supported by your existing code
//	GET /records/gender - returns records sorted by gender
//	GET /records/birthdate - returns records sorted by birthdate
//	GET /records/name - returns records sorted by name

	@RequestMapping(value="/records/gender", method = RequestMethod.GET)
	public String returnSortedByGender() throws Exception {
		String path = ResourceUtils.getFile("classpath:personData.txt").getPath();
		Set<String> rawDataFromFile = fileReaderController.readFile(path);
		Set<Person> people = personTransformer.transformPersonsFromRawData(rawDataFromFile);
		Person[] temp = people.toArray(new Person[people.size()]);
		sortingController.handleSortOption(temp, 1);

		
		return mapper.writeValueAsString(temp);
	}

}