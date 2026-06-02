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
    public static String birthDay = String.valueOf(getRandomInt(1,31));
    public static String birthMonth = "July";
    public static String birthMonthExp = "Jul";
    public static String birthYear = "2008";
    public static String subjects = "Chemistry";
    public static String hobbies = "Reading";
    public static String file = "myfile.png";
    public static String currentAddress = "place23";
    public static String state = "Uttar Pradesh";
    public static String city = "Agra";
    public static String successfulMessage = "Thanks for submitting the form";
    public static String unsuccessfulMessage = "Please fill required fields and enter a valid 10-digit mobile number.";
}