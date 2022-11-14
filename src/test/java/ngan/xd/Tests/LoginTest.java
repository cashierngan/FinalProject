package ngan.xd.Tests;

import ngan.xd.Common.BaseTest;
import ngan.xd.helpers.ExcelHelpers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    public ExcelHelpers excel;

    @BeforeMethod
    public void LoginTest() {
        excel = new ExcelHelpers();
        excel.setExcelFile("DataTest/Login.xlsx", "Login");
    }

    @Test(priority = 1)
    public void loginFailWithNullEmail() {
        getLoginPage().loginFailWithNullEmail();
    }

    @Test(priority = 2)
    public void loginFailWithEmailDoesNotExist() {
//        ExcelHelpers excel = new ExcelHelpers();
//        excel.setExcelFile("DataTest/Login.xlsx", "Login");
        getLoginPage().loginFailWithEmailDoesNotExist(excel.getCellData("email", 1), excel.getCellData("password", 1));
    }

//    @Test(priority = 3)
//    public void loginFailWithNullPassword() {
//        getLoginPage().loginFailWithNullPassword();
//    }
//
//    @Test(priority = 4)
//    public void loginFailWithFailPassword() {
//        getLoginPage().loginFailWithFailPassword();
//    }

    @Test(priority = 5)
    public void loginSuccessWithCustomerAccount() {
        getLoginPage().loginSuccessWithCustomerAccount();
    }
}
