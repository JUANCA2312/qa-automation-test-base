Feature: Login en SauceDemo

  Scenario: Inicio de sesión exitoso
    Given que Laura abre la página de SauceDemo
    When ella inicia sesión con usuario "standard_user" y contraseña "secret_sauce"
    Then debería ver la página de productos
