package alltop.personmanagement.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
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

	@Value("classpath:personData.txt")
	private Resource personData;

//	POST /records - Post a single data line in any of the 3 formats supported by your existing code
	@RequestMapping(value = "/records/gender", method = RequestMethod.POST)
	public String addNewPerson(Person person) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(personData.getFile(), true));
	    writer.append("\n" + person.toString());
	    writer.close();
		return mapper.writeValueAsString(person);
	}
	
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
		String path = personData.getFile().getPath();
		Set<String> rawDataFromFile = fileReaderController.readFile(path);
		Set<Person> people = personTransformer.transformPersonsFromRawData(rawDataFromFile);
		Person[] result = people.toArray(new Person[people.size()]);
		sortingController.handleSortOption(result, sortingChoice);
		return mapper.writeValueAsString(result);
	}

}
