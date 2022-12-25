package ngan.xd.Pages;

import ngan.xd.driver.DriverManager;
import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.nio.file.WatchEvent;

public class OrderPage {
    private By selectProductShoes = By.xpath("//img[@alt=\"Men's Running Shoes Non Slip Athletic Tennis Walking Blade Type Sneakers\"]");
    private By buttonAddToCart = By.xpath("//button[@class='btn btn-soft-primary mr-2 add-to-cart fw-600']");
    private By popupAddToCartSucceeded = By.xpath("//h3[normalize-space()='Item added to your cart!']");
    private By clodeSuccessAddToCartPopup = By.xpath("//span[@class = 'la-2x']");
    private By buttonBackToShopping = By.xpath("//button[normalize-space()='Back to shopping']");
    private By selectProductCoca = By.xpath("(//a[@class='d-block text-reset'][normalize-space()='CocaCola'])[1]");
    private By buttonPlus = By.xpath("//button[contains(@data-type,'plus')]");
    private By buttonCart = By.xpath("//i[@class='la la-shopping-cart la-2x opacity-80']");
    private By viewProductOrderOnCart = By.xpath("//span[@class='fw-600 mb-1 text-truncate-2']");
    private By buttonCheckoutOnCartPopup = By.xpath("//a[normalize-space()='Checkout']");
    private By buttonAddNewAddress = By.xpath("//div[@class='border p-3 rounded mb-3 c-pointer text-center bg-white h-100 d-flex flex-column justify-content-center']");
    private By verifyCheckedAddress = By.xpath("(//input[@name = 'address_id' ])[2]");
    private By buttonProcessToCheckout = By.xpath("//a[normalize-space()='Proceed to Checkout']");
    private By buttonContinueToShipping = By.xpath("//a[normalize-space()='Continue to Shipping']");
    private By buttonContinueToDeliveryInfo = By.xpath("//button[normalize-space()='Continue to Delivery Info']");
    private By verifyProductAtStepCheckout = By.xpath("//span[@class='fs-14 opacity-60' and normalize-space() = 'Womens Summer Plus Size Lace Neckline Cold Shoulder Short Sleeve']");
    private By buttonContinueToPament = By.xpath("//button[normalize-space()='Continue to Payment']");
    private By textboxInforOrder = By.xpath("//textarea[@placeholder='Type your text']");

    private By checkboxAgreeTermAndConditions = By.xpath("//span[@class='aiz-square-check']");
    private By buttonCompleteOrder = By.xpath("//button[normalize-space()='Complete Order']");
    private By messageOrderSuccess = By.xpath("//h1[normalize-space()='Thank You for Your Order!']");
    private By quantityProduct = By.xpath("//input[@name='quantity']");
    private By titleNewAddress = By.xpath("//div[@id='new-address-modal']//h5[@id='exampleModalLabel']");
    private By inputYourAddress = By.xpath("//textarea[@placeholder='Your Address']");
    private By selectCountry = By.xpath("//div[contains(text(),'Select your country')]");

    public void addNewAddress() {

    }

    public void order() {
        LoginPage.loginSuccessWithCustomerAccount();
//        WebUI.setTextEnter(DashboardPage.searchProduct, "shoes");
//        WebUI.scrollToElement(selectProductShoes);
//        WebUI.clickElement(selectProductShoes);
//        WebUI.scrollToElement(buttonAddToCart);
//        WebUI.clickElement(buttonAddToCart);
//        WebUI.verifyAssertTrueIsDisplayed(popupAddToCartSucceeded, "Add to cart is failed");
//        WebUI.clickElement(buttonBackToShopping);
        WebUI.setTextEnter(DashboardPage.searchProduct, "coca cola");
        WebUI.clickElement(selectProductCoca);
        WebUI.clickElement(buttonPlus);
        WebUI.sleep(6);
//        System.out.println(DriverManager.getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("value"));
//        WebUI.verifyEquals(DriverManager.getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("value"), 2, "number of failed products");
        WebUI.scrollToElement(buttonAddToCart);
        WebUI.clickElement(buttonAddToCart);
        WebUI.verifyAssertTrueIsDisplayed(popupAddToCartSucceeded, "Add to cart is failed");
        WebUI.clickElement(clodeSuccessAddToCartPopup);
        WebUI.clickElement(buttonCart);
        WebUI.verifyAssertTrueIsDisplayed(viewProductOrderOnCart, "My product is NOT displayed");
        WebUI.clickElement(buttonCheckoutOnCartPopup);
//        WebUI.clickElement(selectAddressForOrder);
//        Assert.assertTrue(DriverManager.getDriver().findElement(verifyCheckedAddress).getAttribute("checked").equals("true"), "Address is NOT selected");
        WebUI.clickElement(buttonContinueToDeliveryInfo);
        WebUI.verifyAssertTrueIsDisplayed(verifyProductAtStepCheckout, "My product is NOT displayed");
        WebUI.clickElement(buttonContinueToPament);
        WebUI.setText(textboxInforOrder, "delivery as soon as possible");
        WebUI.scrollToElement(checkboxAgreeTermAndConditions);
        WebUI.clickElement(checkboxAgreeTermAndConditions);
        WebUI.clickElement(buttonCompleteOrder);
        WebUI.verifyAssertTrueIsDisplayed(messageOrderSuccess, "Order is failed");
        String x = DriverManager.getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("value");
    }

}
