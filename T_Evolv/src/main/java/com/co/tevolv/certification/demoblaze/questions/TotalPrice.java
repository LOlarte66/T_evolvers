package com.co.tevolv.certification.demoblaze.questions;

import com.co.tevolv.certification.demoblaze.UI.PlaceOrderComponent;
import com.co.tevolv.certification.demoblaze.utils.Conversions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TotalPrice implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        String aux= Text.of(PlaceOrderComponent.AMOUNT_LBL).viewedBy(actor).asString();
        return Conversions.TransformStringTotalPriceQuestion(aux);
    }
    public static TotalPrice ofPurchase(){
        return new TotalPrice();
    }
}
