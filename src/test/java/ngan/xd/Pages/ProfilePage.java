package ngan.xd.Pages;

import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;

public class ProfilePage {
    private By menuManageProfile = By.xpath("//div[@class='d-flex align-items-start']//span[@class='aiz-side-nav-text' and normalize-space()='Manage Profile']");
    private By titleManageProfile = By.xpath("//h1[normalize-space()='Manage Profile']");
    private By inputName = By.xpath("//input[@placeholder='Your Name']");
    private By inputPhone = By.xpath("//input[@placeholder='Your Phone']");
    private By selectavatar = By.xpath("//div[@class='form-control file-amount']");
    private By inputPassword = By.xpath("//input[@placeholder='New Password']");
    private By inputConfirmPassword = By.xpath("//input[@placeholder='Confirm Password']");
    private By buttonUpdateProfile = By.xpath("//button[normalize-space()='Update Profile']");

    private By messageNotPermitted = By.xpath("//span[@data-notify='message' and normalize-space() = 'Sorry! the action is not permitted in demo']");

    public void updateProfile() {
        LoginPage.loginSuccessWithCustomerAccount();
        WebUI.clickElement(menuManageProfile);
        WebUI.verifyAssertTrueIsDisplayed(titleManageProfile, "Manage Profile page is NOT displayed");
        WebUI.setText(inputName, "Paul K. Jensen 01");
        WebUI.setText(inputPhone, "208-295-8053-01");
        WebUI.setText(inputPassword, "123456");
        WebUI.setText(inputConfirmPassword, "123456");
        WebUI.clickElement(buttonUpdateProfile);
        WebUI.verifyAssertTrueIsDisplayed(messageNotPermitted, "The message not allowed in the demo is not displayed");
    }

}
