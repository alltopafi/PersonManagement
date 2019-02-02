package alltop.personmanagement.personManagement;

import java.util.Set;

import alltop.personmanagement.personManagement.controller.FileReaderController;
import alltop.personmanagement.personManagement.controller.SelectionController;

/**
 * Hello world!
 *
 */
public class App {

	private static SelectionController selectionController = new SelectionController();
	private static FileReaderController fileReaderController = new FileReaderController();
	
	public static void main(String[] args) throws Exception {
		// Let's assume that the only arg is the file name and
		if (args.length != 1) {
			throw new Exception("Error: expected file to be passed as argument to read data from.");
		}

		// get which option to display
		int displayOption = selectionController.sortOptions();

		// read from file
		Set<String> rawDataFromFile = fileReaderController.readFile(args[0]);
	}

}
