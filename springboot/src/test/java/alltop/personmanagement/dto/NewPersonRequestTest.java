package alltop.personmanagement.dto;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Method;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class NewPersonRequestTest {

	@Test
	public void pojoTest() {
		final String className = "alltop.personmanagement.dto.NewPersonRequest";

		assertPojoMethodsFor(className)
			.testing(Method.GETTER)
			.testing(Method.SETTER)
			.areWellImplemented();
	}
}
