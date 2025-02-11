package automation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class TutorialPonitsTests extends BaseTest {
    @Test
    public void pestanatest() {
        Logs.info("Navegando a la pagina");
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");

        Logs.debug("Obteniendo el id de la pestana actual");
        final var tabId = driver.getWindowHandle();
        Logs.debug("tab id: %s", tabId);

        Logs.info("Haciendo click en boton new tab");
        driver.findElement(By.xpath("//button[text()='New Tab']")).click();

        final var windowsHandlesSet = driver.getWindowHandles();
        Logs.debug("Window handles set: %s", windowsHandlesSet);

        Logs.debug("Nos posicionamos en la nueva pestana");
        for (var windowHandle : windowsHandlesSet) {
            //si no es el tab id original es la nueva pestana
            if (!windowHandle.equals(tabId)) {
                //nos posicionamos en la nueva pestana
                driver.switchTo().window(windowHandle);
            }
        }

        Logs.info("verificando el texto");
        Assert.assertTrue(
                driver.findElement(By.xpath("//h1[text()='New Tab']")).isDisplayed()
        );
        Logs.info("Cerrando la pestana actual");
        driver.close();

        Logs.debug("Regresando el foco a la ventana original");
        driver.switchTo().window(tabId);

        Logs.info("Verificando que se regreso a ventana original");
        Assert.assertTrue(
                driver.findElement(By.xpath("//h1[text()='Browser Windows']"))
                        .isDisplayed()
        );
    }

    @Test
    public void ventanatest() {
        Logs.info("Navegando a la pagina");
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");

        Logs.debug("Obteniendo el id de la ventana actual");
        final var windowId = driver.getWindowHandle();
        Logs.debug("tab id: %s", windowId);

        Logs.info("Haciendo click en boton new window");
        driver.findElement(By.xpath("//button[text()='New Window']")).click();

        final var windowsHandlesSet = driver.getWindowHandles();
        Logs.debug("Window handles set: %s", windowsHandlesSet);

        Logs.debug("Nos posicionamos en la nueva ventana");
        for (var windowHandle : windowsHandlesSet) {
            //si no es el tab id original es la nueva pestana
            if (!windowHandle.equals(windowId)) {
                //nos posicionamos en la nueva pestana
                driver.switchTo().window(windowHandle);
            }
        }

        Logs.info("verificando el texto");
        Assert.assertTrue(
                driver.findElement(By.xpath("//h1[text()='New Window']"))
                        .isDisplayed()
        );

        Logs.info("Cerrando la ventana actual");
        driver.close();

        Logs.debug("Regresando el foco a la ventana original");
        driver.switchTo().window(windowId);

        Logs.info("Verificando que se regreso a ventana original");
        Assert.assertTrue(
                driver.findElement(By.xpath("//h1[text()='Browser Windows']"))
                        .isDisplayed()
        );


    }

    @Test
    public void iframetest() {
        Logs.info("Navegando a la pagina");
        driver.get("https://www.tutorialspoint.com/selenium/practice/nestedframes.php");

        Logs.debug("Nos posicionamos en el iframe");
        driver.switchTo().frame("frame1"); //id

        Logs.info("Verificando el titulo del iframe");
        Assert.assertTrue(
                driver.findElement(By.xpath("//h1[text()='New Tab']"))
                        .isDisplayed()
        );

        Logs.debug("Regresando a la pagina principal");
        driver.switchTo().defaultContent();

        Logs.info("Verificando el titulo de la pagina");
        Assert.assertTrue(
                driver.findElement(By.xpath("//h1[text()='Nested Frames']")).
                        isDisplayed()
        );
    }
}
