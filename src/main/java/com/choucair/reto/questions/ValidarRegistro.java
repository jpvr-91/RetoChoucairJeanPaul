package com.choucair.reto.questions;

import com.choucair.reto.userinterfaces.RegistroPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarRegistro {
    public static Question<String> exitoso() {
        return actor -> {
            // Espera hasta 5 segundos a que el mensaje sea visible antes de leerlo
            actor.attemptsTo(WaitUntil.the(RegistroPage.MENSAJE_EXITO, isVisible()).forNoMoreThan(10).seconds());
            return Text.of(RegistroPage.MENSAJE_EXITO).answeredBy(actor);
        };
    }
}