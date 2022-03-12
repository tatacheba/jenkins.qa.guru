package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPages {
    //Components

    private CalendarComponent calendarComponent = new CalendarComponent();

    //location
    private SelenideElement
            headerTitle = $(".practice-form-wrapper > h5"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateBirthDay = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            cityName = $("#react-select-4-input"),
            buttonSubmit = $("#submit"),
            modalTable = $("#example-modal-sizes-title-lg"),
            table = $("table");

    // actions
    public RegistrationPages openPage(String url, String headerPage) {
        open(url);
        headerTitle.shouldHave(text(headerPage));

        return this;
    }

    public void setFirstNameInput(String firstName) {
        firstNameInput.setValue(firstName);

    }

    public void setLastNameInput(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void setUserEmailInput(String userEmail) {
        userEmailInput.setValue(userEmail);
    }

    public void checkGenderRadioButton(String gender) {
        genderRadioButton.find(byText(gender)).click();
    }

    public void setUserNumberInput(String userNumber) {
        userNumberInput.setValue(userNumber);
    }

    public void setDateBirthday(String date) {
        dateBirthDay.click();
        calendarComponent.setDate(date);

    }

    public void selectSubjectInput(String subject) {
        subjectInput.setValue(subject).pressEnter();
    }

    public void checkBoxHobbies(String hobby) {
        hobbies.find(byText(hobby)).click();
    }

    public void setPathUploadPicture(String path) {
        uploadPicture.uploadFile(new File(path));

    }

    public void setCurrentAddress(String address) {
        currentAddress.setValue(address);
    }

    public void setStateInput(String state) {
        stateInput.click();
        $(byText(state)).click();

    }

     public void setCityInput(String city) {
         cityInput.click();
        cityName.setValue(city).pressEnter();
    }

    public void clickButtonSubmit() {
           buttonSubmit.click();
    }

    public void checkModalTable(String tableHeader) {
        modalTable.shouldHave(text(tableHeader));
    }

    public RegistrationPages checkForm(String fieldName, String value) {
        table.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }
}
