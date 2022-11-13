package ngan.xd.Tests;

import ngan.xd.Common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testLogin(){
        getLoginPage().login();
    }
}
