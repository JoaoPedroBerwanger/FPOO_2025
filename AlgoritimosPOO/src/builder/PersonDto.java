package builder;

import java.time.LocalDate;
import java.time.Period;

public record PersonDto(
		
		String firstName, 
		String midleName, 
		String familyName, 
		Character gender, 
		LocalDate dateOfBirth,
		String motherFullName, 
		String RG, 
		String CPF, 
		MaritalStatus maritalStatus,
		String ethnicity, 
		String skinColor, 
		String eyeColor,
		String hairColor, 
		Double height, 
		Double wheight, 
		String phone, 
		String mobilePhone, 
		String email
		
) {

	static public enum MaritalStatus { MARIAGE, SINGLE, WIDOW, DIVORCED};
	
	public Integer age() {
		Period period = Period.between(dateOfBirth, LocalDate.now());
		return period.getYears();		
	}
	
	public String fullName() {
		String fullName = firstName;
		fullName = midleName.isBlank() ? fullName : fullName + ' ' + midleName;
		fullName = familyName.isBlank() ? fullName : fullName + ' ' + familyName;
		return fullName;
	}
}
