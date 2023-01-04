package ngan.xd.Pages;

import ngan.xd.driver.DriverManager;
import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoPage extends CommonPage {
    private By productName = By.xpath("//h1[normalize-space()='ChocoPie']");
    private By productPrice = By.xpath("//strong[@class='h2 fw-600 text-primary']");
    private By productUnit = By.xpath("//span[@class='opacity-70']");
    private By productDescription = By.xpath("//div[@class = 'mw-100 overflow-auto text-left aiz-editor-data']/p");
    private By selectProductChocoPie = By.xpath("(//img[@alt='ChocoPie'])[1]");

    public ArrayList productInfo() {
        LoginPage.loginSuccessWithCustomerAccount();
        WebUI.setTextEnter(DashboardPage.searchProduct, "ChocoPie");
        WebUI.clickElement(selectProductChocoPie);
        String name = DriverManager.getDriver().findElement(productName).getText();
        String price = DriverManager.getDriver().findElement(productPrice).getText();
        String unit = DriverManager.getDriver().findElement(productUnit).getText();
        String unitProduct = unit.substring(1, unit.length());
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
