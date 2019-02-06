package alltop.personmanagement.personManagement.sorting;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

import alltop.personmanagement.personManagement.dto.Person;

public class SortByBirthDate implements Comparator<Person> {

//	 Output 2 – sorted by birth date, ascending.

	@Override
	public int compare(Person p1, Person p2) {
		//create formatter for expected date string format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

		//Get date Objects to compare 
		LocalDate p1BirthDate = LocalDate.parse(p1.getDateOfBirth(), formatter);
		LocalDate p2BirthDate = LocalDate.parse(p2.getDateOfBirth(), formatter);
		
		//compare year, month, day
		return p1BirthDate.compareTo(p2BirthDate);
		}
	
}
