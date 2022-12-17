package ngan.xd.Pages;

import ngan.xd.driver.DriverManager;
import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;

public class AddProductPage {
    private By menuProduct = By.xpath("//span[normalize-space()='Products']");
    private By submenuAddProduct = By.xpath("(//span[normalize-space()='Add New Product'])[1]");
    private By titleAddNewProduct = By.xpath("//h5[normalize-space()='Add New Product']");
    private By blockProductInf = By.xpath("//h5[normalize-space()='Product Information']");
    private By inputProductName = By.xpath("//input[@placeholder='Product Name']");
    private By selectCategory = By.xpath("//button[@data-id= 'category_id']");
    private By inputSearchCategory = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By selectBeautyHealthyCategory = By.xpath("//span[normalize-space()='---- Beauty & Health']");
    private By selectBrand = By.xpath("//div[contains(text(),'Select Brand')]");
    private By selectBrandAudi = By.xpath("//a[@id='bs-select-2-3']");
    private By inputUnit = By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']");
    private By inputWeight = By.xpath("//input[@name='weight']");
    private By inputTags = By.xpath("//span[@aria-placeholder='Type and hit enter to add a tag']");
    private By blockProductImages = By.xpath("//h5[normalize-space()='Product Images']");
    private By selectChooseGalleryImgs = By.xpath("//div[@data-multiple='true']//div[@class='form-control file-amount'][normalize-space()='Choose File']");
    private By selectChooseThumbnailImgs = By.xpath("(//div[contains(text(),'Choose File')])[1]");
    private By updateNewImageTab = By.xpath("//a[normalize-space()='Upload New']");
    private By inputGalleryImages = By.xpath("//input[@class = 'uppy-Dashboard-input']");
    private By buttonAddFileImgs = By.xpath("//button[normalize-space()='Add Files']");
    private By selectFileTab = By.xpath("//a[normalize-space()='Select File']");
    private By selectGalleryImages = By.xpath("(//div[@title='cocacola.png'])[1]");
    private By selectThumbnailImages = By.xpath("(//span[@class='text-truncate title'][normalize-space()='cocacola'])[2]");
    private By inputSearchThumbnailImages = By.xpath("//input[@placeholder='Search your files']");
    private By blockProductVideos = By.xpath("//h5[normalize-space()='Product Videos']");
    private By inputVideoLink = By.xpath("//input[@placeholder='Video Link']");
    private By blockProductPrice = By.xpath("//h5[normalize-space()='Product price + stock']");
    private By inputUnitPrice = By.xpath("//input[@placeholder='Unit price']");
    private By selectDate = By.xpath("//input[@placeholder='Select Date']");
    private By buttonSelectDiscountDate = By.xpath("//button[@class='applyBtn btn btn-sm btn-primary']");
    private By inputDiscount = By.xpath("//input[@placeholder='Discount']");
    private By selectUnitDiscount = By.xpath("(//div[@class='filter-option-inner-inner'][normalize-space()='Flat'])[1]");
    private By selectUnitDiscountPercent = By.xpath("//span[normalize-space()='Percent']");
    private By inputQuantity = By.xpath("//input[@placeholder='Quantity']");
    private By inputSKU = By.xpath("//input[@placeholder='SKU']");
    private By blockProductDescription = By.xpath("//h5[normalize-space()='Product Description']");
    private By inputDescription = By.xpath("//div[@role='textbox']");
    private By buttonSavePublish = By.xpath("//button[normalize-space()='Save & Publish']");
    private By messageAddProductSuccess = By.xpath("//span[@data-notify='message']");

    private static By selectCocaCola = By.xpath("(//a[normalize-space()='CocaCola'])[1]");

    public void addProduct(String email, String password, String productName, String category, String unit, Double weight, String tags, Double unitPrice, String discountDate, int quantity, String SKU, String description, int discount) {
        LoginPage.loginSuccessAdminPage(email, password);
        WebUI.clickElement(menuProduct);
        WebUI.sleep(3);
        WebUI.clickElement(submenuAddProduct);
        WebUI.verifyAssertTrueIsDisplayed(titleAddNewProduct, "Title Add New Product is NOT displayed");
        WebUI.verifyAssertTrueIsDisplayed(blockProductInf, "Product Information block is not displayed");
        WebUI.setText(inputProductName, productName);
        WebUI.clickElement(selectCategory);
        WebUI.setTextEnter(inputSearchCategory, category);
        WebUI.setText(inputUnit, unit);
        WebUI.setText(inputWeight, String.valueOf(weight));
        WebUI.setText(inputTags, tags);
        WebUI.verifyAssertTrueIsDisplayed(blockProductImages, "Product Images block is not displayed");
        WebUI.clickElement(selectChooseGalleryImgs);
        WebUI.clickElement(updateNewImageTab);
        DriverManager.getDriver().findElement(inputGalleryImages).sendKeys(System.getProperty("user.dir") + "/DataTest/cocacola.png");
        WebUI.clickElement(selectFileTab);
        WebUI.clickElement(selectGalleryImages);
        WebUI.clickElement(buttonAddFileImgs);
        WebUI.clickElement(selectChooseThumbnailImgs);
        WebUI.setText(inputSearchThumbnailImages, productName);
        WebUI.sleep(2);
        WebUI.clickElement(selectThumbnailImages);
        WebUI.clickElement(buttonAddFileImgs);
        WebUI.verifyAssertTrueIsDisplayed(blockProductPrice, "Product price block is NOT displayed");
        WebUI.setText(inputUnitPrice, String.valueOf(unitPrice));
        WebUI.setText(selectDate, discountDate);
        WebUI.clickElement(buttonSelectDiscountDate);
        WebUI.setText(inputDiscount, String.valueOf(discount));
        WebUI.clickElement(selectUnitDiscount);
        WebUI.clickElement(selectUnitDiscountPercent);
        WebUI.setText(inputQuantity, String.valueOf(quantity));
        WebUI.setText(inputSKU, SKU);
        WebUI.verifyAssertTrueIsDisplayed(blockProductDescription, "Product description is not displayed");
        WebUI.setText(inputDescription, description);
        WebUI.clickElement(buttonSavePublish);
        WebUI.verifyAssertTrueIsDisplayed(messageAddProductSuccess, "Add Product is failed");
    }

    public static void verifyNewProduct(String productName) {
        LoginPage.openLoginPage();
        WebUI.setTextEnter(DashboardPage.searchProduct, productName);
        WebUI.clickElement(selectCocaCola);
    }
}
