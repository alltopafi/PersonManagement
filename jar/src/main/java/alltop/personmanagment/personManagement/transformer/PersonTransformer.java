package alltop.personmanagment.personManagement.transformer;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import alltop.personmanagement.personManagement.dto.Person;

public class PersonTransformer {

	public Set<Person> transformPersonsFromRawData(Set<String> rawDataLines) {
		Set<Person> peopleSet = new HashSet<>();
		for(String line : rawDataLines) {
			peopleSet.add(convertDataToPerson(line));
		}
		
		return peopleSet;
	}
	
	private Person convertDataToPerson(String data) {
		StringTokenizer tokenizer = new StringTokenizer(data, " ,|");
		Person person = new Person();
		person.setLastName(tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "ERROR_LAST_NAME");
		person.setFirstName(tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "ERROR_FIRST_NAME");
		person.setGender(tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "ERROR_GENDER");
		person.setFavoriteColor(tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "ERROR_FAVORITE_COLOR");
		person.setDateOfBirth(tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "ERROR_DATE_OF_BIRTH");
		return person;
	}
}
