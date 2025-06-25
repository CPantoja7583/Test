package automation;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class DemoQATests extends BaseTest {
    @Test
    public void keyboard1test() {
        Logs.info("Navegando a la pagina");
        driver.get("https://demoqa.com/text-box");

        final var faker = new Faker();
        final var fullName = faker.name().fullName();
        Logs.debug("fullname %s:", fullName);

        final var usernameInput = driver.findElement(By.id("userName"));
        Logs.info("Haciendo click para dar focus");
        usernameInput.click();

        Logs.info("Presionando Shift y escribiendo en mayuscula");
        new Actions(driver)
                .keyDown(Keys.SHIFT) //presionando shift
                .sendKeys(fullName) //escribiendo
                .keyUp(Keys.SHIFT) //dejo presionado shift
                .perform();

        Logs.info("Veriificando que el input este en mayus");
        Assert.assertEquals(
                usernameInput.getAttribute("value"),
                fullName.toUpperCase()
        );
    }

    @Test
    public void keyboard2test() {
        Logs.info("Navegando a la pagina");
        driver.get("https://demoqa.com/text-box");

        final var faker = new Faker();
        final var addres = faker.address().fullAddress();
        Logs.debug("Addres: %s", addres);

        final var currentAddresInput = driver.findElement(By.id("currentAddress"));

        Logs.info("Esccribiendo una direccion y dando focus");
        currentAddresInput.sendKeys(addres);

        sleep(3000);
        
        currentAddresInput.click();

        Logs.info("Seleccionando y copiando el contenido");
        new Actions(driver)
                .keyDown(Keys.COMMAND) //presionando command
                .sendKeys("a") //CMD + A seleccionando el contenido
                .sendKeys("c") //CMD + C copiando el contenido
                .keyUp(Keys.COMMAND) //suelto el command
                .perform(); //realizo las acciones

        final var permanentAddresInput = driver.findElement(By.id("permanentAddress"));

        Logs.info("Haciendo focus en permanentAddres");
        permanentAddresInput.click();

        Logs.info("Pegando el contenido");
        new Actions(driver)
                .keyDown(Keys.COMMAND) //presionando command
                .sendKeys("v") //CMD + V
                .keyUp(Keys.COMMAND) //suelto commando
                .perform(); //realizo las acciones

        Logs.info("Verificando que ambos textos sean iguales");
        Assert.assertEquals(
                currentAddresInput.getAttribute("value"),
                permanentAddresInput.getAttribute("value")

        );
    }
}
