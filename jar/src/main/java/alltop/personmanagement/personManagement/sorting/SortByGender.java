package alltop.personmanagement.personManagement.sorting;

import java.util.Comparator;

import org.apache.commons.lang3.StringUtils;

import alltop.personmanagement.personManagement.dto.Person;

public class SortByGender implements Comparator<Person> {

//	 Output 1 – sorted by gender (females before males) then by last name ascending.

	@Override
	public int compare(Person p1, Person p2) {

		if (StringUtils.equalsAnyIgnoreCase(p1.getGender(), p2.getGender())) {
			return p1.getLastName().compareToIgnoreCase(p2.getLastName());
		} else {
			return p1.getGender().compareToIgnoreCase(p2.getGender());
		}

	}

}
