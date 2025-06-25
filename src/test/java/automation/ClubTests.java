package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

import java.io.File;

public class ClubTests extends BaseTest {

    @Test
    public void logintest() {
        rellenarFormularioLogin("camilo.pantoja@kabeli.cl", "Kabeli2025!");

        final var botonDerecho = driver.findElement(By.cssSelector("svg.fa-arrow-right"));

        Logs.info("haciendo click boton derecho");
        botonDerecho.click();


        final var gestion =
                driver.findElement(By.xpath("//article[text()='Gestión']"));

        Logs.info("click en gestion");
        gestion.click();

        sleep(5000);

        //crear contrato
        final var contrato =
                driver.findElement(By.xpath("//article[text()='Contratos']"));

        Logs.info("Haciendo click en contratos");
        contrato.click();

        sleep(5000);


        final var crearContrato =
                driver.findElement(By.cssSelector("button svg[data-icon='plus']"));


        Logs.info("click hacer nuevo contrato");
        crearContrato.click();

        sleep(5000);

        final var rutCli =
                driver.findElement(By.cssSelector("input[placeholder='Ingrese su rut']"));

        Logs.info("click ingresar rut");
        rutCli.click();

        Logs.info("escribiendo rut cliente");
        rutCli.sendKeys("13462900-2");

        sleep(5000);

        final var siguiente =
                driver.findElement(By.xpath("//button[text()='Siguiente']"));

        Logs.info("click Siguiente");
        siguiente.click();

        sleep(5000);

        Logs.info("click Siguiente");
        siguiente.click();

        sleep(5000);

        Logs.info("click Siguiente");
        siguiente.click();

        final var clickBeneficiario =
                driver.findElement(By.cssSelector("svg[data-icon='chevron-down']"));

        Logs.info("click en beneficiario");
        clickBeneficiario.click();

        sleep(100);

        final var adjunto = new File("src/test/resources/samples/ch16.jpg");
        final var adjuntoDos = new File("src/test/resources/samples/ch23.jpg");
        driver.findElement(By.id("identityCard-371")).sendKeys(adjunto.getAbsolutePath());
        driver.findElement(By.id("identityCard-371")).sendKeys(adjuntoDos.getAbsolutePath());


        Logs.info("click Siguiente");
        siguiente.click();

        sleep(1000);

        final var usuarioUno =
                driver.findElement(By.cssSelector("svg.fa-chevron-down"));
        //By locator1 = By.xpath("//svg[@data-icon='chevron-down']");

        //click en usuario
        Logs.info("click siguiente");
        usuarioUno.click();

        final var actividad =
                driver.findElement(By.xpath("//option[@value='103']"));

        Logs.info("escogiendo actividad");
        actividad.click();

        sleep(50000);

        final var horarioEscoger =
                driver.findElement(By.cssSelector("span svg.fa-circle"));

        Logs.info("Haciendo clic en horario");
        horarioEscoger.click();

        Logs.info("click Siguiente");
        siguiente.click();

        final var pagoMensual =
                driver.findElement(By.xpath("//input[@id='2' and @type='radio']"));

        Logs.info("clickeando pago pensual");
        pagoMensual.click();

        Logs.info("click Siguiente");
        siguiente.click();

        // Localizar el elemento <select> por su nombre
        Logs.info("Localizar elemento select por su nombre");
        WebElement selectElement = driver.findElement(By.name("paymentType"));

        // Crear un objeto Select para interactuar con el <select>

        Select select = new Select(selectElement);

        // Seleccionar la opción con el ID "2" (Credito)
        WebElement optionCredito = driver.findElement(By.id("2"));
        optionCredito.click();


        final var montoPago =
                driver.findElement(By.xpath("//section//input[@placeholder='$0']"));

        Logs.info("Escribiendo monto a pagar");
        montoPago.sendKeys("33000");

        final var codigoAutorizacion =
                driver.findElement(By.cssSelector("section input[placeholder='Código']"));

        Logs.info("Escribiendo codigo de autorización");
        codigoAutorizacion.sendKeys("777");

        Logs.info("click Siguiente");
        siguiente.click();

        sleep(10000);

        WebElement checkbox =
                driver.findElement(By.cssSelector("span input[type='checkbox']"));

        // Hacer clic en el checkbox si no está seleccionado
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        WebElement firmarContrato =
                driver.findElement(By.cssSelector("button.custom-button-style_primary__mMGYs"));


        // Hacer clic en el botón
        firmarContrato.click();

        sleep(1000);

        // Localizar el lienzo de firma utilizando la clase
        WebElement lienzoFirma = driver.findElement(By.className("SignaturePad_canvas__PZhqD"));

        // Crear una instancia de Actions para simular los movimientos del mouse
        Actions actions = new Actions(driver);

        // Empezar a dibujar en el lienzo
        // Ajusta las coordenadas (50, 50) según sea necesario
        actions.moveToElement(lienzoFirma, 50, 50) // Mueve al punto (50,50) sobre el lienzo
                .clickAndHold() // Hace clic y mantiene presionado el ratón
                .moveByOffset(100, 0) // Desplázate 100 px hacia la derecha
                .moveByOffset(0, 100) // Mueve 100 px hacia abajo
                .moveByOffset(-100, 0) // Regresa 100 px hacia la izquierda
                .moveByOffset(0, -100) // Sube 100 px
                .release() // Suelta el clic del ratón
                .build().perform(); // Realiza la acción

        // Espera (por ejemplo, 5 segundos) para ver el resultado
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement button =
                driver.findElement(By.xpath("//button[text()='Guardar']"));

        Logs.info("click guardar");
        button.click();

        sleep(5000);

    }


    private void rellenarFormularioLogin(String username, String password) {
        Logs.info("navegando a la pagina");
        driver.get("http://kabeli.clubprovidencia.cl/login");

        final var ingresarEmail = driver.findElement(By.name("username"));

        Logs.info("Escribiendo el username");
        ingresarEmail.sendKeys(username);

        final var ingresarPass = driver.findElement(By.name("password"));

        Logs.info("Escribiendo el pass");
        ingresarPass.sendKeys(password);

        final var ingresar =
                driver.findElement(By.className("custom-button-style_primary__mMGYs"));


        Logs.info("Presionando enter para ingresar");
        ingresar.click();

        sleep(2000);


    }
}
