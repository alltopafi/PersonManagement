package alltop.personmanagement.personManagement.controller;

import alltop.personmanagement.personManagement.dto.Person;
import alltop.personmanagement.personManagement.sorting.SortByBirthDate;
import alltop.personmanagement.personManagement.sorting.SortByGender;
import alltop.personmanagement.personManagement.sorting.SortByLastName;
import edu.emory.mathcs.backport.java.util.Arrays;

public class SortingController {

//	 Output 1 – sorted by gender (females before males) then by last name ascending.
//	 Output 2 – sorted by birth date, ascending.
//	 Output 3 – sorted by last name, descending.
	
	public void handleSortOption(Person[] people, int choice) throws Exception {
		
		switch(choice) {
		case 1: sortByGender(people);
				break;
		case 2: sortByBirthDate(people);
				break;
		case 3: sortByLastNameDescending(people);
				break;
		default: //this should not be possible by included for test coverage
			throw new Exception("Invalid input - needed to be 1, 2, or 3");
		}
	}
	
	private void sortByGender(Person[] people) {
		Arrays.sort(people, new SortByGender());
		
		for(Object object : people) {
			System.out.println(object);
		}
	}
	
	private void sortByBirthDate(Person[] people) {
		Arrays.sort(people, new SortByBirthDate());
		
		for(Object object : people) {
			System.out.println(object);
		}
	}
	

	private void sortByLastNameDescending(Person[] people) {
		Arrays.sort(people, new SortByLastName());
		
		for(Object object : people) {
			System.out.println(object);
		}
	}
	
}
