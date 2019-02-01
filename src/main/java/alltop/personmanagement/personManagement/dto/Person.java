package alltop.personmanagement.personManagement.dto;

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
}
