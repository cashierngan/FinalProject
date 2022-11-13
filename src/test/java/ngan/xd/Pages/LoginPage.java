package ngan.xd.Pages;

import ngan.xd.helpers.PropertiesHelper;
import ngan.xd.utils.WebUI;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonPage {
    public void login(){
        WebUI.openURL(PropertiesHelper.getValue("url"));
        WebUI.sleep(5);
    }
}
