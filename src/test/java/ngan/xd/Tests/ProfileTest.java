package ngan.xd.Tests;

import ngan.xd.Common.BaseTest;
import ngan.xd.Pages.ProfilePage;
import ngan.xd.helpers.ExcelHelpers;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {
    ExcelHelpers excel;

    @Test(priority = 1)
    public void updateProfile() {
        excel = new ExcelHelpers();
        excel.setExcelFile("DataTest/Login.xlsx", "Login");
        getProfilePage().updateProfile(excel.getCellData("email", 4), excel.getCellData("password", 4));
    }

    @Test(priority = 2)
    public void updateEmail() {
        excel = new ExcelHelpers();
        excel.setExcelFile("DataTest/Login.xlsx", "Login");
        getProfilePage().updateEmail(excel.getCellData("email", 4), excel.getCellData("password", 4));
    }

    @Test(priority = 3)
    public void addNewAddress() {
        excel = new ExcelHelpers();
        excel.setExcelFile("DataTest/Login.xlsx", "Login");
        getProfilePage().addNewAddress(excel.getCellData("email", 4), excel.getCellData("password", 4));
    }
}
