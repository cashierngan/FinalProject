package ngan.xd.Pages;

import ngan.xd.helpers.PropertiesHelper;
import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;

public class LoginPage extends CommonPage {
    private static By closeAdvertisementPopup = By.xpath("//i[@class='la la-close fs-20']");
    private static By buttonLogin = By.xpath("//a[normalize-space() = 'Login' and @class = 'text-reset d-inline-block opacity-60 py-2']");
    private static By buttonCopyCustomerAcc = By.xpath("//td[normalize-space()='Customer Account']/following-sibling::td//button[normalize-space()='Copy credentials']");
    private static By buttonSubmitLogin = By.xpath("//button[normalize-space()='Login']");
    private static By titleLoginPage = By.xpath("//h1[normalize-space() = 'Login to your account.']");
    private By messageRequiredEmail = By.xpath("//strong[contains(text(),'The email field is required when phone is not present.')]");
    private static By inputEmail = By.xpath("//input[@id='email']");
    private static By inputPassword = By.xpath("//input[@id='password']");
    private By messageAccDoesNotExist = By.xpath("//span[@data-notify='message']");
    private By messageRequiredPassword = By.xpath("//input[contains(@class, 'is-invalid') and @id = 'password']");
    private static By titleAnhTesterAdminPage = By.xpath("//img[@alt='Anh Tester Demo']");

    public static void openLoginPage() {
        WebUI.openURL(PropertiesHelper.getValue("url"));
        WebUI.clickElement(closeAdvertisementPopup);
        WebUI.clickElement(buttonLogin);
        WebUI.verifyAssertTrueIsDisplayed(titleLoginPage, "Login page is NOT displayed");
    }

    public void loginFailWithNullEmail() {
        openLoginPage();
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.verifyAssertTrueEqual(messageRequiredEmail, "The email field is required when phone is not present.", "");
    }

    public void loginFailWithEmailIncorrect() {

    }

    public void loginFailWithEmailDoesNotExist(String email, String password) {
        openLoginPage();
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.verifyAssertTrueIsDisplayed(messageAccDoesNotExist, "Email is incorrect but valid is NOT displayed.");
    }

    public void loginFailWithNullPassword(String email) {
        openLoginPage();
        WebUI.setText(inputEmail, email);
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.verifyAssertTrueIsDisplayed(messageRequiredPassword, "Password is NULL but valid is NOT displayed.");
    }

    public void loginFailWithFailPassword(String email, String password) {
        openLoginPage();
        WebUI.setText(inputEmail, email);
        WebUI.clearText(inputPassword);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.verifyAssertTrueIsDisplayed(messageAccDoesNotExist, "Password is failed but valid is NOT displayed.");
    }

    public static void loginSuccessWithCustomerAccount() {
        openLoginPage();
        WebUI.clickElement(buttonCopyCustomerAcc);
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.verifyAssertTrueIsDisplayed(DashboardPage.titleDashboard, "Dashboard page is NOT displayed.");
    }

    public static void loginSuccessAdminPage(String email, String password) {
        WebUI.openURL(PropertiesHelper.getValue("url_admin"));
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.verifyAssertTrueIsDisplayed(titleAnhTesterAdminPage, "Admin page is NOT displayed.");
    }
}


