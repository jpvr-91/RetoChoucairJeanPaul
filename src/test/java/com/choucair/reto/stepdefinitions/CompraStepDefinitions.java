package com.choucair.reto.stepdefinitions;

import com.choucair.reto.tasks.IniciarSesion;
import com.choucair.reto.tasks.SeleccionarProducto;
import com.choucair.reto.tasks.RealizarCheckout;
import com.choucair.reto.questions.ValidarCompra;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class CompraStepDefinitions {

    @Before
    public void setStage() {
        // Esto es vital para que el actor "despierte" en cada escenario
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario inicia sesión con sus credenciales")
public void queElUsuarioIniciaSesionConSusCredenciales() {
    theActorCalled("Jean Paul").wasAbleTo(
            Open.url("https://demowebshop.tricentis.com/login")
    );

    // RECUPERAMOS el correo de la variable estática
    String emailParaLogin = com.choucair.reto.utils.DatosPrueba.correoAleatorio;

    theActorInTheSpotlight().attemptsTo(
            IniciarSesion.conCredenciales(emailParaLogin, "Password123*")
    );
}
    @Cuando("selecciona un producto de una categoría y lo agrega al carrito")
    public void seleccionaUnProductoDeUnaCategoriaYLoAgregaAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarProducto.paraComprar()
        );
    }

    @Cuando("completa el proceso de checkout con tarjeta Visa")
    public void completaElProcesoDeCheckoutConTarjetaVisa() {
        theActorInTheSpotlight().attemptsTo(
                RealizarCheckout.conDatosVisa()
        );
    }

    @Entonces("debería ver el mensaje {string}")
    public void deberiaVerElMensaje(String mensaje) {
        theActorInTheSpotlight().should(
                seeThat("El mensaje de confirmación de orden",
                        ValidarCompra.exitosa(), equalTo(mensaje))
        );
    }
}