import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static testdata.TestData.*;

public class FillOutTheForm extends BaseTest {
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
                .typeDateOfBirth()
                .firstDateOfBirth()
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
                .verifyFirstNameAndLastName(firstName, lastName)
                .verifyEmail(userEmail)
                .verifyGender(gender)
                .verifyMobile(userNumber)
                .verifyDateOfBirth(dateOfBirth)
                .verifySubjects(subjects)
                .verifyHobbies(hobbies)
                .verifyPicture(file)
                .verifyAddress(currentAddress)
                .verifyStateAndCity(state, city);
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
                .verifyFirstNameAndLastName(firstName, lastName)
                .verifyGender(gender)
                .verifyMobile(userNumber);
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