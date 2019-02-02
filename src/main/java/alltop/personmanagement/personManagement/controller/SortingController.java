package alltop.personmanagement.personManagement.controller;

import alltop.personmanagement.personManagement.dto.Person;
import alltop.personmanagement.personManagement.sorting.SortByGender;
import edu.emory.mathcs.backport.java.util.Arrays;

public class SortingController {

	
//	 Output 1 – sorted by gender (females before males) then by last name ascending.
//	 Output 2 – sorted by birth date, ascending.
//	 Output 3 – sorted by last name, descending.
	
	
	public void sortByGender(Person[] people) {
		Arrays.sort(people, new SortByGender());
		
		for(Object object : people) {
			System.out.println(object);
		}
	}
	

}
