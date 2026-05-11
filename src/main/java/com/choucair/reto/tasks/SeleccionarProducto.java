package com.choucair.reto.tasks;

import com.choucair.reto.userinterfaces.CatalogoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

public class SeleccionarProducto implements Task {

    public static SeleccionarProducto paraComprar() {
        return Tasks.instrumented(SeleccionarProducto.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(CatalogoPage.CATEGORIA_APPAREL),
            Scroll.to(CatalogoPage.PRODUCTO_BLUE_JEANS),
            Click.on(CatalogoPage.PRODUCTO_BLUE_JEANS),
            Click.on(CatalogoPage.BOTON_ADD_TO_CART),
            Click.on(CatalogoPage.LINK_SHOPPING_CART)
        );
    }
}