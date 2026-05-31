import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.RegistrationPage;

import static testdata.TestData.*;

public class FillOutTheForm extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(FillOutTheForm.class);
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Description("Проверка на заполнение всех полей")
    void successfulFillFormTest() {
        registrationPage
                .openPage()
                .bannerClose()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmailName(userEmail)
                .setGender(gender)
                .typePhoneNumberName(userNumber)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .typeSubject()
                .typeDropdown()
                .setHobbies(hobbies)
                .uploadPicture(file)
                .currentAddress(currentAddress)
                .chooseState()
                .setState(state)
                .chooseCity()
                .setCity(city)
                .submitForm()

                .verifyModalTitle(successfulMessage)
                .modalResult("Student Name", firstName + lastName)
                .modalResult("Student Email", userEmail)
                .modalResult("Gender", gender)
                .modalResult("Mobile", userNumber)
                .modalResult("Date of Birth", birthDay + " " + birthMonthExp + " " + birthYear)
                .modalResult("Subjects", subjects)
                .modalResult("Hobbies", hobbies)
                .modalResult("Picture", file)
                .modalResult("Address", currentAddress)
                .modalResult("State and City", state + " " + city);
    }

    @Test
    @Description("Проверка только на заполнение обязательных полей")
    void fillingInRequiredFields() {

        registrationPage
                .openPage()
                .bannerClose()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .typePhoneNumberName(userNumber)
                .submitForm()

                .verifyModalTitle(successfulMessage)
                .modalResult("Student Name", firstName + lastName)
                .modalResult("Gender", gender)
                .modalResult("Mobile", userNumber);
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
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .submitForm()

                .getErrorMessage(unsuccessfulMessage);
    }

    @Test
    @Description("Подтверждение формы, если заполнены обязательные поля и номер телефона !=10 цифрами")
    void invalidPhoneNumber() {

        registrationPage
                .openPage()
                .bannerClose()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .typePhoneNumberInvalid(userNumberNegative)
                .submitForm()

                .getErrorMessage(unsuccessfulMessage);
    }

    @Test
    @Description("Подтверждение формы, если не выбран пол")
    void noGenderSelected() {

        registrationPage
                .openPage()
                .bannerClose()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typePhoneNumberName(userNumber)
                .submitForm()

                .getErrorMessage(unsuccessfulMessage);
    }
}