package com.co.tevolv.certification.demoblaze.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class ClosePopUp implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver=BrowseTheWeb.as(actor).getDriver();

        try {
            Thread.sleep(4000);
            Alert alt = driver.switchTo().alert();
            alt.accept();
        } catch (Exception e) {
            throw new RuntimeException("Error by trying to close the PopUp:"+e);
        }
    }

    public static ClosePopUp cart (){
        return new ClosePopUp();
    }
}
