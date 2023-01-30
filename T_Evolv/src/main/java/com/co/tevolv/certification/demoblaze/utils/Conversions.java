package com.co.tevolv.certification.demoblaze.utils;

import com.co.tevolv.certification.demoblaze.UI.PlaceOrderComponent;
import com.co.tevolv.certification.demoblaze.models.Data;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

public class Conversions {

    public static final String [] SplitStrings(String data){
        return data.split(",");
    }

    public static final int TransformStringPrice(String productPrice){
       return Integer.parseInt(productPrice.replace("$","").replace(" *includes tax",""));
    }

    public static final String TransformStringTotalPriceQuestion(String aux){
        String aux2[]=aux.split(" USD");
        String aux3[]=aux2[0].split("unt: ");
        String aux4=aux3[1];
        return aux4;
    }
}
