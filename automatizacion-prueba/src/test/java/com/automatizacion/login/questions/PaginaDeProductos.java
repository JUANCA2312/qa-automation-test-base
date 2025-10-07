package com.automatizacion.login.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaDeProductos implements Question<Boolean> {

    private static final Target TITULO = Target.the("título de productos")
            .located(By.className("title"));

    public static Question<Boolean> esVisible() {
        return new PaginaDeProductos();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return TITULO.resolveFor(actor).isVisible();
    }
}
