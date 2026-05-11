package com.choucair.reto.tasks;

import com.choucair.reto.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IniciarSesion implements Task {
    private String correo;
    private String clave;

    public IniciarSesion(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public static IniciarSesion conCredenciales(String correo, String clave) {
        return Tasks.instrumented(IniciarSesion.class, correo, clave);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(LoginPage.LINK_LOGIN),
            Enter.theValue(correo).into(LoginPage.CAMPO_EMAIL),
            Enter.theValue(clave).into(LoginPage.CAMPO_PASSWORD),
            Click.on(LoginPage.BOTON_LOGUEAR)
        );
    }
}