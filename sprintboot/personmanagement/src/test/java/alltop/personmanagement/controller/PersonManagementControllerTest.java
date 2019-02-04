package alltop.personmanagement.controller;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		  loader=AnnotationConfigContextLoader.class,
		  classes=PersonManagementController.class)
public class PersonManagementControllerTest {


	private PersonManagementController controller = new PersonManagementController();
	
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	private Set<String> expectedTestData;
	
	
	@Bean
    public File namedFile() throws IOException {
        return setup();
    }

	
	public File setup() throws IOException {
		
		File testDataFile = null;

		expectedTestData = new HashSet<>();
		expectedTestData.add("last1 first1 male1 orange1 01/12/1204");
		expectedTestData.add("last1 first1 male1 orange1 01/12/1204");
		expectedTestData.add("last2 | first2 | male2 | orange2 | 11/01/1254");
		expectedTestData.add("last3, first3, female3, blue3, 04/01/1404");

		BufferedWriter writer = new BufferedWriter(new FileWriter(testDataFile));
		for (String line : expectedTestData) {
			writer.write(line);
			writer.newLine();
		}
		writer.close();
		
		return testDataFile;
	}

	@Test
	public void testReturnSortByGender() throws Exception {
		String test = controller.returnSortedByGender();
		assertEquals("[{\"lastName\":\"STARK\",\"firstName\":\"ARYA\",\"gender\":\"FEMALE\",\"favoriteColor\":\"PINK\",\"dateOfBirth\":\"01/13/1984\"},{\"lastName\":\"Targaryen\",\"firstName\":\"daenerys\",\"gender\":\"female\",\"favoriteColor\":\"black\",\"dateOfBirth\":\"01/20/1970\"},{\"lastName\":\"DrOgO\",\"firstName\":\"KhAL\",\"gender\":\"male\",\"favoriteColor\":\"Brown\",\"dateOfBirth\":\"11/24/1974\"},{\"lastName\":\"Lannister\",\"firstName\":\"Tyrion\",\"gender\":\"male\",\"favoriteColor\":\"blue\",\"dateOfBirth\":\"01/01/1968\"},{\"lastName\":\"Seaworth\",\"firstName\":\"Davos\",\"gender\":\"male\",\"favoriteColor\":\"green\",\"dateOfBirth\":\"09/20/1941\"},{\"lastName\":\"SNOW\",\"firstName\":\"JON\",\"gender\":\"male\",\"favoriteColor\":\"black\",\"dateOfBirth\":\"01/19/1971\"}]",test);
	}
}
