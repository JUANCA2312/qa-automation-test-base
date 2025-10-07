package com.automatizacion.login.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;

import com.automatizacion.login.tasks.AbrirLaPagina;
import com.automatizacion.login.tasks.IniciarSesion;
import com.automatizacion.login.questions.PaginaDeProductos;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class LoginStepDefinitions {

    @Managed(driver = "chrome")  // 👈 Serenity controla el navegador
    WebDriver navegador;

    private Actor usuario;

    @Before
    public void configuracionInicial() {
        OnStage.setTheStage(new OnlineCast());
        usuario = Actor.named("Usuario");
        usuario.can(BrowseTheWeb.with(navegador)); // 👈 Serenity lo vincula
    }

    @Dado("que usuario abre la página de SauceDemo")
    public void queUsuarioAbreLaPagina() {
        usuario.wasAbleTo(AbrirLaPagina.deSauceDemo());
    }

    @Cuando("el inicia sesión con usuario {string} y contraseña {string}")
    public void elIniciaSesion(String user, String password) {
        usuario.attemptsTo(IniciarSesion.conCredenciales(user, password));
    }

    @Entonces("debería ver la página de productos")
    public void deberiaVerLaPaginaDeProductos() {
        usuario.should(seeThat(PaginaDeProductos.esVisible(), is(true)));
    }
}
