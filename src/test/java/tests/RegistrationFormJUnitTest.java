package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;

@Tag("demoqa")
public class RegistrationFormJUnitTest extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    RandomUtils randomUtils = new RandomUtils();


    @Test
    @DisplayName("Полная проверка формы регистрации")
    void successfulRegistrationFormJUnitTest() {
        step("Открываем форму регистрации", () -> {
                 registrationFormPage.openPage()
                .removeBanner();
        });
        step("Заполняем форму", () -> {
            registrationFormPage.setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setUserEmail(randomUtils.useremail)
                .setGender(randomUtils.gender)
                .setUserNumber(randomUtils.usernumber)
                .setDateOfBirth(randomUtils.day, randomUtils.month, randomUtils.year)
                .setHobbies(randomUtils.hobbie)
                .setSubject(randomUtils.subject)
                .uploadPicture(randomUtils.picture)
                .setCurrentAddress(randomUtils.userAddress)
                .setState(randomUtils.state)
                .setCity(randomUtils.city)
                .submitForm();
        });
        step("Проверяем введенные данные", () -> {
            registrationFormPage.checkResults("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkResults("Student Email", randomUtils.useremail)
                .checkResults("Gender", randomUtils.gender)
                .checkResults("Mobile", randomUtils.usernumber)
                .checkResults("Date of Birth", randomUtils.day + " " + randomUtils.month + "," + randomUtils.year)
                .checkResults("Subjects", randomUtils.subject)
                .checkResults("Hobbies", randomUtils.hobbie)
                .checkResults("Picture", randomUtils.picture)
                .checkResults("Address", randomUtils.userAddress)
                .checkResults("State and City", randomUtils.city);
        });
    }

    @Test
    @DisplayName("Проверка минимального ввода данных для регистрации")
    void minimumAmountOfInformationForRegistrationJUnitTest() {
        step("Открываем форму регистрации", () -> {
            registrationFormPage.openPage()
                    .removeBanner();
        });
        step("Заполняем форму", () -> {
            registrationFormPage.setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setGender(randomUtils.gender)
                .setUserNumber(randomUtils.usernumber)
                .submitForm();
        });
        step("Проверяем введенные данные", () -> {
           registrationFormPage.checkResults("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkResults("Gender", randomUtils.gender)
                .checkResults("Mobile", randomUtils.usernumber);
        });
    }

    @Test
    @DisplayName("Негативная проверка формы регистрации")
    void negativeCheckJUnitTest() {
        step("Открываем форму регистрации", () -> {
            registrationFormPage.openPage()
                    .removeBanner();
        });
        step("Заполняем форму", () -> {
            registrationFormPage.setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setGender(randomUtils.gender)
                .setUserNumber(randomUtils.wrongusernumber)
                .submitForm()
                .responseTable()
                .setUserNumber(randomUtils.usernumber)
                .submitForm();
        });
        step("Проверяем введенные данные", () -> {
            registrationFormPage.checkResults("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkResults("Gender", randomUtils.gender)
                .checkResults("Mobile", randomUtils.usernumber);
        });

    }
}