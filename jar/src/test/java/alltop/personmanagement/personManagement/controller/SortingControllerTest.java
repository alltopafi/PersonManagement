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
	public void testSortByGender() throws Exception {
		sortingController.handleSortOption(people, 1);
		
		assertEquals("ZLAST FIRST2 FEMALE COLOR 9/20/1988\n" + 
				"ALAST FIRST MALE COLOR 1/22/2000\n" + 
				"QLAST FIRST1 MALE COLOR1 1/23/2000\n", outContent.toString());
		
		assertEquals(person2, people[0]);
		assertEquals(person0, people[1]);
		assertEquals(person1, people[2]);

	}
	
	@Test
	public void testSortByBirthDate() throws Exception {
		sortingController.handleSortOption(people, 2);
		
		assertEquals("ZLAST FIRST2 FEMALE COLOR 9/20/1988\n" + 
				"ALAST FIRST MALE COLOR 1/22/2000\n" + 
				"QLAST FIRST1 MALE COLOR1 1/23/2000\n", outContent.toString());
		
		assertEquals(person2, people[0]);
		assertEquals(person0, people[1]);
		assertEquals(person1, people[2]);
	}

	@Test
	public void testSortByLastNameDescending() throws Exception {
		sortingController.handleSortOption(people, 3);
		
		assertEquals("ZLAST FIRST2 FEMALE COLOR 9/20/1988\n" + 
				"QLAST FIRST1 MALE COLOR1 1/23/2000\n" + 
				"ALAST FIRST MALE COLOR 1/22/2000\n", outContent.toString());

		assertEquals(person2, people[0]);
		assertEquals(person1, people[1]);
		assertEquals(person0, people[2]);
	}
	
	@Test(expected=Exception.class)
	public void testInvalidInput() throws Exception {
		sortingController.handleSortOption(people, 7);
	}
}
