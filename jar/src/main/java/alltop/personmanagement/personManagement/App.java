package alltop.personmanagement.personManagement;

import java.util.Set;

import alltop.personmanagement.personManagement.controller.FileReaderController;
import alltop.personmanagement.personManagement.controller.SelectionController;
import alltop.personmanagement.personManagement.controller.SortingController;
import alltop.personmanagement.personManagement.dto.Person;
import alltop.personmanagment.personManagement.transformer.PersonTransformer;

/**
 * Hello world!
 *
 */
public class App {

	private static SelectionController selectionController = new SelectionController();
	private static FileReaderController fileReaderController = new FileReaderController();
	private static PersonTransformer personTransformer = new PersonTransformer();
	private static SortingController sortingController = new SortingController();
	
	public static void main(String[] args) throws Exception {
		// Let's assume that the only arg is the file name and
		if (args.length != 1) {
			throw new Exception("Error: expected file to be passed as argument to read data from.");
		}

		// read from file
		Set<String> rawDataFromFile = fileReaderController.readFile(args[0]);
		
		//transform the rawData to a set of Persons
		Set<Person> people = personTransformer.transformPersonsFromRawData(rawDataFromFile);

		// get which option to display
		int displayOption = selectionController.sortOptions();
		
		sortingController.handleSortOption(people.toArray(new Person[people.size()]), displayOption);

	}

}
