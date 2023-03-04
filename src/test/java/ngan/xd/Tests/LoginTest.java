package ngan.xd.Tests;

import ngan.xd.Common.BaseTest;
import ngan.xd.helpers.ExcelHelpers;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    public ExcelHelpers excel;

    @Test(priority = 1)
    public void loginFailWithNullEmail() {
        getLoginPage().loginFailWithNullEmail();
    }

    @Test(priority = 2)
    public void loginFailWithEmailDoesNotExist() {
        excel = new ExcelHelpers();
        excel.setExcelFile("DataTest/Login.xlsx", "Login");
        getLoginPage().loginFailWithEmailDoesNotExist(excel.getCellData("email", 1), excel.getCellData("password", 1));
    }

    @Test(priority = 3)
    public void loginFailWithNullPassword() {
        excel = new ExcelHelpers();
        excel.setExcelFile("DataTest/Login.xlsx", "Login");
        getLoginPage().loginFailWithNullPassword(excel.getCellData("email", 2));
    }

    @Test(priority = 4)
    public void loginFailWithIncorrectPassword() {
        excel = new ExcelHelpers();
        excel.setExcelFile("DataTest/Login.xlsx", "Login");
        getLoginPage().loginFailWithIncorrectPassword(excel.getCellData("email", 3), excel.getCellData("password", 3));
    }

    @Test(priority = 5)
    public void loginSuccessWithCustomerAccount() {
        excel = new ExcelHelpers();
        excel.setExcelFile("DataTest/Login.xlsx", "Login");
        getLoginPage().loginSuccessWithCustomerAccount(excel.getCellData("email", 4), excel.getCellData("password", 4));
    }

    @Test(priority = 6)
    public void loginSuceessAdminPage() {
        excel = new ExcelHelpers();
        excel.setExcelFile("DataTest/Login.xlsx", "Login");
        getLoginPage().loginSuccessAdminPage(excel.getCellData("email", 5), excel.getCellData("password", 5));
    }
}
