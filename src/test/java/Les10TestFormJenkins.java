import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPages;
import pages.components.CalendarComponent;
import pages.components.PathComponent;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.qameta.allure.Allure.step;

public class Les10TestFormJenkins {

    RegistrationPages registrationPage = new RegistrationPages();
    CalendarComponent calendarComponent = new CalendarComponent();
    PathComponent pathComponent = new PathComponent();
    String
            openPagesUrl = "/automation-practice-form",
            headerTitleMainPage = "Student Registration Form",
            firstName = "Steve",
            lastName = "Rogers",
            userEmail = "captainamerica@marvel.com",
            gender = "Male",
            userNumber = "8885115480",
            dateBirthday = "19.07.1918",
            subject = "Art",
            hobby = "Sports",
            pathPicture = "src/test/resources/capitanamerica.jpg",
            currentAddress = "Earth-616, New York City",
            state = "NCR",
            city = "Noida",
            headerModalTable = "Thanks for submitting the form";

    @BeforeAll
    static void openBrowser() {
        baseUrl = "https://demoqa.com";
        browserSize = "1920x1080";
    }

    @Test
    void fillTextForm() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open page " + openPagesUrl, () -> {
            registrationPage.openPage(openPagesUrl, headerTitleMainPage);
        });
        step("Insert First Name " + firstName, () -> {
            registrationPage.setFirstNameInput(firstName);
        });
        step("Insert Last Name " + lastName, () -> {
            registrationPage.setLastNameInput(lastName);
        });
        step("Insert User Email " + userEmail, () -> {
            registrationPage.setUserEmailInput(userEmail);
        });
        step("Check Gender " + gender, () -> {
            registrationPage.checkGenderRadioButton(gender);
        });
        step("Insert User Number " + userNumber, () -> {
            registrationPage.setUserNumberInput(userNumber);
        });
        step("Check Date Birthday " + dateBirthday, () -> {
            registrationPage.setDateBirthday(dateBirthday);
        });
        step("Check Subject " + subject, () -> {
            registrationPage.selectSubjectInput(subject);
        });
        step("Check Hobby " + hobby, () -> {
            registrationPage.checkBoxHobbies(hobby);
        });
        step("Upload Picture " + pathPicture, () -> {
            registrationPage.setPathUploadPicture(pathPicture);
        });
        step("Insert CurrentAddress " + currentAddress, () -> {
            registrationPage.setCurrentAddress(currentAddress);
        });
        step("Insert State " + state, () -> {
            registrationPage.setStateInput(state);
        });
        step("Insert city " + city, () -> {
            registrationPage.setCityInput(city);
        });
        step("Click button", () -> {
            registrationPage.clickButtonSubmit();
        });
        step("Assert data Modal Table", () -> {
            registrationPage.checkModalTable(headerModalTable);
            registrationPage.checkForm("Student Name", firstName + " " + lastName)
                    .checkForm("Student Email", userEmail)
                    .checkForm("Gender", gender)
                    .checkForm("Student Email", userEmail)
                    .checkForm("Mobile", userNumber)
                    .checkForm("Date of Birth", calendarComponent.converterDate(dateBirthday))
                    .checkForm("Subjects", subject)
                    .checkForm("Hobbies", hobby)
                    .checkForm("Picture", pathComponent.converterCheckPath(pathPicture))
                    .checkForm("Address", currentAddress)
                    .checkForm("State and City", state + " " + city);
        });

    }

    @AfterEach
    void addAttachments() {
        AttachAllure.screenshotAs("Last screenshot");
        AttachAllure.pageSource();
        AttachAllure.browserConsoleLogs();
        AttachAllure.addVideo();
        closeWebDriver();
    }
}
