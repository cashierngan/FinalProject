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

    public void login(){
        WebUI.openURL(PropertiesHelper.getValue("url"));
        WebUI.sleep(5);
    }
}
