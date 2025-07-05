package builder;

import java.time.LocalDate;

import builder.PersonDto.MaritalStatus;

public class PersonDtoBuilder {

	private String firstName;
	private String midleName;
	private String familyName;
	private Character gender;
	private LocalDate dateOfBirth;
	private String motherFullName;
	private String RG; 
	private String CPF;
	private MaritalStatus maritalStatus;
	private String ethnicity; 
	private String skinColor; 
	private String eyeColor; 
	private String hairColor;
	private Double height; 
	private Double wheight; 
	private String phone; 
	private String mobilePhone; 
	private String email;
	
	public PersonDtoBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public PersonDtoBuilder midleName(String midleName) {
		this.midleName = midleName;
		return this;
	}
	
	public PersonDtoBuilder familyName(String familyName) {
		this.familyName = familyName;
		return this;
	}
	
	public PersonDtoBuilder gender(Character gender) {
		this.gender = gender;
		return this;
	}
	
	public PersonDtoBuilder dateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}
	

	private PersonDto build() {
		
		return new PersonDto(
				firstName, 
				midleName, 
				familyName, 
				gender, 
				dateOfBirth,
				motherFullName, 
				RG, 
				CPF, 
				maritalStatus,
				ethnicity, 
				skinColor, 
				eyeColor,
				hairColor, 
				height, 
				wheight, 
				phone, 
				mobilePhone, 
				email
		);	
	}
	
	public static void main(String[] args) {
		
		PersonDtoBuilder builder = new PersonDtoBuilder();
		
		PersonDto dto = builder
				.firstName("Joao")
				.midleName("Pedro")
				.build();
		
		System.out.println(dto);
	}

}
