import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Les10TestFormJenkins {

    @BeforeAll
    static void openBrowser() {
        baseUrl = "https://demoqa.com";
        browserSize = "1920x1080";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @Test
    void fillTestForm() {
        open("/automation-practice-form");
        $(".practice-form-wrapper > h5").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Steve");
        $("#lastName").setValue("Rogers");
        $("#userEmail").setValue("captainamerica@marvel.com");
        $("#genterWrapper").find(byText("Male")).click();
        $("#userNumber").setValue("8885115480");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1918");
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__day--004").click();
        $("#subjectsInput").setValue("Art").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").
                uploadFile(new File("src/test/resources/capitanamerica.jpg"));
        $("#currentAddress").setValue("Earth-616, New York City");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $("#react-select-4-input").setValue("Noi").pressEnter();
        $(byText("Submit")).click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("table").shouldHave(
                text("Steve Rogers"),
                text("captainamerica@marvel.com"),
                text("Male"),
                text("8885115480"),
                text("04 July,1918"),
                text("Arts"),
                text("Sports"),
                text("capitanamerica.jpg"),
                text("Earth-616, New York City"),
                text("NCR Noida"));
        $("#closeLargeModal").shouldHave(text("Close")).click();
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
