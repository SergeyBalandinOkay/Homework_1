import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class FillOutTheForm extends BaseTest {

    @Test
    @Description("Проверка на заполнение всех полей")
    void successfulFillFormTest() {
        open("/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").click();
        $("#subjectsDropdown").click();
        $(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(file);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();

        $("[id=resultModal] [id=example-modal-sizes-title-lg]").shouldHave(text(successfulMessage));
        $("[id=resultModal]").shouldHave(text("Student Name"), text(firstName + lastName));
        $("[id=resultModal]").shouldHave(text("Student Email"), text(userEmail));
        $("[id=resultModal]").shouldHave(text("Gender"), text(gender));
        $("[id=resultModal]").shouldHave(text("Mobile"), text(userNumber));
        $("[id=resultModal]").shouldHave(text("Date of Birth"), text(dateOfBirth));
        $("[id=resultModal]").shouldHave(text("Subjects"), text(subjects));
        $("[id=resultModal]").shouldHave(text("Hobbies"), text(hobbies));
        $("[id=resultModal]").shouldHave(text("Picture"), text(file));
        $("[id=resultModal]").shouldHave(text("Address"), text(currentAddress));
        $("[id=resultModal]").shouldHave(text("State and City"), text(state + " " + city));
    }

    @Test
    @Description("Проверка только на заполнение обязательных полей")
    void fillingInRequiredFields() {
        open("/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $("[id=resultModal] [id=example-modal-sizes-title-lg]").shouldHave(text(successfulMessage));
        $("[id=resultModal]").shouldHave(text("Student Name"), text(firstName + lastName));
        $("[id=resultModal]").shouldHave(text("Gender"), text(gender));
        $("[id=resultModal]").shouldHave(text("Mobile"), text(userNumber));
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