package testdata;

import com.github.javafaker.Faker;
import utils.RandomUtils;

import static utils.RandomUtils.getRandomInt;

public class TestData {

    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String fullName = firstName + " " + lastName;
    public static String userEmail = faker.internet().emailAddress();
    public static String invalidEmail = "loveandpeace";
    public static String gender = RandomUtils.getRandomGender();
    public static String userNumber = faker.phoneNumber().subscriberNumber(10);
    public static String userNumberNegative = faker.phoneNumber().subscriberNumber(5);
    public static String birthDay = String.valueOf(getRandomInt(1, 28));
    public static String birthMonth = RandomUtils.getRandomMonth();
    public static String birthMonthExp = birthMonth.substring(0, 3);
    public static String birthYear = String.valueOf(faker.number().numberBetween(1950, 2005));
    public static String subjects = faker.options().option("Maths", "Physics", "Chemistry", "Biology",
            "English", "Computer Science", "Economics", "Arts", "History", "Civics");
    public static String hobbies = RandomUtils.getRandomHobbies();
    public static String file = "myfile.png";
    public static String currentAddress = faker.address().fullAddress();
    public static String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public static String city = selectCity(state);

    public static String selectCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "Agra";
        };
    }

    public static String successfulMessage = "Thanks for submitting the form";
    public static String unsuccessfulMessage = "Please fill required fields and enter a valid 10-digit mobile number.";
}