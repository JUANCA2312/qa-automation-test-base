# 🚀 Proyecto de Automatización Web con Serenity BDD + Cucumber + Screenplay

Este proyecto implementa **automatización de pruebas funcionales** utilizando el patrón **Screenplay** de Serenity BDD junto con **Cucumber 7** y **Selenium WebDriver**.  
El objetivo es crear pruebas legibles, mantenibles y fácilmente escalables.

---

## 🧩 Tecnologías utilizadas

| Componente | Versión | Descripción |
|-------------|----------|-------------|
| **Java** | 17 | Lenguaje principal del proyecto |
| **Gradle** | 8+ | Herramienta de construcción |
| **Serenity BDD** | 4.2.16 | Framework de reportes y Screenplay |
| **Cucumber** | 7.18.1 | Framework BDD (Gherkin) |
| **Selenium WebDriver** | 4.27.0 | Control del navegador |
| **WebDriverManager** | 5.9.2 | Descarga automática de drivers |
| **JUnit** | 5.10.2 | Framework de ejecución de tests |

---

## 📁 Estructura del proyecto

```
automatizacion-prueba/
│
├── build.gradle
├── serenity.conf
├── settings.gradle
├── src/
│   ├── main/java/
│   └── test/java/
│       └── com/automatizacion/login/
│           ├── stepdefinitions/
│           ├── tasks/
│           ├── questions/
│           └── runners/
│
├── src/test/resources/
│   └── features/
│       └── login/
│           └── login.feature
│
└── .github/
    └── workflows/
        └── serenity-tests.yml
```

---

## ⚙️ Configuración del entorno local

### 1️⃣ Requisitos previos
Asegúrate de tener instalado:

- **Java 17** o superior  
- **Gradle** (opcional, puedes usar el wrapper incluido)  
- **Chrome** o **Edge** (para WebDriver)

### 2️⃣ Clonar el repositorio

```bash
git clone https://github.com/JUANCA2312/qa-automation-test-base.git
cd automatizacion-prueba
```

### 3️⃣ Ejecutar las pruebas localmente

Usando el **Gradle wrapper** incluido en el proyecto:

```bash
./gradlew clean test
```

(En Windows)
```bash
gradlew.bat clean test
```

---

## 🧠 Ejemplo de ejecución

### 🧩 Feature (Gherkin)
`src/test/resources/features/login/login.feature`

```gherkin
# language: es
Característica: Login de SauceDemo

  Escenario: Iniciar sesión correctamente
    Dado que usuario abre la página de SauceDemo
    Cuando el inicia sesión con usuario "standard_user" y contraseña "secret_sauce"
    Entonces debería ver la página de productos
```

### 🧩 Runner
`LoginTestRunner.java`

```java
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/login",
    glue = "com.automatizacion.login.stepdefinitions",
    snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class LoginTestRunner {}
```

---

## 🧾 Generación de reportes Serenity

Después de la ejecución, Serenity genera un **reporte HTML completo** en:

```
target/site/serenity/index.html
```

Para abrirlo:
- Desde el explorador de archivos:  
  `target/site/serenity/index.html`
- O por terminal:

```bash
start target/site/serenity/index.html   # Windows
open target/site/serenity/index.html    # Mac
```

---

## ☁️ Integración continua (GitHub Actions)

Este proyecto incluye un **workflow CI/CD** que se ejecuta automáticamente en GitHub cada vez que haces `push` o `pull request` a la rama `main`.

Archivo: `.github/workflows/serenity-tests.yml`

```yaml
name: Serenity BDD Tests
on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'

      - name: Cache Gradle packages
        uses: actions/cache@v4
        with:
          path: |
            ~/.gradle/caches
            ~/.gradle/wrapper
          key: ${{ runner.os }}-gradle-${{ hashFiles('**/*.gradle*', '**/gradle-wrapper.properties') }}
          restore-keys: |
            ${{ runner.os }}-gradle-

      - name: Run tests
        run: ./gradlew clean test --no-daemon

      - name: Upload Serenity Reports
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: serenity-report
          path: target/site/serenity
```

Los resultados aparecerán en la pestaña **Actions** del repositorio.

---

## 🧭 Extensiones recomendadas (VS Code)

- 📘 *Cucumber (Gherkin) Full Support*
- 🧩 *Language Support for Java*
- 🧰 *Gradle for Java*
- 🧪 *Test Explorer UI*

---

## 💬 Autor

**Juan C. Automatización QA**  
📧 [j.camilot23@gmail.com](mailto:j.camilot23@gmail.com)  
 

---

## 🏁 Licencia

Este proyecto está licenciado bajo la **MIT License**.  
Puedes usarlo, modificarlo y distribuirlo libremente con atribución.

---

## ⭐ Tips

- Cambia el driver a `"firefox"` o `"edge"` en tus `@Managed(driver="...")` si lo necesitas.  
- Puedes integrar **SonarCloud** fácilmente agregando un archivo `sonar-project.properties`.  
- Serenity te permite ejecutar los tests paralelamente o filtrar por etiquetas `@tag`.

---

> 💡 Proyecto base para frameworks de automatización escalables con **Serenity BDD** y **Cucumber 7**, ideal para proyectos empresariales o certificaciones QA.
