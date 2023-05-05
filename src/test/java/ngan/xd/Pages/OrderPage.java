package ngan.xd.Pages;

import ngan.xd.driver.DriverManager;
import ngan.xd.helpers.PropertiesHelper;
import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.xml.Parser;

import java.nio.file.WatchEvent;

public class OrderPage {
    private By selectProductNabati = By.xpath("(//a[contains(text(),'Nabati')])[1]");
    private By selectProduct1 = By.xpath("(//a[contains(text(),'Cosy')])[1]");
    private By buttonAddToCart = By.xpath("//button[@class='btn btn-soft-primary mr-2 add-to-cart fw-600']");
    private By popupAddToCartSucceeded = By.xpath("//h3[normalize-space()='Item added to your cart!']");
    private By clodeSuccessAddToCartPopup = By.xpath("//span[@class = 'la-2x']");
    private By buttonBackToShopping = By.xpath("//button[normalize-space()='Back to shopping']");
    private By selectProduct2 = By.xpath("(//a[@class = 'd-block text-reset' ])[1]");
    private By buttonPlus = By.xpath("//button[contains(@data-type,'plus')]");
    private By buttonCart = By.xpath("//i[@class='la la-shopping-cart la-2x opacity-80']");
    private By viewProductOrderOnCart = By.xpath("//span[@class='fw-600 mb-1 text-truncate-2']");
    private By buttonCheckoutOnCartPopup = By.xpath("//a[normalize-space()='Checkout']");
    private By buttonAddNewAddress = By.xpath("//div[@class='border p-3 rounded mb-3 c-pointer text-center bg-white h-100 d-flex flex-column justify-content-center']");
    private By verifyCheckedAddress = By.xpath("(//input[@name = 'address_id' ])[2]");
    private By buttonProcessToCheckout = By.xpath("//a[normalize-space()='Proceed to Checkout']");
    private By buttonContinueToShipping = By.xpath("//a[normalize-space()='Continue to Shipping']");
    private By buttonContinueToDeliveryInfo = By.xpath("//button[normalize-space()='Continue to Delivery Info']");
    private By verifyProductNabatiAtStepCheckout = By.xpath("//span[@class='fs-14 opacity-60'][normalize-space()='Nabati']");
    private By verifyProductChocoPieAtStepCheckout = By.xpath("//span[@class='fs-14 opacity-60'][normalize-space()='ChocoPie']");
    private By buttonContinueToPament = By.xpath("//button[normalize-space()='Continue to Payment']");
    private By textboxInforOrder = By.xpath("//textarea[@placeholder='Type your text']");

    private By checkboxAgreeTermAndConditions = By.xpath("//span[@class='aiz-square-check']");
    private By buttonCompleteOrder = By.xpath("//button[normalize-space()='Complete Order']");
    private By messageOrderSuccess = By.xpath("//h1[normalize-space()='Thank You for Your Order!']");
    private By quantityProduct = By.xpath("//input[@name='quantity']");
    private By titleNewAddress = By.xpath("//div[@id='new-address-modal']//h5[@id='exampleModalLabel']");
    private By inputYourAddress = By.xpath("//textarea[@placeholder='Your Address']");
    private By selectCountry = By.xpath("//div[contains(text(),'Select your country')]");
    private By buttonSelectAddress = By.xpath("(//span[@class='aiz-rounded-check flex-shrink-0 mt-1'])[1]");
    private By quantity = By.xpath("//input[@name='quantity']");
    private By paymentPage = By.xpath("//h3[normalize-space()='Any additional info?']");
    private By totalPrice = By.xpath("//tr[@class = 'cart-subtotal']//td[@class = 'text-right']//span");

    public void order(String noteForOrder, String email, String password) {
        LoginPage.loginSuccessWithCustomerAccount(email, password);
        WebUI.setTextEnter(DashboardPage.searchProduct, PropertiesHelper.getValue("product_P01"));
        WebUI.clickElement(By.xpath("(//a[contains(text(),'" + PropertiesHelper.getValue("product_P01") + "')])[1]"));
        String nabatiPrice = DriverManager.getDriver().findElement(ProductInfoPage.productPrice).getText().trim();
        WebUI.scrollToElement(buttonAddToCart);
        WebUI.clickElement(buttonAddToCart);
        WebUI.verifyAssertTrueIsDisplayed(popupAddToCartSucceeded, "Add to cart is failed");
        WebUI.clickElement(buttonBackToShopping);
        WebUI.setTextEnter(DashboardPage.searchProduct, PropertiesHelper.getValue("product_P02"));
        WebUI.clickElement(By.xpath("(//a[contains(text(),'" + PropertiesHelper.getValue("product_P02") + "')])[1]"));
        String chocoPiePrice = DriverManager.getDriver().findElement(ProductInfoPage.productPrice).getText().trim();
        WebUI.clickElement(buttonPlus);
        String quantities = DriverManager.getDriver().findElement(quantity).getAttribute("value").trim();
        WebUI.verifyAssertTrueAttribute(quantity, "value", "2", "number of failed products");
        WebUI.scrollToElement(buttonAddToCart);
        WebUI.clickElement(buttonAddToCart);
        WebUI.verifyAssertTrueIsDisplayed(popupAddToCartSucceeded, "Add to cart is failed");
        WebUI.clickElement(clodeSuccessAddToCartPopup);
        WebUI.clickElement(buttonCart);
        WebUI.verifyAssertTrueIsDisplayed(viewProductOrderOnCart, "My product is NOT displayed");
        WebUI.clickElement(buttonCheckoutOnCartPopup);
        WebUI.scrollToElement(buttonSelectAddress);
        WebUI.clickElement(buttonSelectAddress);
        WebUI.clickElement(buttonContinueToDeliveryInfo);
//        WebUI.verifyAssertTrueIsDisplayed(verifyProductNabatiAtStepCheckout, "My product is NOT displayed");
//        WebUI.verifyAssertTrueIsDisplayed(verifyProductChocoPieAtStepCheckout, "My product is NOT displayed");
        WebUI.scrollToElement(buttonContinueToPament);
        WebUI.clickElement(buttonContinueToPament);
        WebUI.verifyAssertTrueIsDisplayed(paymentPage, "Step Payment is NOT displayed");
        WebUI.setText(textboxInforOrder, noteForOrder);
        WebUI.scrollToElement(checkboxAgreeTermAndConditions);
        WebUI.clickElement(checkboxAgreeTermAndConditions);
        int nabatiPriceFinal = Integer.parseInt(nabatiPrice.replace("$", "").replace(",", "").split("\\.")[0]);
        int quantitiesChocoPie = Integer.parseInt(quantities);
        int chocoPiePriceFinal = (Integer.parseInt(chocoPiePrice.replace("$", "").replace(",", "").split("\\.")[0])) * quantitiesChocoPie;
        int sumPrice = nabatiPriceFinal + chocoPiePriceFinal;
        int subTotal = Integer.parseInt(DriverManager.getDriver().findElement(totalPrice).getText().replace("$", "").replace(",", "").split("\\.")[0]);
        System.out.println("subtotal: " + subTotal);
        System.out.println("chocopie: " + chocoPiePriceFinal);
        System.out.println("nabati: " + nabatiPriceFinal);
        System.out.println("sum: " + sumPrice);
        WebUI.sleep(3);
        WebUI.verifyEquals(sumPrice, subTotal, "The total price is failed");
        WebUI.clickElement(buttonCompleteOrder);
        WebUI.verifyAssertTrueIsDisplayed(messageOrderSuccess, "Order is failed");
    }

}
