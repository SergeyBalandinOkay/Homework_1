import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testdata.TestData;

import static testdata.TestData.*;

public class FillOutTheForm extends BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    @Description("Проверка на заполнение всех полей")
    void successfulFillFormTest() {


        registrationPage
                .openPage()
                .bannerClose()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeEmailName(testData.userEmail)
                .setGender(testData.gender)
                .typePhoneNumberName(testData.userNumber)
                .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .typeSubject(testData.subjects)
                .setHobbies(testData.hobbies)
                .uploadPicture(testData.file)
                .currentAddress(testData.currentAddress)
                .chooseState()
                .setState(testData.state)
                .chooseCity()
                .setCity(testData.city)
                .submitForm()

                .verifyModalTitle(successfulMessage)
                .modalResult("Student Name", testData.fullName)
                .modalResult("Student Email", testData.userEmail)
                .modalResult("Gender", testData.gender)
                .modalResult("Mobile", testData.userNumber)
                .modalResult("Date of Birth", testData.birthDay + " " + testData.birthMonthExp + " " + testData.birthYear)
                .modalResult("Subjects", testData.subjects)
                .modalResult("Hobbies", testData.hobbies)
                .modalResult("Picture", testData.file)
                .modalResult("Address", testData.currentAddress)
                .modalResult("State and City", testData.stateAndCity);
    }

    @Test
    @Description("Проверка только на заполнение обязательных полей")
    void fillingInRequiredFields() {

        registrationPage
                .openPage()
                .bannerClose()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .setGender(testData.gender)
                .typePhoneNumberName(testData.userNumber)
                .submitForm()

                .verifyModalTitle(successfulMessage)
                .modalResult("Student Name", testData.fullName)
                .modalResult("Gender", testData.gender)
                .modalResult("Mobile", testData.userNumber);
    }

    @Test
    @Description("Подтверждение формы без заполнениях обязательных полей")
    void ConfirmWithoutFilling() {

        registrationPage
                .openPage()
                .bannerClose()
                .submitForm()

                .getErrorMessage(unsuccessfulMessage);
    }

    @Test
    @Description("Подтверждение формы без заполнения мобильного телефона")
    void fieldWithoutPhoneNumber() {

        registrationPage
                .openPage()
                .bannerClose()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .setGender(testData.gender)
                .submitForm()

                .getErrorMessage(unsuccessfulMessage);
    }

    @Test
    @Description("Подтверждение формы, если заполнены обязательные поля и номер телефона !=10 цифрами")
    void invalidPhoneNumber() {

        registrationPage
                .openPage()
                .bannerClose()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .setGender(testData.gender)
                .typePhoneNumberInvalid(testData.userNumberNegative)
                .submitForm()

                .getErrorMessage(unsuccessfulMessage);
    }

    @Test
    @Description("Подтверждение формы, если не выбран пол")
    void noGenderSelected() {

        registrationPage
                .openPage()
                .bannerClose()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typePhoneNumberName(testData.userNumber)
                .submitForm()

                .getErrorMessage(unsuccessfulMessage);
    }
}