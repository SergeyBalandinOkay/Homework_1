import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class SimpleForm extends BaseTest {

    @Test
    @Description("Заполнение формы только с обязательными полями")
    void FillInTheMinimumFields() {
        open("/text-box");
        $("#userName").setValue(firstName);
        $("#submit").click();

        $("[id=output] [id=name]").shouldHave(text(firstName));
    }

    @Test
    @Description("Заполнение поле email невалидным значением")
    void EnteringAnInvalidEmail() {
        open("https://demoqa.com/text-box");
        $("#userEmail").setValue(invalidEmail);
        $("#submit").click();

        $("#userEmail").shouldHave(cssClass("field-error"));
    }
}