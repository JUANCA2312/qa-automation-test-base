package com.automatizacion.login.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirLaPagina {
    public static Task deSauceDemo() {
        return Task.where("{0} abre la página de SauceDemo",
                Open.url("https://www.saucedemo.com/"));
    }
}
