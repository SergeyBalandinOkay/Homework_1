package testdata;

import com.github.javafaker.Faker;
import utils.RandomUtils;

import static utils.RandomUtils.getRandomInt;

public class TestData {

    Faker faker = new Faker();

    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final String fullName = firstName + " " + lastName;
    public final String userEmail = faker.internet().emailAddress();
    public final String gender = faker.options().option("Male", "Female", "Other");
    public final String userNumber = faker.phoneNumber().subscriberNumber(10);
    public final String userNumberNegative = faker.phoneNumber().subscriberNumber(5);
    public final String birthDay = String.valueOf(getRandomInt(1, 28));
    public final String birthMonth = RandomUtils.getRandomMonth();
    public final String birthMonthExp = birthMonth.substring(0, 3);
    public final String birthYear = String.valueOf(faker.number().numberBetween(1950, 2005));
    public final String subjects = faker.options().option("Maths", "Physics", "Chemistry", "Biology",
            "English", "Computer Science", "Economics", "Arts", "History", "Civics");
    public final String hobbies = faker.options().option("Music", "Sports", "Reading");
    public final String file = "myfile.png";
    public final String currentAddress = faker.address().fullAddress();

    public final String state;
    public final String city;
    public final String stateAndCity;

    {
        String generatedState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        this.state = generatedState;
        this.city = selectCity(generatedState);
        this.stateAndCity = this.state + " " + this.city;
    }

    public String selectCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "Agra";
        };
    }

    public final static String successfulMessage = "Thanks for submitting the form";
    public final static String unsuccessfulMessage = "Please fill required fields and enter a valid 10-digit mobile number.";
}