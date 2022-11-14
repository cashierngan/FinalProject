package ngan.xd.Pages;

import ngan.xd.helpers.PropertiesHelper;
import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonPage {
    private By closeAdvertisementPopup = By.xpath("//i[@class='la la-close fs-20']");
    private By buttonLogin = By.xpath("//a[normalize-space() = 'Login' and @class = 'text-reset d-inline-block opacity-60 py-2']");
    private By copyCustomerAcc = By.xpath("//td[normalize-space()='Customer Account']/following-sibling::td//button[normalize-space()='Copy credentials']");
    private By buttonSubmitLogin = By.xpath("//button[normalize-space()='Login']");
    private By titleLoginPage = By.xpath("//h1[normalize-space() = 'Login to your account.']");
    private By messageRequiredEmail = By.xpath("//strong[contains(text(),'The email field is required when phone is not present.')]");

    public void login() {
        WebUI.openURL(PropertiesHelper.getValue("url"));
        WebUI.clickElement(closeAdvertisementPopup);
        WebUI.clickElement(buttonLogin);
        WebUI.verifyAssertTrueIsDisplayed(titleLoginPage, "Login page is NOT displayed");
    }

    public void loginFailwithNullEmail() {
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.verifyAssertTrueEqual(messageRequiredEmail, "The email field is required when phone is not present.", "");
    }

    public void loginFailwithEmailIncorrect() {

    }

    public void loginFailwithEmailDoesNotExist() {

    }

    public void loginFailwithNullPassword() {

    }

    public void loginFailwithFailPassword() {

    }

    public void loginSuccessWithCustomerAccount() {

    }
}
