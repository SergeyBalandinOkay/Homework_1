package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultFinalTable;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;
import static testdata.TestData.city;

public class RegistrationPage {
    private final SelenideElement closeBannerInput = $("[aria-label='Close']");
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderContainer = $(byText(gender));
    private final SelenideElement phoneNumberInput = $("#userNumber");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement subjectsDropdown = $("#subjectsDropdown");
    private final SelenideElement chooseHobbies = $(byText(hobbies));
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement enterState = $(byText(state));
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement enterCity = $(byText(city));
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement modalTitle = $("[id=example-modal-sizes-title-lg]");
    private final SelenideElement errorMessage = $("[id=formError]");
    CalendarComponent calendar = new CalendarComponent();
    ResultFinalTable resultFinalTable = new ResultFinalTable();


    public RegistrationPage openPage() {
        open("/automation-practice-form.html");
        return this;
    }

    public RegistrationPage bannerClose() {
        closeBannerInput.click();
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmailName(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderContainer.click();
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage typePhoneNumberName(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage typeSubject() {
        subjectsInput.click();
        return this;
    }

    public RegistrationPage typeDropdown() {
        subjectsDropdown.click();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        chooseHobbies.click();
        return this;
    }

    public RegistrationPage uploadPicture(String file) {
        uploadPicture.uploadFromClasspath("myfile.png");
        return this;
    }

    public RegistrationPage currentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage chooseState() {
        stateInput.click();
        return this;
    }

    public RegistrationPage setState(String value) {
        enterState.click();
        return this;
    }

    public RegistrationPage chooseCity() {
        cityInput.click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        enterCity.click();
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyModalTitle(String successfulMessage) {
        modalTitle.shouldHave(text(successfulMessage));
        return this;
    }

    public RegistrationPage getErrorMessage(String unsuccessfulMessage) {
        errorMessage.shouldHave(text(unsuccessfulMessage));
        return this;
    }

    public RegistrationPage typePhoneNumberInvalid(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage modalResult(String key, String value) {
        resultFinalTable.modalResult(key, value);
        return this;
    }
}