package alltop.personmanagement.personManagement.controller;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import alltop.personmanagement.personManagement.dto.Person;

public class SortingControllerTest {

	private SortingController sortingController;
	private Person[] people;

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	private Person person0;
	private Person person1;
	private Person person2;

	@Before
	public void setup() {
		sortingController = new SortingController();
		System.setOut(new PrintStream(outContent));

		person0 = new Person("alast", "first", "male", "color", "01/22/2000");
		person1 = new Person("qlast", "first1", "male", "color1", "01/23/2000");
		person2 = new Person("zlast", "first2", "female", "color", "09/20/1988");

		people = new Person[3];
		people[0] = person0;
		people[1] = person1;
		people[2] = person2;
	}

	@After
	public void restoreStreams() throws IOException {
		System.setOut(originalOut);
		System.in.close();
	}

	@Test
	public void testSortByGender() {
		sortingController.sortByGender(people);
		
		assertEquals("zlast first2 female color 09/20/1988\n" + 
				"alast first male color 01/22/2000\n" + 
				"qlast first1 male color1 01/23/2000\n", outContent.toString());
		
		assertEquals(person2, people[0]);
		assertEquals(person0, people[1]);
		assertEquals(person1, people[2]);

	}
	
	@Test
	public void testSortByBirthDate() {
		sortingController.sortByBirthDate(people);
		
		assertEquals("zlast first2 female color 09/20/1988\n" + 
				"alast first male color 01/22/2000\n" + 
				"qlast first1 male color1 01/23/2000\n", outContent.toString());
		
		assertEquals(person2, people[0]);
		assertEquals(person0, people[1]);
		assertEquals(person1, people[2]);
	}

	@Test
	public void testSortByLastNameDescending() {
		sortingController.sortByLastNameDescending(people);
		
		assertEquals("zlast first2 female color 09/20/1988\n" + 
				"qlast first1 male color1 01/23/2000\n" + 
				"alast first male color 01/22/2000\n", outContent.toString());

		assertEquals(person2, people[0]);
		assertEquals(person1, people[1]);
		assertEquals(person0, people[2]);
	}
}
