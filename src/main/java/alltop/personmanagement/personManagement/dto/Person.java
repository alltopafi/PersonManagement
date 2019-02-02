package alltop.personmanagement.personManagement.dto;

import org.apache.commons.lang3.StringUtils;

public class Person {

	private String lastName;
	private String firstName;
	private String gender;
	private String favoriteColor;
	private String dateOfBirth;

	public Person() {

	}

	public Person(String lastName, String firstName, String gender, String favoriteColor, String dateOfBirth) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
		this.favoriteColor = favoriteColor;
		this.dateOfBirth = dateOfBirth;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFavoriteColor() {
		return favoriteColor;
	}

	public void setFavoriteColor(String favoriteColor) {
		this.favoriteColor = favoriteColor;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Person)) {
			return false;
		}

		Person temp = (Person) o;

		if (StringUtils.equals(lastName, temp.lastName) &&
				StringUtils.equals(firstName, temp.firstName) &&
				StringUtils.equals(gender, temp.gender) &&
				StringUtils.equals(favoriteColor, temp.favoriteColor) &&
				StringUtils.equals(dateOfBirth, temp.dateOfBirth)) {
			return true;
		}
		return false;

	}

	@Override
	public int hashCode() {
		int l = lastName != null ? lastName.hashCode() : 0; 
		int f =	firstName != null ? firstName.hashCode() : 0; 
		int g = gender != null ? gender.hashCode() : 0;
		int c = favoriteColor != null ? favoriteColor.hashCode() : 0;
		int d = dateOfBirth != null ? dateOfBirth.hashCode() : 0;
		
		return l+f+g+c+d;
	}
	
	@Override
	public String toString() {
		return lastName + " " + firstName + " " + gender + " " + favoriteColor + " " + dateOfBirth;
	}
}
