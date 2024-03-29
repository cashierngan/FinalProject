package ngan.xd.Pages;

import ngan.xd.driver.DriverManager;
import ngan.xd.helpers.PropertiesHelper;
import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoPage extends CommonPage {
    private By productName = By.xpath("//h1[normalize-space()='ChocoPie']");
    public static By productPrice = By.xpath("//strong[@class='h2 fw-600 text-primary']");
    private By productUnit = By.xpath("//span[@class='opacity-70']");
    private By productDescription = By.xpath("//div[@class = 'mw-100 overflow-auto text-left aiz-editor-data']/p");
    private By selectProductCosy = By.xpath("(//a[@class = 'd-block text-reset' ])[1]");

    public ArrayList productInfo(String product, String email, String password) {
        LoginPage.loginSuccessWithCustomerAccount(email, password);
        WebUI.setTextEnter(DashboardPage.searchProduct, product);
        WebUI.clickElement(selectProductCosy);

        String name = DriverManager.getDriver().findElement(selectProductCosy).getText();
        String price = DriverManager.getDriver().findElement(productPrice).getText();
        String unit = DriverManager.getDriver().findElement(productUnit).getText();
        String unitProduct = unit.substring(1);
        String description = DriverManager.getDriver().findElement(productDescription).getText();
        List<String> arrayList = new ArrayList<String>();
        arrayList.add(name);
        arrayList.add(price);
        arrayList.add(unitProduct);
        arrayList.add(description);
        System.out.println("Array" + arrayList);
        System.out.println("Array" + arrayList.get(0));
        return (ArrayList) arrayList;
    }
}
