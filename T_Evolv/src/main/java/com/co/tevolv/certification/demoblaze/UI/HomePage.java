package com.co.tevolv.certification.demoblaze.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target LOG_IN_BTN=Target.the("button to log-in").
            located(By.id("login2"));

    public static final Target USERNAME_TXT=Target.the("the field to type the username").
            located(By.id("loginusername"));

    public static final Target PASSWORD_TXT=Target.the("the field to type the password").
            located(By.id("loginpassword"));
    public static final Target LOG_IN_BTN2=Target.the("the button to send the account to login").
            locatedBy("//*[@onclick='logIn()']");
}
