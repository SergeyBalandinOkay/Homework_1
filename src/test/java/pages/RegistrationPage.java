package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;
import static testdata.TestData.city;

public class RegistrationPage {
    private SelenideElement closeBannerInput = $("[aria-label='Close']");
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement genderContainer = $(byText(gender));
    private SelenideElement phoneNumberInput = $("#userNumber");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement firstDayInput = $(".react-datepicker__day--001");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement subjectsDropdown = $("#subjectsDropdown");
    private SelenideElement chooseHobbies = $(byText(hobbies));
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateInput = $("#state");
    private SelenideElement enterState = $(byText(state));
    private SelenideElement cityInput = $("#city");
    private SelenideElement enterCity = $(byText(city));
    private SelenideElement submitButton = $("#submit");
    private SelenideElement modalTitle = $("[id=resultModal] [id=example-modal-sizes-title-lg]");
    private SelenideElement modalName = $("#resultModal");
    private SelenideElement errorMessage = $("[id=formError]");


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

    public RegistrationPage typePhoneNumberName(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage typeDateOfBirth() {
        dateOfBirthInput.click();
        return this;
    }

    public RegistrationPage firstDateOfBirth() {
        firstDayInput.click();
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

    public RegistrationPage verifyFirstNameAndLastName(String firstName, String lastName) {
        modalName.shouldHave(text("Student Name"),
                text(firstName + " " + lastName));
        return this;
    }

    public RegistrationPage verifyEmail(String value) {
        modalName.shouldHave(text("Student Email"),
                text(userEmail));
        return this;
    }

    public RegistrationPage verifyGender(String value) {
        modalName.shouldHave(text("Gender"),
                text(gender));
        return this;
    }

    public RegistrationPage verifyMobile(String value) {
        modalName.shouldHave(text("Mobile"),
                text(userNumber));
        return this;
    }

    public RegistrationPage verifyDateOfBirth(String value) {
        modalName.shouldHave(text("Date of Birth"),
                text(dateOfBirth));
        return this;
    }

    public RegistrationPage verifySubjects(String value) {
        modalName.shouldHave(text("Subjects"),
                text(subjects));
        return this;
    }

    public RegistrationPage verifyHobbies(String value) {
        modalName.shouldHave(text("Hobbies"),
                text(hobbies));
        return this;
    }

    public RegistrationPage verifyPicture(String value) {
        modalName.shouldHave(text("Picture"),
                text(file));
        return this;
    }

    public RegistrationPage verifyAddress(String value) {
        modalName.shouldHave(text("Address"),
                text(currentAddress));
        return this;
    }

    public RegistrationPage verifyStateAndCity(String state, String city) {
        modalName.shouldHave(text("State and City"),
                text(state + " " + city));
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
}