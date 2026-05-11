package com.choucair.reto.stepdefinitions;

import io.cucumber.java.Before;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import com.choucair.reto.questions.ValidarRegistro;
import com.choucair.reto.tasks.RegistroUsuario;

public class RegistroStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario navega a la página de registro")
    public void queElUsuarioNavegaALaPaginaDeRegistro() {
        theActorCalled("Juan").wasAbleTo(Open.url("https://demowebshop.tricentis.com/register"));
    }

    @Cuando("ingresa los datos requeridos")
    public void ingresaLosDatosRequeridos() {
        theActorCalled("Juan").attemptsTo(RegistroUsuario.enLaPagina());
    }

    @Entonces("el usuario debería ver el mensaje de bienvenida")
    public void elUsuarioDeberiaVerElMensajeDeBienvenida() {
        // Al escribir esto, los imports amarillos se pondrán de color normal
        OnStage.theActorInTheSpotlight().should(
                seeThat("El mensaje de éxito", ValidarRegistro.exitoso(), equalTo("Your registration completed")));
    }
}
