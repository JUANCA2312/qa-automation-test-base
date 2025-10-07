# language: es
Característica: Login de SauceDemo

  Escenario: Iniciar sesión correctamente
    Dado que usuario abre la página de SauceDemo
    Cuando el inicia sesión con usuario "standard_user" y contraseña "secret_sauce"
    Entonces debería ver la página de productos
