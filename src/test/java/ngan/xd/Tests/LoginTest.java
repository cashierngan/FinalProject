package ngan.xd.Tests;

import ngan.xd.Common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void loginFailwithNullEmail() {
        getLoginPage().login();
        getLoginPage().loginFailwithNullEmail();
    }
}
