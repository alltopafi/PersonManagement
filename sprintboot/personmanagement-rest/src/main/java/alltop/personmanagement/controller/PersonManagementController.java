package alltop.personmanagement.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import alltop.personmanagement.personManagement.controller.FileReaderController;
import alltop.personmanagement.personManagement.controller.SortingController;
import alltop.personmanagement.personManagement.dto.Person;
import alltop.personmanagment.personManagement.transformer.PersonTransformer;

@RestController
public class PersonManagementController {

	private final FileReaderController fileReaderController = new FileReaderController();
	private final PersonTransformer personTransformer = new PersonTransformer();
	private final SortingController sortingController = new SortingController();
	private final ObjectMapper mapper = new ObjectMapper();

	@Bean(name = "personData")
	public File namedFile() throws FileNotFoundException {
		File namedFile = ResourceUtils.getFile("classpath:personData.txt");
		return namedFile;
	}

//	POST /records - Post a single data line in any of the 3 formats supported by your existing code

//	GET /records/gender - returns records sorted by gender
	@RequestMapping(value = "/records/gender", method = RequestMethod.GET)
	public String returnSortedByGender() throws Exception {
		return sortingHelper(1);
	}

//	GET /records/birthdate - returns records sorted by birthdate
	@RequestMapping(value = "/records/birthdate", method = RequestMethod.GET)
	public String returnSortedByBirthdate() throws Exception {
		return sortingHelper(2);
	}

//	GET /records/name - returns records sorted by name
	@RequestMapping(value = "/records/name", method = RequestMethod.GET)
	public String returnSortedByName() throws Exception {
		return sortingHelper(3);
	}

	private String sortingHelper(int sortingChoice) throws Exception {
		String path = namedFile().getPath();
		Set<String> rawDataFromFile = fileReaderController.readFile(path);
		Set<Person> people = personTransformer.transformPersonsFromRawData(rawDataFromFile);
		Person[] result = people.toArray(new Person[people.size()]);
		sortingController.handleSortOption(result, sortingChoice);
		return mapper.writeValueAsString(result);
	}

}
