package testdata;

import com.github.javafaker.Faker;
import utils.RandomUtils;

import java.util.Random;

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
    public static String birthDay = String.valueOf(getRandomInt(1,28));
    public static String birthMonth = RandomUtils.getRandomMonth();
    public static String birthMonthExp = "Jul";
    public static String birthYear = String.valueOf(faker.number().numberBetween(1950, 2005));
    public static String subjects = faker.options().option("English", "Chemistry", "Computer Science", "Commerce",
            "Economics", "Social Studies");
    public static String hobbies = RandomUtils.getRandomHobbies();
    public static String file = "myfile.png";
    public static String currentAddress = faker.address().fullAddress();
    public static String state = "Uttar Pradesh";
    public static String city = "Agra";
    public static String successfulMessage = "Thanks for submitting the form";
    public static String unsuccessfulMessage = "Please fill required fields and enter a valid 10-digit mobile number.";
}