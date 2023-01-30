package com.co.tevolv.certification.demoblaze.tasks;

import com.co.tevolv.certification.demoblaze.UI.PlaceOrderComponent;
import com.co.tevolv.certification.demoblaze.models.PaymentData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

public class PlaceOrder implements Task {

    List<PaymentData> paymentData;

    public PlaceOrder(List<PaymentData> paymentData) {
        this.paymentData = paymentData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PlaceOrderComponent.PLACE_ORDER_BTN),
                Enter.theValue(paymentData.get(0).getName()).into(PlaceOrderComponent.NAME_TXT)
                , Enter.theValue(paymentData.get(0).getCountry()).into(PlaceOrderComponent.COUNTRY_TXT)
                , Enter.theValue(paymentData.get(0).getCity()).into(PlaceOrderComponent.CITY_TXT)
                , Enter.theValue(paymentData.get(0).getCreditCard()).into(PlaceOrderComponent.CREDIT_CARD_TXT)
                , Enter.theValue(paymentData.get(0).getMonth()).into(PlaceOrderComponent.MONTH_TXT)
                , Enter.theValue(paymentData.get(0).getYear()).into(PlaceOrderComponent.YEAR_TXT)
                , Click.on(PlaceOrderComponent.PURCHASE_BTN)
        );
    }

    public static PlaceOrder withData(List<PaymentData> paymentData) {
        return Tasks.instrumented(PlaceOrder.class, paymentData);
    }
}
