package ngan.xd.Pages;

public class CommonPage {
    public LoginPage loginPage;
    public LoginPage getLoginPage(){
        if(loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }
}
