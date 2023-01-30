package com.co.tevolv.certification.demoblaze.tasks;

import com.co.tevolv.certification.demoblaze.UI.HomePage;
import com.co.tevolv.certification.demoblaze.models.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

public class Login implements Task {

    List<Data> data;

    public Login(List<Data> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(HomePage.LOG_IN_BTN),
                Enter.theValue(data.get(0).getUsername()).into(HomePage.USERNAME_TXT),
                Enter.theValue(data.get(0).getPassword()).into(HomePage.PASSWORD_TXT),
                Click.on(HomePage.LOG_IN_BTN2)
        );
    }
    public static Login withCredentials(List<Data>data){
        return Tasks.instrumented(Login.class,data);
    }
}
