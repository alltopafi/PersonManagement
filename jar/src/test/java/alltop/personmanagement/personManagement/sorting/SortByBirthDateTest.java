package alltop.personmanagement.personManagement.sorting;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import alltop.personmanagement.personManagement.dto.Person;

public class SortByBirthDateTest {
	private SortByBirthDate sortByBirthDate = new SortByBirthDate();

	private Person person0;
	private Person person1;
	private Person person2;

	@Before
	public void setup() {
		person0 = new Person("alast", "first", "male", "color", "01/11/1941");
		person1 = new Person("qlast", "first1", "male", "color1", "11/11/1929");
		person2 = new Person("zlast", "first2", "female", "color", "01/12/1941");
	}

	@Test
	public void testCompare() {
		assertEquals(0, sortByBirthDate.compare(person0, person0));
		assertEquals(12, sortByBirthDate.compare(person0, person1));
		assertEquals(-1, sortByBirthDate.compare(person0, person2));

		assertEquals(-12, sortByBirthDate.compare(person1, person0));
		assertEquals(0, sortByBirthDate.compare(person1, person1));
		assertEquals(-12, sortByBirthDate.compare(person1, person2));

		assertEquals(1, sortByBirthDate.compare(person2, person0));
		assertEquals(12, sortByBirthDate.compare(person2, person1));
		assertEquals(0, sortByBirthDate.compare(person2, person2));

	}
}
