package utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String useremail = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String usernumber = faker.number().digits(10);
    public String wrongusernumber = faker.number().digits(8);
    public String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    int birthyear = faker.number().numberBetween(1950, 2021);
    public String year = String.valueOf(birthyear);
    int birthday = faker.number().numberBetween(10, 28);
    public String day = String.valueOf(birthday);
    public String hobbie = faker.options().option("Sports", "Reading", "Music");
    public String subject = faker.options().option("Arts", "Maths", "Hindi", "History");
    public String picture = faker.options().option("1.jpg", "2.jpg", "3.jpg");
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String userAddress = faker.address().streetAddress();

    public String city = chooseCity(state);
    public String chooseCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return null;

        }
    }

}
