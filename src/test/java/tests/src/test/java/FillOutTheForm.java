import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FillOutTheForm extends BaseTest {

    @Test
    @Description("Проверка на заполнение всех полей")
    void successfulFillFormTest() {
        open("/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue("Sergey");
        $("#lastName").setValue("Balandin");
        $("#userEmail").setValue("loveandpeace@mail.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("7775757577");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").click();
        $("#subjectsDropdown").click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("myfile.png");
        $("#currentAddress").setValue("place23");
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Agra")).click();
        $("#submit").click();

        $("[id=resultModal] [id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $("[id=resultModal]").shouldHave(text("Student Name"), text("Sergey Balandin"));
        $("[id=resultModal]").shouldHave(text("Student Email"), text("loveandpeace@mail.ru"));
        $("[id=resultModal]").shouldHave(text("Gender"), text("Male"));
        $("[id=resultModal]").shouldHave(text("Mobile"), text("7775757577"));
        $("[id=resultModal]").shouldHave(text("Date of Birth"), text("2008-07-01"));
        $("[id=resultModal]").shouldHave(text("Subjects"), text("Chemistry"));
        $("[id=resultModal]").shouldHave(text("Hobbies"), text("Reading"));
        $("[id=resultModal]").shouldHave(text("Picture"), text("myfile.png"));
        $("[id=resultModal]").shouldHave(text("Address"), text("place23"));
        $("[id=resultModal]").shouldHave(text("State and City"), text("Uttar Pradesh Agra"));
    }

    @Test
    @Description("Проверка только на заполнение обязательных полей")
    void fillingInRequiredFields() {
        open("/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue("Sergey");
        $("#lastName").setValue("Balandin");
        $(byText("Male")).click();
        $("#userNumber").setValue("1116757577");
        $("#submit").click();

        $("[id=resultModal] [id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $("[id=resultModal]").shouldHave(text("Student Name"), text("Sergey Balandin"));
        $("[id=resultModal]").shouldHave(text("Gender"), text("Male"));
        $("[id=resultModal]").shouldHave(text("Mobile"), text("1116757577"));
    }

    @Test
    @Description("Подтверждение формы без заполнениях обязательных полей")
    void ConfirmWithoutFilling() {
        open("/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#submit").scrollTo().click();
        $("[id=formError]").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }

    @Test
    @Description("Подтверждение формы без заполнения мобильного телефона")
    void fieldWithoutPhoneNumber() {
        open("/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue("Sergey");
        $("#lastName").setValue("Balandin");
        $("#gender-radio-1").click();
        $("#submit").scrollTo().click();
        $("[id=formError]").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }

    @Test
    @Description("Подтверждение формы, если заполнены обязательные поля и номер телефона !=10 цифрами")
    void invalidPhoneNumber() {
        open("/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue("Sergey");
        $("#lastName").setValue("Balandin");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("123123123");
        $("#submit").scrollTo().click();
        $("[id=formError]").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }

    @Test
    @Description("Подтверждение формы, если не выбран пол")
    void noGenderSelected() {
        open("/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue("Sergey");
        $("#lastName").setValue("Balandin");
        $("#userNumber").setValue("1231231234");
        $("#submit").scrollTo().click();
        $("[id=formError]").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }
}