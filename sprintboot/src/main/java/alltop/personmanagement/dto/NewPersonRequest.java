package alltop.personmanagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "NewPersonRequest", description = "Represents a user to be added to data")
public class NewPersonRequest {
	
	@ApiModelProperty(required = true, position = 0)
	private String lastName;
	@ApiModelProperty(required = true, position = 1)
	private String firstName;
	@ApiModelProperty(required = true, position = 2)
	private GenderEnum gender;
	@ApiModelProperty(required = true, position = 3)
	private String favoriteColor;
	@ApiModelProperty(required = true, example="MM/dd/YYYY", position = 4)
	private String dateOfBirth;
	
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
	public GenderEnum getGender() {
		return gender;
	}
	public void setGender(GenderEnum gender) {
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
