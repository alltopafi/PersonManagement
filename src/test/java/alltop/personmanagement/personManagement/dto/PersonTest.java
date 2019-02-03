package alltop.personmanagement.personManagement.dto;

import org.junit.Test;

import pl.pojo.tester.api.assertion.Method;

import static org.junit.Assert.assertEquals;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class PersonTest {

	@Test
	public void testPersonDTO() {

		final String className = "alltop.personmanagement.personManagement.dto.Person";

		assertPojoMethodsFor(className)
			.testing(Method.GETTER)
			.testing(Method.SETTER)
			.testing(Method.CONSTRUCTOR)
			.testing(Method.HASH_CODE)
			.testing(Method.EQUALS)
			.areWellImplemented();
	}
	
	@Test
	public void testHashCodeAndToString() {
		Person person = new Person("a","b","c","d","09/20/1992");
		assertEquals(-1931030538,person.hashCode());
		assertEquals("A B C D 09/20/1992", person.toString());
				
	}
}
