package builder;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import builder.PersonDto.MaritalStatus;

public class Person {

	private final String firstName;
	private final String midleName;
	private final String familyName;
	private final Character gender;
	private final LocalDate dateOfBirth;
	private final String motherFullName;
	private final String RG; 
	private final String CPF;
	private final MaritalStatus maritalStatus;
	private final String ethnicity; 
	private final String skinColor; 
	private final String eyeColor; 
	private final String hairColor;
	private final Double height; 
	private final Double wheight; 
	private final String phone; 
	private final String mobilePhone; 
	private final String email;
	

	public Person (
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
		
		this.firstName = firstName;
		this.midleName = midleName;
		this.familyName = familyName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.motherFullName = motherFullName;
		this.RG = RG;
		this.CPF = CPF;
		this.maritalStatus = maritalStatus;
		this.ethnicity = ethnicity;
		this.skinColor = skinColor;
		this.eyeColor = eyeColor;
		this.hairColor = hairColor;
		this.height = height;
		this.wheight = wheight;
		this.phone = phone;
		this.mobilePhone = mobilePhone;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMidleName() {
		return midleName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public Character getGender() {
		return gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getMotherFullName() {
		return motherFullName;
	}

	public String getRG() {
		return RG;
	}

	public String getCPF() {
		return CPF;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public String getSkinColor() {
		return skinColor;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public String getHairColor() {
		return hairColor;
	}

	public Double getHeight() {
		return height;
	}

	public Double getWheight() {
		return wheight;
	}

	public String getPhone() {
		return phone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getEmail() {
		return email;
	}
	
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}
	
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
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		return builder.append("{")
		.append("full name = ")       .append(fullName())               .append(", ")
		.append("gender = ")          .append(getGender())              .append(", ")
		.append("date of birth = ")   .append(getDateOfBirth())         .append(", ")
		.append("mother name = ")     .append(getMotherFullName())      .append(", ")
		.append("RG = ")              .append(getRG())                  .append(", ")
		.append("CPF = ")             .append(getCPF())                 .append(", ") 
		.append("martial status = ")  .append(getMaritalStatus().name()).append(", ") 
		.append("ethnicity = ")       .append(getEthnicity())           .append(", ") 
		.append("skin color = ")      .append(getSkinColor())           .append(", ")
		.append("eye color = ")       .append(getEyeColor())            .append(", ")
		.append("hair color = ")      .append(getHairColor())           .append(", ")
		.append("heith = ")           .append(getHeight())              .append(", ")
		.append("wheight = ")         .append(getWheight())             .append(", ")
		.append("phone = ")           .append(getPhone())               .append(", ")
		.append("mobile Phone = ")    .append(getMobilePhone())         .append(", ")
		.append("e-mail = ")          .append(getEmail())               .append(", ")
		.append("}")
		.toString();	
	}
	
	public static void main(String[] args) {
		
        Person person = new Person(
                "João",
                "Pedro",
                "da Silva",
                'M',
                LocalDate.parse("02/04/1999", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                "Maria da Silva",
                "123456789",
                "12345678900",
                MaritalStatus.SINGLE,
                "Parda",
                "Clara",
                "Castanho",
                "Preto",
                1.75,
                70.5,
                "45998244253",
                "45998225463",
                "joao.silva@email.com"
            );

            System.out.println(person.toString());
        }
}

