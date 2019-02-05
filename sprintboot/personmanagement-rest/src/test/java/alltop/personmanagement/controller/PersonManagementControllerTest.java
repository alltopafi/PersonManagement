package alltop.personmanagement.controller;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.util.ReflectionTestUtils;

import alltop.personmanagement.personManagement.dto.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		  loader=AnnotationConfigContextLoader.class,
		  classes=PersonManagementController.class)
public class PersonManagementControllerTest {


	private PersonManagementController controller = new PersonManagementController();

	private Set<String> expectedTestData;
	
	@Mock
	private Resource testResource;
    private File testDataFile;

	@Before
	public void setup() throws IOException {
		
		testDataFile = new File("./target/testFile.txt");

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
		Mockito.when(testResource.getFile()).thenReturn(testDataFile);
		ReflectionTestUtils.setField(controller, "personData", testResource);
	}
	
	@Test
	public void testAddNewPerson() throws Exception {
		Person testPerson = new Person("testLast", "testFirst", "male", "testColor", "01/20/1988");
		String testResult = controller.addNewPerson(testPerson);
		assertEquals("{\"lastName\":\"testLast\",\"firstName\":\"testFirst\",\"gender\":\"male\",\"favoriteColor\":\"testColor\",\"dateOfBirth\":\"01/20/1988\"}", testResult);
	}

	@Test
	public void testReturnSortByGender() throws Exception {
		String test = controller.returnSortedByGender();
		assertEquals("[{\"lastName\":\"last3\",\"firstName\":\"first3\",\"gender\":\"female3\",\"favoriteColor\":\"blue3\",\"dateOfBirth\":\"04/01/1404\"},{\"lastName\":\"last1\",\"firstName\":\"first1\",\"gender\":\"male1\",\"favoriteColor\":\"orange1\",\"dateOfBirth\":\"01/12/1204\"},{\"lastName\":\"last2\",\"firstName\":\"first2\",\"gender\":\"male2\",\"favoriteColor\":\"orange2\",\"dateOfBirth\":\"11/01/1254\"}]",test);
	}
	
	@Test
	public void testReturnSortByBirthdate() throws Exception {
		String test = controller.returnSortedByBirthdate();
		assertEquals("[{\"lastName\":\"last1\",\"firstName\":\"first1\",\"gender\":\"male1\",\"favoriteColor\":\"orange1\",\"dateOfBirth\":\"01/12/1204\"},{\"lastName\":\"last2\",\"firstName\":\"first2\",\"gender\":\"male2\",\"favoriteColor\":\"orange2\",\"dateOfBirth\":\"11/01/1254\"},{\"lastName\":\"last3\",\"firstName\":\"first3\",\"gender\":\"female3\",\"favoriteColor\":\"blue3\",\"dateOfBirth\":\"04/01/1404\"}]",test);
	}
	
	@Test
	public void testReturnSortByName() throws Exception {
		String test = controller.returnSortedByName();
		assertEquals("[{\"lastName\":\"last3\",\"firstName\":\"first3\",\"gender\":\"female3\",\"favoriteColor\":\"blue3\",\"dateOfBirth\":\"04/01/1404\"},{\"lastName\":\"last2\",\"firstName\":\"first2\",\"gender\":\"male2\",\"favoriteColor\":\"orange2\",\"dateOfBirth\":\"11/01/1254\"},{\"lastName\":\"last1\",\"firstName\":\"first1\",\"gender\":\"male1\",\"favoriteColor\":\"orange1\",\"dateOfBirth\":\"01/12/1204\"}]",test);
	}
}
