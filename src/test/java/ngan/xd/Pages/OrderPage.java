package ngan.xd.Pages;

import org.openqa.selenium.By;

public class OrderPage {
    private By selectProductShoes = By.xpath("//img[@alt=\"Men's Running Shoes Non Slip Athletic Tennis Walking Blade Type Sneakers\"]");
    private By buttonAddToCart = By.xpath("//i[@class='las la-shopping-bag']");
    private By popupAddToCartSucceeded = By.xpath("//h3[normalize-space()='Item added to your cart!']");
    private By buttonBackToShopping = By.xpath("//button[normalize-space()='Back to shopping']");
    private By selectProductIphone13 = By.xpath("//img[@alt='Apple iPhone 13 Pro Max (128 GB, Alpine Green)']");
    private By buttonPlus = By.xpath("//i[@class='las la-plus']");
    private By buttonProcessToCheckout = By.xpath("//a[normalize-space()='Proceed to Checkout']");
    private By buttonContinueToShipping = By.xpath("//a[normalize-space()='Continue to Shipping']");
    private By buttonContinueToDeliveryInfo = By.xpath("//button[normalize-space()='Continue to Delivery Info']");
    private By checkboxAgreeTermAndConditions = By.xpath("//span[@class='aiz-square-check']");
    private By buttonCompleteOrder = By.xpath("//button[normalize-space()='Complete Order']");
    

}
