package ngan.xd.Pages;

import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;

import java.nio.file.WatchEvent;

public class OrderPage {
    private By selectProductShoes = By.xpath("//img[@alt=\"Men's Running Shoes Non Slip Athletic Tennis Walking Blade Type Sneakers\"]");
    private By buttonAddToCart = By.xpath("//i[@class='las la-shopping-bag']");
    private By popupAddToCartSucceeded = By.xpath("//h3[normalize-space()='Item added to your cart!']");
    private By buttonBackToShopping = By.xpath("//button[normalize-space()='Back to shopping']");
    private By selectProductShirt = By.xpath("//img[@alt='Men Slim Fit Checkered Spread Collar Casual Shirt']");
    private By buttonPlus = By.xpath("//i[@class='las la-plus']");
    private By buttonProcessToCheckout = By.xpath("//a[normalize-space()='Proceed to Checkout']");
    private By buttonContinueToShipping = By.xpath("//a[normalize-space()='Continue to Shipping']");
    private By buttonContinueToDeliveryInfo = By.xpath("//button[normalize-space()='Continue to Delivery Info']");
    private By checkboxAgreeTermAndConditions = By.xpath("//span[@class='aiz-square-check']");
    private By buttonCompleteOrder = By.xpath("//button[normalize-space()='Complete Order']");

    public void order() {
        LoginPage.loginSuccessWithCustomerAccount();
        WebUI.setTextEnter(DashboardPage.searchProduct, "shoes");
        WebUI.clickElement(selectProductShoes);
        WebUI.clickElement(buttonAddToCart);
        WebUI.verifyAssertTrueIsDisplayed(popupAddToCartSucceeded, "Add to cart is failed");
        WebUI.clickElement(buttonBackToShopping);
        WebUI.setTextEnter(DashboardPage.searchProduct, "shirt");
        WebUI.clickElement(selectProductShirt);
        WebUI.clickElement(buttonPlus);
        WebUI.clickElement(buttonAddToCart);
        WebUI.verifyAssertTrueIsDisplayed(popupAddToCartSucceeded, "Add to cart is failed");

    }

}
