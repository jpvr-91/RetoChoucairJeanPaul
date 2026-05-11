package com.choucair.reto.tasks;

import com.choucair.reto.userinterfaces.RegistroPage;
import com.choucair.reto.utils.DatosPrueba;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import java.util.Random;

public class RegistroUsuario implements Task {

    public static RegistroUsuario enLaPagina() {
        return Tasks.instrumented(RegistroUsuario.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Generamos el número y el correo
        int numeroAleatorio = new Random().nextInt(10000);
        String correoUnico = "jeanpaul_reto" + numeroAleatorio + "@test.com";
        
        // GUARDAMOS en la variable estática para que CompraStepDefinitions la vea
        DatosPrueba.correoAleatorio = correoUnico;

        actor.attemptsTo(
            Click.on(RegistroPage.RADIO_GENERO),
            Enter.theValue("Jean Paul").into(RegistroPage.CAMPO_NOMBRE),
            Enter.theValue("Reto").into(RegistroPage.CAMPO_APELLIDO),
            Enter.theValue(correoUnico).into(RegistroPage.CAMPO_EMAIL),
            Enter.theValue("Password123*").into(RegistroPage.CAMPO_PASSWORD),
            Enter.theValue("Password123*").into(RegistroPage.CAMPO_CONFIRMAR_PASSWORD),
            Click.on(RegistroPage.BOTON_REGISTRAR)
        );
    }
}