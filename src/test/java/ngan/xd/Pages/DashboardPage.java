package ngan.xd.Pages;

import org.openqa.selenium.By;

public class DashboardPage {
    public static By titleDashboard = By.xpath("//h1[normalize-space()='Dashboard']");
    public static By menuHome = By.xpath("//a[contains(text(),'Home')]");
    public static By searchProduct = By.xpath("//input[@id='search']");
    public static By buttonsubmitSearch = By.xpath("//div[@class='input-group-append d-none d-lg-block']//button[@type='submit']");
    
}
