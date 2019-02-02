package alltop.personmanagement.personManagement.controller;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class FileReaderControllerTest {

	private FileReaderController controller = new FileReaderController();

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	private Set<String> expectedTestData;

	@Before
	public void setup() {
		expectedTestData = new HashSet<>();
		expectedTestData.add("last1 first1 male1 orange1 1/12/1204");
		expectedTestData.add("last1 first1 male1 orange1 1/12/1204");
		expectedTestData.add("last2 | first2 | male2 | orange2 | 11/1/1254");
		expectedTestData.add("last3, first3, female3, blue3, 4/01/1404");
	}

	@Test(expected = IOException.class)
	public void testReadFileInvalidFile() throws IOException {
		controller.readFile("testFileString");
	}

	@Test
	public void testReadFile() throws IOException {
		File output = tempFolder.newFile("output.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(output));
		for (String line : expectedTestData) {
			writer.write(line);
			writer.newLine();
		}
		writer.close();

		Set<String> results = controller.readFile(output.getAbsolutePath());

		assertEquals(expectedTestData, results);
	}
}
