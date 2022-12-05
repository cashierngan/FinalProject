package ngan.xd.Tests;

import ngan.xd.Common.BaseTest;
import ngan.xd.Pages.ProfilePage;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {
    @Test(priority = 1)
    public void updateProfile() {
        getProfilePage().updateProfile();
    }

    @Test(priority = 2)
    public void updateEmail() {
        getProfilePage().updateEmail();
    }

    @Test(priority = 3)
    public void addNewAddress() {
        getProfilePage().addNewAddress();
    }
}
