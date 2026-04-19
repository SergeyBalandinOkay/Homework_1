import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class SimpleForm extends BaseTest {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @Description("Заполнение формы только с обязательными полями")
    void FillInTheMinimumFields() {
        textBoxPage.openPage();
        textBoxPage.typeUserName(firstName);
        textBoxPage.submitForm();

        textBoxPage.checkField("name", firstName);
    }

    @Test
    @Description("Заполнение поле email невалидным значением")
    void EnteringAnInvalidEmail() {
        textBoxPage.openPage();
        textBoxPage.typeUserEmail(invalidEmail);
        textBoxPage.submitForm();

        textBoxPage.shouldHaveEmailError();
    }
}