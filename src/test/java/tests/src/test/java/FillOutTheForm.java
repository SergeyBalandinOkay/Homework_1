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
        $("#gender-radio-1").click();
        $("#userNumber").setValue("7775757577");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").click();
        $("#subjectsDropdown").click();
        $("#hobbies-checkbox-3").click();
        $("#uploadPicture").uploadFile(new File("C:/Users/user/Desktop/file"));
        $("#currentAddress").setValue("place23");
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Agra")).click();
        $("#submit").click();

        $("[id=resultModal] [id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
    }

    @Test
    @Description("Проверка только на заполнение обязательных полей")
    void fillingInRequiredFields() {
        open("/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue("Sergey");
        $("#lastName").setValue("Balandin");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("1116757577");
        $("#submit").click();
        $("[id=resultModal] [id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
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