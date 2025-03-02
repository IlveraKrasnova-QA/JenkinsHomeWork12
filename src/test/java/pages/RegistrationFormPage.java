package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    private final SelenideElement firstNameInput = $("[id=firstName]"),
            lastNameInput = $("[id=lastName]"),
            userEmailInput = $("[id=userEmail]"),
            genderInput = $("[id=genterWrapper]"),
            userNumberInput = $("[id=userNumber]"),
            calendarinput = $("[id=dateOfBirthInput]"),
            hobbyInput = $("[id=hobbiesWrapper]"),
            subjectInput = $("[id=subjectsInput]"),
            pictureInput = $("[id=uploadPicture]"),
            currentAddressInput = $("[id=currentAddress]"),
            stateInput = $("[id=state]"),
            cityInput = $("[id=city]"),
            submitInput = $("[id=submit]"),
            responseInput = $("[class=table-responsive]");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsComponent resultsComponent = new ResultsComponent();

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationFormPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setDateOfBirth (String day, String month, String year) {
        calendarinput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        hobbyInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateInput.scrollTo();
        stateInput.click();
        stateInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        cityInput.scrollTo();
        cityInput.click();
        cityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage submitForm() {
        submitInput.scrollTo();
        submitInput.click();

        return this;
    }

    public RegistrationFormPage checkResults (String key, String value) {
        resultsComponent.checkResults(key, value);

        return this;
    }

    public RegistrationFormPage responseTable () {
        responseInput.shouldNotBe(visible);

        return this;
    }

}
