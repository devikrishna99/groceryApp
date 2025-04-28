package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	Faker faker = new Faker();
	
	public String generateName() {
		return faker.name().firstName();
		
	}
	public String generateAddress() {
		return faker.address().fullAddress();
	}
	public String generatePhnoneNO() {
		return faker.phoneNumber().phoneNumber();
	}
	public String generateCity() {
		return faker.address().city();
	}
	public String generateEmailid() {
		return faker.internet().emailAddress();
	}
	public String generatePassword() {
		return faker.internet().password();
	}
	public String generateRandomDigits(int count) {
		Faker faker = new Faker();
		return faker.number().digits(count);
	}
	public String generatecapital() {
		return faker.country().capital();
		
	}
	public String generateAppVersion() {
		return faker.app().version();
		
	}
	public String generateCountryCode() {
		return faker.address().countryCode();
	}
	public String generateAnimalName() {
		return faker.animal().name();
	}
	public String generatebookTitle() {
		return faker.book().title();
	}
	public String generatenews() {
		return faker.lorem().sentence();
	}
	public String generateFruitName() {
		return faker.food().vegetable();
	}

}
