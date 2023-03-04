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
    private By titleChangeEmail = By.xpath("//h5[normalize-space()='Change your email']");
    private By inputEmail = By.xpath("//input[@placeholder='Your Email']");
    private By buttonVerifyEmail = By.xpath("//button[@class='btn btn-outline-secondary new-email-verification']");
    private By buttonUpdateEmail = By.xpath("//button[normalize-space()='Update Email']");
    private By messageUpdateEmailSuccess = By.xpath("//span[@data-notify='message']");
    private By titleAddress = By.xpath("//h5[normalize-space()='Address']");
    private By buttonAddNewAddress = By.xpath("//div[@class='border p-3 rounded mb-3 c-pointer text-center bg-light']");
    private By titlePopupNewAddress = By.xpath("//div[@id='new-address-modal']//h5[@id='exampleModalLabel']");
    private By inputYourAddress = By.xpath("//textarea[@placeholder='Your Address']");
    private By selectCountry = By.xpath("//div[contains(text(),'Select your country')]");
    private By selectCountryAustralia = By.xpath("//a[@id='bs-select-1-13']");
    private By selectState = By.xpath("//div[contains(text(),'Select State')]");
    private By searchState = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By selectCity = By.xpath("//div[contains(text(),'Select City')]");
    private By selectCityBalmain = By.xpath("//a[@id='bs-select-3-1']");
    private By inputPastalCode = By.xpath("//input[@placeholder='Your Postal Code']");
    private By inputPhoneAddress = By.xpath("//input[@placeholder='+880']");
    private By buttonSaveNewAddress = By.xpath("//button[normalize-space()='Save']");


    public void updateProfile(String email, String password) {
        LoginPage.loginSuccessWithCustomerAccount(email, password);
        WebUI.clickElement(menuManageProfile);
        WebUI.verifyAssertTrueIsDisplayed(titleManageProfile, "Manage Profile page is NOT displayed");
        WebUI.setText(inputName, "Paul K. Jensen 01");
        WebUI.setText(inputPhone, "208-295-8053-01");
        WebUI.setText(inputPassword, "123456");
        WebUI.setText(inputConfirmPassword, "123456");
        WebUI.clickElement(buttonUpdateProfile);
        WebUI.verifyAssertTrueIsDisplayed(messageNotPermitted, "The message not allowed in the demo is not displayed");
    }

    public void updateEmail(String email, String password) {
        LoginPage.loginSuccessWithCustomerAccount(email, password);
        WebUI.clickElement(menuManageProfile);
        WebUI.scrollToElement(titleChangeEmail);
        WebUI.verifyAssertTrueIsDisplayed(titleChangeEmail, "Title Change your email is NOT displayed");
        WebUI.setText(inputEmail, "cashierngan001@gmail.com");
        WebUI.clickElement(buttonUpdateEmail);
        WebUI.verifyAssertTrueIsDisplayed(messageUpdateEmailSuccess, "Update email is failed");
    }

    public void addNewAddress(String email, String password) {
        LoginPage.loginSuccessWithCustomerAccount(email, password);
        WebUI.clickElement(menuManageProfile);
        WebUI.scrollToElement(titleAddress);
        WebUI.verifyAssertTrueIsDisplayed(titleAddress, "Change address block is NOT displayed");
        WebUI.clickElement(buttonAddNewAddress);
        WebUI.verifyAssertTrueIsDisplayed(titlePopupNewAddress, "Popup New Address is NOT displayed");
        WebUI.setText(inputYourAddress, "31a, JJN.KenHi");
        WebUI.clickElement(selectCountry);
        WebUI.clickElement(selectCountryAustralia);
        WebUI.clickElement(selectState);
        WebUI.setTextEnter(searchState, "Balmain");
        WebUI.clickElement(selectCity);
        WebUI.clickElement(selectCityBalmain);
        WebUI.setText(inputPastalCode, "5685");
        WebUI.setText(inputPhoneAddress, "0967313406");
        WebUI.clickElement(buttonSaveNewAddress);
    }

}
