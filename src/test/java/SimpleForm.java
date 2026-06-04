import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static utils.RandomUtils.getRandomString;

public class SimpleForm extends BaseTest {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @Description("Заполнение поле email невалидным значением")
    void EnteringAnInvalidEmail() {
        String invalidEmail = getRandomString(10);

        textBoxPage.openPage().
                typeUserEmail(invalidEmail)
                .submitForm()
                .shouldHaveEmailError();
    }

    @Test
    @Description("Заполнение формы только с обязательными полями")
    void FillInTheMinimumFieldsWithFaker() {
        String firstName = getRandomString(10);

        textBoxPage.openPage()
                .typeUserName(firstName)
                .submitForm()

                .checkField("name", firstName);
    }
}