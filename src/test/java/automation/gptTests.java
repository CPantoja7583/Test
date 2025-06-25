package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

import java.time.Duration;

public class gptTests extends BaseTest {

    private static final String URL_LOGIN = "http://kabeli.clubprovidencia.cl/login";
    private static final String USERNAME_FIELD = "username";
    private static final String PASSWORD_FIELD = "password";
    private static final String LOGIN_BUTTON_CLASS = "custom-button-style_primary__mMGYs";
    private static final int DEFAULT_WAIT_TIME = 10;

    @Test
    public void logintest() {
        // Rellenamos formulario de login
        rellenarFormularioLogin("camilo.pantoja@kabeli.cl", "Kabeli2025!");

        // Hacemos click en el botón derecho
        clickElement(By.cssSelector("svg.fa-arrow-right"), "haciendo click boton derecho");

        // Hacemos click en Gestión
        clickElement(By.xpath("//article[text()='Gestión']"), "click en gestion");

        sleep(5000);

        // Hacemos click en Contratos
        clickElement(By.xpath("//article[text()='Contratos']"), "Haciendo click en contratos");

        sleep(5000);

        // Hacemos click en crear nuevo contrato
        clickElement(By.cssSelector("button svg[data-icon='plus']"), "click hacer nuevo contrato");

        // Ingresamos rut cliente
        WebElement rutCli =
                driver.findElement(By.cssSelector("input[placeholder='Ingrese su rut']"));
        rutCli.sendKeys("13462900-2");
        Logs.info("escribiendo rut cliente");

        // Click en siguiente tres veces
        clickElement(By.xpath("//button[text()='Siguiente']"), "click Siguiente");
        clickElement(By.xpath("//button[text()='Siguiente']"), "click Siguiente");
        clickElement(By.xpath("//button[text()='Siguiente']"), "click Siguiente");

        // Hacemos click en beneficiario
        clickElement(By.cssSelector("svg[data-icon='chevron-down']"), "click en beneficiario");
    }

    private void rellenarFormularioLogin(String username, String password) {
        Logs.info("navegando a la pagina");
        driver.get(URL_LOGIN);

        // Esperamos a que el campo de email sea visible
        WebElement ingresarEmail = waitForElementVisible(By.name(USERNAME_FIELD));
        ingresarEmail.sendKeys(username);
        Logs.info("Escribiendo el username");

        // Esperamos a que el campo de password sea visible
        WebElement ingresarPass = waitForElementVisible(By.name(PASSWORD_FIELD));
        ingresarPass.sendKeys(password);
        Logs.info("Escribiendo el pass");

        // Esperamos el botón de login y hacemos click
        WebElement ingresar = waitForElementVisible(By.className(LOGIN_BUTTON_CLASS));
        ingresar.click();
        Logs.info("Presionando enter para ingresar");

        // Esperamos a que se complete el login
        waitForElementVisible(By.cssSelector("svg.fa-arrow-right"));
    }

    // Método para hacer clic en un elemento con espera
    private void clickElement(By by, String logMessage) {
        WebElement element = waitForElementClickable(by);
        Logs.info(logMessage);
        element.click();
    }

    // Método para esperar un elemento visible
    private WebElement waitForElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Método para esperar un elemento clickeable
    private WebElement waitForElementClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
