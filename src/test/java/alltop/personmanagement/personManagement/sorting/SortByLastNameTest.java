package alltop.personmanagement.personManagement.sorting;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import alltop.personmanagement.personManagement.dto.Person;

public class SortByLastNameTest {

	private SortByLastName sortByLastName = new SortByLastName();

	private Person person0;
	private Person person1;
	private Person person2;

	@Before
	public void setup() {
		person0 = new Person("alast", "first", "male", "color", "dateOfBirth");
		person1 = new Person("qlast", "first1", "male", "color1", "dateOfBirth1");
		person2 = new Person("zlast", "first2", "female", "color", "dateOfBirth");
	}
	
	@Test
	public void testCompare() {
		assertEquals(0, sortByLastName.compare(person0, person0));
		assertEquals(16, sortByLastName.compare(person0, person1));
		assertEquals(25, sortByLastName.compare(person0, person2));
		
		assertEquals(-16, sortByLastName.compare(person1, person0));
		assertEquals(0, sortByLastName.compare(person1, person1));
		assertEquals(9, sortByLastName.compare(person1, person2));
		
		assertEquals(-25, sortByLastName.compare(person2, person0));
		assertEquals(-9, sortByLastName.compare(person2, person1));
		assertEquals(0, sortByLastName.compare(person2, person2));

	}
}
