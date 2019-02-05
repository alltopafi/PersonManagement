package alltop.personmanagement.transformer;

import alltop.personmanagement.dto.NewPersonRequest;
import alltop.personmanagement.personManagement.dto.Person;

public class NewPersonRequestTransformer {

	public Person transformPerson(NewPersonRequest request) {
		Person person = new Person();
		person.setLastName(request.getLastName());
		person.setFirstName(request.getFirstName());
		person.setGender(request.getGender().name());
		person.setFavoriteColor(request.getFavoriteColor());
		person.setDateOfBirth(request.getDateOfBirth());
		return person;	
	}
}
