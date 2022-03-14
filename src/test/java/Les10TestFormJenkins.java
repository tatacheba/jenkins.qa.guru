import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class Les10TestFormJenkins extends TestBase {

    @Test
    @Tag("properties")
    void fillTestForm() {
        step("Open page ", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper > h5").shouldHave(text("Student Registration Form"));
        });
        step("Insert First Name ", () -> {
            $("#firstName").setValue("Steve");
        });
        step("Insert Last Name  ", () -> {
            $("#lastName").setValue("Rogers");
        });
        step("Insert User Email ", () -> {
            $("#userEmail").setValue("captainamerica@marvel.com");
        });
        step("Check Gender  ", () -> {
            $("#genterWrapper").find(byText("Male")).click();
        });
        step("Insert User Number ", () -> {
            $("#userNumber").setValue("8885115480");
        });
        step("Check Date Birthday", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOptionByValue("1918");
            $(".react-datepicker__month-select").selectOptionByValue("6");
            $(".react-datepicker__day--004").click();
        });
        step("Check Subject  ", () -> {
            $("#subjectsInput").setValue("Art").pressEnter();
        });
        step("Check Hobby", () -> {
            $(byText("Sports")).click();
        });
        step("Insert CurrentAddress ", () -> {
            $("#currentAddress").setValue("Earth-616, New York City");
        });
        step("Insert State ", () -> {
            $("#state").click();
            $(byText("NCR")).click();
        });
        step("Insert city ", () -> {
            $("#city").click();
            $("#react-select-4-input").setValue("Noi").pressEnter();
        });
           step("Click button", () -> {
            $(byText("Submit")).click();
        });
        step("Assert data Modal Table", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $("table").shouldHave(
                    text("Steve Rogers"),
                    text("captainamerica@marvel.com"),
                    text("Male"),
                    text("8885115480"),
                    text("04 July,1918"),
                    text("Arts"),
                    text("Sports"),
//                text("capitanamerica.jpg"),
                    text("Earth-616, New York City"),
                    text("NCR Noida"));
            $("#closeLargeModal").shouldHave(text("Close")).click();
        });

    }

    @Test
    @Tag("smoke")
    void smokeTest(){
        System.out.println(System.getProperty("Hello!!!"));
    }
}
