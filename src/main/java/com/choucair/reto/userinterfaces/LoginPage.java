package com.choucair.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target LINK_LOGIN = Target.the("enlace para ir al login")
            .located(By.linkText("Log in"));

    public static final Target CAMPO_EMAIL = Target.the("campo de correo electrónico")
            .located(By.id("Email"));

    public static final Target CAMPO_PASSWORD = Target.the("campo de contraseña")
            .located(By.id("Password"));

    public static final Target BOTON_LOGUEAR = Target.the("botón para iniciar sesión")
            .located(By.xpath("//input[@value='Log in']"));
}