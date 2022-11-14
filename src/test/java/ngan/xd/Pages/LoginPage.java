package ngan.xd.Pages;

import ngan.xd.helpers.PropertiesHelper;
import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonPage {
    private By closeAdvertisementPopup = By.xpath("//i[@class='la la-close fs-20']");
    private By buttonLogin = By.xpath("//a[normalize-space() = 'Login' and @class = 'text-reset d-inline-block opacity-60 py-2']");
    private By buttonCopyCustomerAcc = By.xpath("//td[normalize-space()='Customer Account']/following-sibling::td//button[normalize-space()='Copy credentials']");
    private By buttonSubmitLogin = By.xpath("//button[normalize-space()='Login']");
    private By titleLoginPage = By.xpath("//h1[normalize-space() = 'Login to your account.']");
    private By messageRequiredEmail = By.xpath("//strong[contains(text(),'The email field is required when phone is not present.')]");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By messageAccDoesNotExist = By.xpath("//span[@data-notify='message']");
    private By messageRequiredPassword = By.xpath("//input[contains(@class, 'is-invalid') and @id = 'password']");


    public void login() {
        WebUI.openURL(PropertiesHelper.getValue("url"));
        WebUI.clickElement(closeAdvertisementPopup);
        WebUI.clickElement(buttonLogin);
        WebUI.verifyAssertTrueIsDisplayed(titleLoginPage, "Login page is NOT displayed");
    }

    public void loginFailWithNullEmail() {
        login();
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.verifyAssertTrueEqual(messageRequiredEmail, "The email field is required when phone is not present.", "");
    }

    public void loginFailWithEmailIncorrect() {

    }

    public void loginFailWithEmailDoesNotExist(String email, String password) {
        login();
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.verifyAssertTrueIsDisplayed(messageAccDoesNotExist, "Email is incorrect but valid is NOT displayed.");
    }

    public void loginFailWithNullPassword(String email, String valid) {
        login();
        WebUI.setText(inputEmail, email);
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.verifyAssertTrueIsDisplayed(messageRequiredPassword, "Password is NULL but valid is NOT displayed.");
    }

    public void loginFailWithFailPassword(String password) {
        login();
        WebUI.clickElement(buttonCopyCustomerAcc);
        WebUI.clearText(inputPassword);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.verifyAssertTrueIsDisplayed(messageRequiredPassword, "Password is failed but valid is NOT displayed.");
    }

    public void loginSuccessWithCustomerAccount() {
        login();
        WebUI.clickElement(buttonCopyCustomerAcc);
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.verifyAssertTrueIsDisplayed(messageRequiredPassword, "Password is failed but valid is NOT displayed.");
        WebUI.verifyAssertTrueIsDisplayed(DashboardPage.titleDashboard, "Dashboard page is NOT displayed.");
    }
}
