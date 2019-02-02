package alltop.personmanagement.personManagement.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileReaderController {

	public Set<String> readFile(String fileName) throws IOException {
		File file = new File(fileName);
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);

		String line;
		Set<String> rawPersonData = new HashSet<>();
		while ((line = buffer.readLine()) != null) {
			rawPersonData.add(line);
		}

		reader.close();
		return rawPersonData;
	}

}
