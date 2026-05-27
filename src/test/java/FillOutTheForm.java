import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
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


//        open("/automation-practice-form.html");
//        $("[aria-label='Close']").click();
//        $("#firstName").setValue(firstName);
//        $("#lastName").setValue(lastName);
//        $(byText(gender)).click();
//        $("#userNumber").setValue(userNumber);
//        $("#submit").click();

//        $("[id=resultModal] [id=example-modal-sizes-title-lg]").shouldHave(text(successfulMessage));
//        $("[id=resultModal]").shouldHave(text("Student Name"), text(firstName + lastName));
//        $("[id=resultModal]").shouldHave(text("Gender"), text(gender));
//        $("[id=resultModal]").shouldHave(text("Mobile"), text(userNumber));
    }

    @Test
    @Description("Подтверждение формы без заполнениях обязательных полей")
    void ConfirmWithoutFilling() {
        open("/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#submit").scrollTo().click();
        $("[id=formError]").shouldHave(text(unsuccessfulMessage));
    }

    @Test
    @Description("Подтверждение формы без заполнения мобильного телефона")
    void fieldWithoutPhoneNumber() {
        open("/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#gender-radio-1").click();
        $("#submit").scrollTo().click();
        $("[id=formError]").shouldHave(text(unsuccessfulMessage));
    }

    @Test
    @Description("Подтверждение формы, если заполнены обязательные поля и номер телефона !=10 цифрами")
    void invalidPhoneNumber() {
        open("/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#gender-radio-1").click();
        $("#userNumber").setValue(userNumberNegative);
        $("#submit").scrollTo().click();
        $("[id=formError]").shouldHave(text(unsuccessfulMessage));
    }

    @Test
    @Description("Подтверждение формы, если не выбран пол")
    void noGenderSelected() {
        open("/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userNumber").setValue(userNumber);
        $("#submit").scrollTo().click();
        $("[id=formError]").shouldHave(text(unsuccessfulMessage));
    }
}