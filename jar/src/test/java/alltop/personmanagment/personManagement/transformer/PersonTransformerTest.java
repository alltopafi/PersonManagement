package alltop.personmanagment.personManagement.transformer;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import alltop.personmanagement.personManagement.dto.Person;

public class PersonTransformerTest {

	private PersonTransformer transformer = new PersonTransformer();
	private Set<String> rawData;
	private Person expectedPerson1, expectedPerson2;

	@Before
	public void setupData() {
		rawData = new HashSet<String>();
		rawData.add("last, first, gender, color, dob");
		rawData.add("");

		expectedPerson1 = new Person("last", "first", "gender", "color", "dob");
		expectedPerson2 = new Person("ERROR_LAST_NAME", "ERROR_FIRST_NAME", "ERROR_GENDER", "ERROR_FAVORITE_COLOR",
				"ERROR_DATE_OF_BIRTH");
	}

	@Test
	public void testTransformPersonsFromRawData() {
		Set<Person> persons = transformer.transformPersonsFromRawData(rawData);

		assertTrue(persons.contains(expectedPerson1));
		assertTrue(persons.contains(expectedPerson2));

	}
}
