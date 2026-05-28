import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static testdata.TestData.*;

public class SimpleForm extends BaseTest {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @Description("Заполнение формы только с обязательными полями")
    void FillInTheMinimumFields() {
        textBoxPage

                .openPage()
                .typeUserName(firstName)
                .submitForm()
                .checkField("name", firstName);
    }

    @Test
    @Description("Заполнение поле email невалидным значением")
    void EnteringAnInvalidEmail() {

        textBoxPage
                .openPage()
                .typeUserEmail(invalidEmail)
                .submitForm()
                .shouldHaveEmailError();
    }
}