package com.co.tevolv.certification.demoblaze.questions;

import com.co.tevolv.certification.demoblaze.UI.PlaceOrderComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class StateofButton implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return PlaceOrderComponent.PURCHASE_BTN.resolveFor(actor).isEnabled();
    }

    public static StateofButton purchaseEnabled(){
        return new StateofButton();
    }
}
