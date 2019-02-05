package alltop.personmanagement.transformer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import alltop.personmanagement.dto.GenderEnum;
import alltop.personmanagement.dto.NewPersonRequest;
import alltop.personmanagement.personManagement.dto.Person;

public class NewPersonRequestTransformerTest {

	private NewPersonRequestTransformer transformer = new NewPersonRequestTransformer();

	@Test
	public void testTransformPerson() {
		NewPersonRequest request = new NewPersonRequest();
		request.setLastName("testLast");
		request.setFirstName("testFirst");
		request.setGender(GenderEnum.MALE);
		request.setFavoriteColor("blue");
		request.setDateOfBirth("11/24/1992");

		Person result = transformer.transformPerson(request);

		assertEquals(request.getLastName(), result.getLastName());
		assertEquals(request.getFirstName(), result.getFirstName());
		assertEquals(request.getGender().name(), result.getGender());
		assertEquals(request.getFavoriteColor(), result.getFavoriteColor());
		assertEquals(request.getDateOfBirth(), result.getDateOfBirth());
	}
}
