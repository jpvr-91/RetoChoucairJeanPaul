package com.choucair.reto.questions;

import com.choucair.reto.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarCompra implements Question<String> {

    public static ValidarCompra exitosa() {
        return new ValidarCompra();
    }

    @Override
    public String answeredBy(Actor actor) {
        // Esto extrae el texto del elemento que definimos en la CheckoutPage
        return Text.of(CheckoutPage.MENSAJE_ORDEN_EXITOSA).answeredBy(actor);
    }
}