package com.co.tevolv.certification.demoblaze.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PlaceOrderComponent {

    public static final Target PLACE_ORDER_BTN=Target.the("the button to place order").
            locatedBy("//*[@class='btn btn-success']");
  public static final Target NAME_TXT=Target.the("the field to type the name").
            located(By.id("name"));

  public static final Target COUNTRY_TXT=Target.the("the field to type the country").
            located(By.id("country"));

  public static final Target CITY_TXT=Target.the("the field to type the city").
            located(By.id("city"));

  public static final Target CREDIT_CARD_TXT=Target.the("the field to type the card").
            located(By.id("card"));

  public static final Target MONTH_TXT=Target.the("the field to type the month").
            located(By.id("month"));

  public static final Target YEAR_TXT=Target.the("the field to type the year").
            located(By.id("year"));

  public static final Target PURCHASE_BTN=Target.the("the button to purchase").
            locatedBy("//*[@onclick='purchaseOrder()']");

  public static final Target AMOUNT_LBL=Target.the("the label where the total price is displayed").
            locatedBy("//*[@class='lead text-muted ']");


}
