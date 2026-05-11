package com.choucair.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {

        // --- SECCIÓN CARRITO ---
        public static final Target CHECKBOX_TERMINOS = Target.the("Aceptar términos y condiciones")
                        .located(By.id("termsofservice"));

        public static final Target BOTON_CHECKOUT = Target.the("Botón Checkout")
                        .located(By.id("checkout"));

        // --- PASO 1: BILLING ADDRESS (Nuevos campos para usuario nuevo) ---
        public static final Target SELECT_PAIS = Target.the("Seleccionar país")
                        .located(By.id("BillingNewAddress_CountryId"));

        public static final Target CAMPO_CIUDAD = Target.the("Campo ciudad")
                        .located(By.id("BillingNewAddress_City"));

        public static final Target CAMPO_DIRECCION = Target.the("Campo dirección")
                        .located(By.id("BillingNewAddress_Address1"));

        public static final Target CAMPO_ZIP_CODE = Target.the("Campo código postal")
                        .located(By.id("BillingNewAddress_ZipPostalCode"));

        public static final Target CAMPO_TELEFONO = Target.the("Campo teléfono")
                        .located(By.id("BillingNewAddress_PhoneNumber"));

        public static final Target BOTON_CONTINUE_BILLING = Target.the("Botón continuar Facturación")
                        .located(By.xpath("//div[@id='billing-buttons-container']//input[@title='Continue']"));

        // --- PASO 2: SHIPPING ADDRESS ---
        public static final Target BOTON_CONTINUE_SHIPPING = Target.the("Botón continuar Envío")
                        .located(By.xpath("//div[@id='shipping-buttons-container']//input[@title='Continue']"));

        // --- PASO 3: SHIPPING METHOD ---
        public static final Target BOTON_CONTINUE_SHIPPING_METHOD = Target.the("Botón continuar Método de Envío")
                        .located(By.xpath("//div[@id='shipping-method-buttons-container']//input[@value='Continue']"));

        // --- PASO 4: PAYMENT METHOD ---
        public static final Target RADIO_CREDIT_CARD = Target.the("Seleccionar Tarjeta de Crédito")
                        .located(By.id("paymentmethod_2"));

        public static final Target BOTON_CONTINUE_PAYMENT_METHOD = Target.the("Botón continuar Método de Pago")
                        .located(By.xpath("//div[@id='payment-method-buttons-container']//input[@value='Continue']"));

        // --- PASO 5: PAYMENT INFO (Datos de la Tarjeta) ---
        public static final Target SELECT_CARD_TYPE = Target.the("Tipo de tarjeta")
                        .located(By.id("CreditCardType"));

        public static final Target CAMPO_CARDHOLDER_NAME = Target.the("Nombre del titular")
                        .located(By.id("CardholderName"));

        public static final Target CAMPO_CARD_NUMBER = Target.the("Número de tarjeta")
                        .located(By.id("CardNumber"));

        public static final Target SELECT_EXPIRATION_MONTH = Target.the("Mes de expiración")
                        .located(By.id("ExpireMonth"));

        public static final Target SELECT_EXPIRATION_YEAR = Target.the("Año de expiración")
                        .located(By.id("ExpireYear"));

        public static final Target CAMPO_CARD_CODE = Target.the("Código de seguridad")
                        .located(By.id("CardCode"));

        public static final Target BOTON_CONTINUE_PAYMENT_INFO = Target.the("Botón continuar Info Pago")
                        .located(By.xpath("//div[@id='payment-info-buttons-container']//input[@value='Continue']"));

        // --- PASO 6: CONFIRM ORDER ---
        public static final Target BOTON_CONFIRM_ORDER = Target.the("Botón Confirmar Orden")
                        .located(By.xpath("//div[@id='confirm-order-buttons-container']//input[@value='Confirm']"));

        public static final Target MENSAJE_ORDEN_EXITOSA = Target.the("Mensaje de orden exitosa")
                        .located(By.xpath("//div[@class='title']/strong"));
}