package alltop.personmanagement.personManagement.sorting;

import java.util.Comparator;

import alltop.personmanagement.personManagement.dto.Person;

public class SortByLastName implements Comparator<Person> {

//	 Output 3 – sorted by last name, descending.

	@Override
	public int compare(Person p1, Person p2) {

		return -(p1.getLastName().compareToIgnoreCase(p2.getLastName()));

	}
}
