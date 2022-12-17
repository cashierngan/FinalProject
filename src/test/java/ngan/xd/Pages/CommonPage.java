package ngan.xd.Pages;

public class CommonPage {
    public LoginPage loginPage;
    public ProfilePage profilePage;
    public OrderPage orderPage;
    public AddProductPage addProductPage;

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public ProfilePage getProfilePage() {
        if (profilePage == null) {
            profilePage = new ProfilePage();
        }
        return profilePage;
    }

    public OrderPage getOrderPage() {
        if (orderPage == null) {
            orderPage = new OrderPage();
        }
        return orderPage;
    }

    public AddProductPage getAddProductPage() {
        if (addProductPage == null) {
            addProductPage = new AddProductPage();
        }
        return addProductPage;
    }
}
