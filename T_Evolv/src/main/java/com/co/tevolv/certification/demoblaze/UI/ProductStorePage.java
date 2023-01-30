package com.co.tevolv.certification.demoblaze.UI;

import net.serenitybdd.screenplay.targets.Target;

public class ProductStorePage {

    public static final Target CATEGORIES_BTN=Target.the("the button to select the category").
            locatedBy("//*[text()='{0}']");

    public static final Target PRODUCTS_BTN=Target.the("the btn to select one item").
            locatedBy("//*[text()='{0}']");
    public static final Target ADD_PRODUCTS_BTN=Target.the("the btn to add one item to cart").
            locatedBy("//*[text()='Add to cart']");
    public static final Target HOME_BTN=Target.the("the btn to back to home").
            locatedBy("(//*[@class='nav-link'])[1]");
    public static final Target CART_BTN=Target.the("the btn to go to the cart shopping").
            locatedBy("//*[text()='Cart']");

    public static final Target PRICE_PRODUCTS_LBL=Target.the("the label to validate the product's price").
            locatedBy("//*[@class='price-container']");

}
