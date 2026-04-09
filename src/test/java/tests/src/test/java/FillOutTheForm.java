import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FillOutTheForm extends BaseTest {

    @Test
    void successfulFillFormTest(){
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
}
