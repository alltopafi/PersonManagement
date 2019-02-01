package alltop.personmanagement.personManagement.dto;

import org.junit.Test;

import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class PersonTest {

	@Test
	public void testPersonDTO() {

		final String className = "alltop.personmanagement.personManagement.dto.Person";

		assertPojoMethodsFor(className).testing(Method.GETTER)
									   .testing(Method.CONSTRUCTOR)
									   .areWellImplemented();
	}
}
