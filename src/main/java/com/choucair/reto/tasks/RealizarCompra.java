package com.choucair.reto.tasks;

import com.choucair.reto.userinterfaces.CatalogoPage;
import com.choucair.reto.userinterfaces.CheckoutPage;
import com.choucair.reto.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizarCompra implements Task {

    public static RealizarCompra deUnProducto() {
        return Tasks.instrumented(RealizarCompra.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            // 1. Login (Punto 3 del reto)
            Click.on(LoginPage.LINK_LOGIN),
            Enter.theValue("jean_paul_test@test.com").into(LoginPage.CAMPO_EMAIL),
            Enter.theValue("Password123*").into(LoginPage.CAMPO_PASSWORD),
            Click.on(LoginPage.BOTON_LOGUEAR),

            // 2. Selección de Categoría y Producto (Punto 4 y 5 del reto)
            Click.on(CatalogoPage.CATEGORIA_APPAREL),
            Click.on(CatalogoPage.PRODUCTO_BLUE_JEANS),
            Click.on(CatalogoPage.BOTON_ADD_TO_CART),

            // 3. Carrito y Checkout (Punto 6 del reto)
            Click.on(CatalogoPage.LINK_SHOPPING_CART),
            Click.on(CheckoutPage.CHECKBOX_TERMINOS),
            Click.on(CheckoutPage.BOTON_CHECKOUT),

            // 4. Proceso de Pago (Billing, Shipping, Method)
            WaitUntil.the(CheckoutPage.BOTON_CONTINUE_BILLING, isVisible()).forNoMoreThan(10).seconds(),
            Click.on(CheckoutPage.BOTON_CONTINUE_BILLING),
            
            WaitUntil.the(CheckoutPage.BOTON_CONTINUE_SHIPPING, isVisible()).forNoMoreThan(5).seconds(),
            Click.on(CheckoutPage.BOTON_CONTINUE_SHIPPING),
            
            WaitUntil.the(CheckoutPage.BOTON_CONTINUE_SHIPPING_METHOD, isVisible()).forNoMoreThan(5).seconds(),
            Click.on(CheckoutPage.BOTON_CONTINUE_SHIPPING_METHOD),

            // 5. Seleccionar Tarjeta de Crédito (Punto 8 del reto)
            Click.on(CheckoutPage.RADIO_CREDIT_CARD),
            Click.on(CheckoutPage.BOTON_CONTINUE_PAYMENT_METHOD),

            // 6. Datos de Barbara Gordon (Punto 9 del reto)
            WaitUntil.the(CheckoutPage.SELECT_CARD_TYPE, isVisible()).forNoMoreThan(5).seconds(),
            SelectFromOptions.byVisibleText("Visa").from(CheckoutPage.SELECT_CARD_TYPE),
            Enter.theValue("Barbara Gordon").into(CheckoutPage.CAMPO_CARDHOLDER_NAME),
            Enter.theValue("4485564059489345").into(CheckoutPage.CAMPO_CARD_NUMBER),
            SelectFromOptions.byVisibleText("04").from(CheckoutPage.SELECT_EXPIRATION_MONTH),
            SelectFromOptions.byVisibleText("2039").from(CheckoutPage.SELECT_EXPIRATION_YEAR),
            Enter.theValue("123").into(CheckoutPage.CAMPO_CARD_CODE),
            Click.on(CheckoutPage.BOTON_CONTINUE_PAYMENT_INFO),

            // 7. Confirmación Final (Punto 10 del reto)
            WaitUntil.the(CheckoutPage.BOTON_CONFIRM_ORDER, isVisible()).forNoMoreThan(5).seconds(),
            Click.on(CheckoutPage.BOTON_CONFIRM_ORDER)
        );
    }
}