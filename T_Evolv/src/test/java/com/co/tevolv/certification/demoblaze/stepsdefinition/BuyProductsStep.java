package com.co.tevolv.certification.demoblaze.stepsdefinition;

import com.co.tevolv.certification.demoblaze.exceptions.GeneralException;
import com.co.tevolv.certification.demoblaze.models.Data;
import com.co.tevolv.certification.demoblaze.models.PaymentData;
import com.co.tevolv.certification.demoblaze.questions.StateofButton;
import com.co.tevolv.certification.demoblaze.questions.TotalPrice;
import com.co.tevolv.certification.demoblaze.tasks.AddProducts;
import com.co.tevolv.certification.demoblaze.tasks.Login;
import com.co.tevolv.certification.demoblaze.tasks.PlaceOrder;
import com.co.tevolv.certification.demoblaze.utils.Constants;
import com.co.tevolv.certification.demoblaze.utils.ValidationErrorMessages;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BuyProductsStep {

    @Managed
    private WebDriver myDriver;
    Actor Yazmin;

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
        Yazmin = OnStage.theActorCalled("Yazmin");
        Yazmin.can(BrowseTheWeb.with(myDriver));
    }

    @Given("^Yazmin has accessed the main page$")
    public void yazminHasAccessedTheMainPage() {
        Yazmin.wasAbleTo(Open.url(Constants.URL));
    }

    @Given("^Yazmin tries to enter her account$")
    public void yazminTriesToEnterHerAccount(List<Data> data) {
        Yazmin.attemptsTo(Login.withCredentials(data));
    }

    @When("^Yazmin try to add some products$")
    public void yazminTryToAddSomeProducts(List<Data> data) {
        Yazmin.attemptsTo(AddProducts.toBuy(data));
    }

    @When("^Yazmin places the order$")
    public void yazminPlacesTheOrder(List<PaymentData> paymentData) {
        Yazmin.attemptsTo(PlaceOrder.withData(paymentData));
    }

    @Then("^Yazmin is going to see products value$")
    public void yazminIsGoingToSeeProductsValue() {
        String totalValue = Yazmin.recall("totalPrice");
        Yazmin.should(seeThat(TotalPrice.ofPurchase(),
                is(equalTo(totalValue)))
                .orComplainWith(GeneralException.class, ValidationErrorMessages.WRONG_PRICE_ASSERTION_MESSAGE));
    }

    @Then("^Yazmin can not continue the payment$")
    public void yazminIsGoingToSeeAAlertMessage() {
        Yazmin.should(seeThat(StateofButton.purchaseEnabled()
                , is(equalTo(true))));
    }
}
