package com.choucair.reto.tasks;

import com.choucair.reto.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizarCheckout implements Task {

    public static RealizarCheckout conDatosVisa() {
        return Tasks.instrumented(RealizarCheckout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // 0. Proceso inicial en el carrito
                Click.on(CheckoutPage.CHECKBOX_TERMINOS),
                Click.on(CheckoutPage.BOTON_CHECKOUT),

                // 1. Paso 1: Billing Address (Llenar campos obligatorios para usuario nuevo)
                WaitUntil.the(CheckoutPage.SELECT_PAIS, isVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText("Colombia").from(CheckoutPage.SELECT_PAIS),
                Enter.theValue("Bogotá").into(CheckoutPage.CAMPO_CIUDAD),
                Enter.theValue("Calle 100 # 15-20").into(CheckoutPage.CAMPO_DIRECCION),
                Enter.theValue("110111").into(CheckoutPage.CAMPO_ZIP_CODE),
                Enter.theValue("3001234567").into(CheckoutPage.CAMPO_TELEFONO),
                
                Click.on(CheckoutPage.BOTON_CONTINUE_BILLING),

                // 2. Paso 2: Shipping Address
                WaitUntil.the(CheckoutPage.BOTON_CONTINUE_SHIPPING, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.BOTON_CONTINUE_SHIPPING),

                // 3. Paso 3: Shipping Method
                WaitUntil.the(CheckoutPage.BOTON_CONTINUE_SHIPPING_METHOD, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.BOTON_CONTINUE_SHIPPING_METHOD),

                // 4. Paso 4: Payment Method (Seleccionar Tarjeta de Crédito)
                WaitUntil.the(CheckoutPage.RADIO_CREDIT_CARD, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.RADIO_CREDIT_CARD),
                Click.on(CheckoutPage.BOTON_CONTINUE_PAYMENT_METHOD),

                // 5. Paso 5: Payment Information (Datos de Barbara Gordon)
                WaitUntil.the(CheckoutPage.SELECT_CARD_TYPE, isVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText("Visa").from(CheckoutPage.SELECT_CARD_TYPE),
                Enter.theValue("Barbara Gordon").into(CheckoutPage.CAMPO_CARDHOLDER_NAME),
                Enter.theValue("4485564059489345").into(CheckoutPage.CAMPO_CARD_NUMBER),
                SelectFromOptions.byVisibleText("04").from(CheckoutPage.SELECT_EXPIRATION_MONTH),
                SelectFromOptions.byVisibleText("2039").from(CheckoutPage.SELECT_EXPIRATION_YEAR),
                Enter.theValue("123").into(CheckoutPage.CAMPO_CARD_CODE),
                Click.on(CheckoutPage.BOTON_CONTINUE_PAYMENT_INFO),

                // 6. Paso 6: Confirm Order
                WaitUntil.the(CheckoutPage.BOTON_CONFIRM_ORDER, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.BOTON_CONFIRM_ORDER)
        );
    }
}