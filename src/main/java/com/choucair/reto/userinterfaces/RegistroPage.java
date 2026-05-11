package com.choucair.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistroPage {

    public static final Target ENLACE_REGISTRO = Target.the("enlace para ir al registro")
            .located(By.className("ico-register"));

    public static final Target RADIO_GENERO = Target.the("seleccionar genero")
            .located(By.id("gender-male"));

    public static final Target CAMPO_NOMBRE = Target.the("campo para el nombre")
            .located(By.id("FirstName"));

    public static final Target CAMPO_APELLIDO = Target.the("campo para el apellido")
            .located(By.id("LastName"));

    public static final Target CAMPO_EMAIL = Target.the("campo para el correo")
            .located(By.id("Email"));

    public static final Target CAMPO_PASSWORD = Target.the("campo para la contrasena")
            .located(By.id("Password"));

    public static final Target CAMPO_CONFIRMAR_PASSWORD = Target.the("campo para confirmar contrasena")
            .located(By.id("ConfirmPassword"));

    public static final Target BOTON_REGISTRAR = Target.the("boton para finalizar registro")
            .located(By.id("register-button"));
    public static final Target MENSAJE_EXITO = Target.the("mensaje de registro completado")
        .located(By.className("result"));     
}
