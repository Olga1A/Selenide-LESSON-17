package UI;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class uiTest {

    @Test
    //Login negative test senario
    public void loginTest() {
        Selenide.open("https://fe-delivery.tallinn-learning.ee/signin");
        SelenideElement loginField = $(By.id("username"));
        SelenideElement passwordField = $(By.id("password"));

        loginField.setValue("negativetest");
        passwordField.setValue("12345678");
        SelenideElement signInButton = $x("//*[@data-name='signIn-button']");
        signInButton.click();
        SelenideElement loginErrorMessage = $x("//*[@data-name='authorizationError-popup']");
        SelenideElement popupCloseButton = $x("//*[@data-name='authorizationError-popup-close-button']");
        loginErrorMessage.shouldBe(visible);
        popupCloseButton.shouldBe(visible);
        Selenide.sleep(5000);
    }

    @Test
    //Login positive,check order page and visibility of Status, Order buttons test senario
    public void loginTestAndCheckOrderPage() {
        Selenide.open("https://fe-delivery.tallinn-learning.ee/signin");
        SelenideElement loginField = $(By.id("username"));
        SelenideElement passwordField = $(By.id("password"));

        loginField.setValue("al-olga");
        passwordField.setValue("pgd3VbfT2nt");
        SelenideElement signInButton = $x("//*[@data-name='signIn-button']");
        signInButton.click();
        SelenideElement statusButton = $x("//*[@data-name='openStatusPopup-button']");
        SelenideElement orderButton = $x("//*[@data-name='createOrder-button']");
        statusButton.shouldBe(visible);
        orderButton.shouldBe(visible);
        Selenide.sleep(5000);

    }
    }

