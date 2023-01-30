package com.co.tevolv.certification.demoblaze.tasks;

import com.co.tevolv.certification.demoblaze.UI.ProductStorePage;
import com.co.tevolv.certification.demoblaze.interactions.ClosePopUp;
import com.co.tevolv.certification.demoblaze.models.Data;
import com.co.tevolv.certification.demoblaze.utils.Conversions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

public class AddProducts implements Task {

    List<Data> data;

    public AddProducts(List<Data> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String vectorProducts[] = Conversions.SplitStrings(data.get(0).getNameProducts());
        String vectorCategories[] = Conversions.SplitStrings(data.get(0).getCategory());
        String productPrice = null;
        int aux = 0;
        for (int i = 0; i < vectorProducts.length; i++) {
            actor.attemptsTo(
                    WaitUntil.the(ProductStorePage.CATEGORIES_BTN.of(vectorCategories[i]), WebElementStateMatchers.isClickable())
                    , Click.on(ProductStorePage.CATEGORIES_BTN.of(vectorCategories[i]))
                    , Click.on(ProductStorePage.PRODUCTS_BTN.of(vectorProducts[i])));

            productPrice = Text.of(ProductStorePage.PRICE_PRODUCTS_LBL).viewedBy(actor).asString();
            aux += Conversions.TransformStringPrice(productPrice);
            actor.remember("totalPrice", String.valueOf(aux));
            actor.attemptsTo(Click.on(ProductStorePage.ADD_PRODUCTS_BTN), ClosePopUp.cart());
            actor.attemptsTo(Click.on(ProductStorePage.HOME_BTN));
        }
        actor.attemptsTo(Click.on(ProductStorePage.CART_BTN));
    }

    public static AddProducts toBuy(List<Data> data) {
        return Tasks.instrumented(AddProducts.class, data);
    }

}

