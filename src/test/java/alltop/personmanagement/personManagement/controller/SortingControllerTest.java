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

		person0 = new Person("alast", "first", "male", "color", "dateOfBirth");
		person1 = new Person("qlast", "first1", "male", "color1", "dateOfBirth1");
		person2 = new Person("zlast", "first2", "female", "color", "dateOfBirth");

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
		assertEquals("zlast first2 female color dateOfBirth\n" + "alast first male color dateOfBirth\n"
				+ "qlast first1 male color1 dateOfBirth1\n" + "", outContent.toString());

		assertEquals(person0, people[1]);
		assertEquals(person1, people[2]);
		assertEquals(person2, people[0]);

	}
}
