import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleForm extends BaseTest {

    @Test
    @Description("Заполнение формы только с обязательными полями")
    void FillInTheMinimumFields() {
        open("/text-box");
        $("#userName").setValue("Rembo");
        $("#submit").click();

        $("[id=output] [id=name]").shouldHave(text("Rembo"));
    }

    @Test
    @Description("Заполнение формы только с обязательными полями")
    void EnteringAnInvalidEmail() {
        open("https://demoqa.com/text-box");
        $("#userEmail").setValue("email");
        $("#submit").click();

        $("#userEmail").shouldHave(cssClass("field-error"));
    }
}