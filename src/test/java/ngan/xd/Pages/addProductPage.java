package ngan.xd.Pages;

import org.openqa.selenium.By;

public class addProductPage {
    private By menuProduct = By.xpath("//span[normalize-space()='Products']");
    private By submenuAddProduct = By.xpath("//span[normalize-space()='Add New product']");
    private By blockProductInf = By.xpath("//h5[normalize-space()='Product Information']");
    private By inputProductName = By.xpath("//input[@placeholder='Product Name']");
    private By selectCategory = By.xpath("//button[@title='Women Clothing & Fashion']");
    private By selectBeautyHealthyCategory = By.xpath("//span[normalize-space()='---- Beauty & Health']");
    private By selectBrand = By.xpath("//div[contains(text(),'Select Brand')]");
    private By selectBrandAudi = By.xpath("//a[@id='bs-select-2-3']");
    private By inputUnit = By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']");
    private By inputWeight = By.xpath("//input[@name='weight']");
    private By inputTags = By.xpath("//span[@aria-placeholder='Type and hit enter to add a tag']");
    private By blockProductImages = By.xpath("//h5[normalize-space()='Product Images']");
    private By selectGalleryImages = By.xpath("//div[@data-multiple='true']//div[@class='form-control file-amount'][normalize-space()='Choose File']");
    private By selectThumbnailImages = By.xpath("");
    private By blockProductVideos = By.xpath("//h5[normalize-space()='Product Videos']");
    private By inputVideoLink = By.xpath("//input[@placeholder='Video Link']");
    private By blockProductPrice = By.xpath("//h5[normalize-space()='Product price + stock']");
    private By inputUnitPrice = By.xpath("//input[@placeholder='Unit price']");
    private By selectDate = By.xpath("//input[@placeholder='Select Date']");
    private By nextMonth = By.xpath("//th[@class='next available']");
    private By selectDate01032023 = By.xpath("//td[@class='active start-date available in-range']");
    private By buttonSelectDiscountDate = By.xpath("//button[@class='applyBtn btn btn-sm btn-primary']");
}
