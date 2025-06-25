package automation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class NavegacionTests extends BaseTest {
    @Test
    public void primertest() {
        final var url = "https://www.saucedemo.com/";

        Logs.info("Navegando a: %s ", url);
        driver.get(url);

        Logs.info("Obteniendo la url actual");
        final var currentUrl = driver.getCurrentUrl();

        Logs.info("Verificando que las urls sean iguales");
        Assert.assertEquals(currentUrl, url);

    }

    @Test
    public void ejercicio2test() {
        final var urlHeroku = "https://the-internet.herokuapp.com/";
        final var urlGitHub = "https://github.com/";

        Logs.info("Navegando a: %s", urlHeroku);
        driver.get(urlHeroku);

        Logs.info("Navegando a: %s", urlGitHub);
        driver.get(urlGitHub);

        Logs.info("Regresando a la pagina anterior");
        driver.navigate().back();

        Logs.info("Obteniendo url actual");
        final var currentUrl = driver.getCurrentUrl();

        Logs.info("Verificando que las url sean iguales");
        Assert.assertEquals(currentUrl, urlHeroku);

    }

    @Test
    public void errortest() {

        final var urlHeroku = "https://the-internet.herokuapp.com/";

        Logs.info("navegando a :%s", urlHeroku);
        driver.get(urlHeroku);

        Logs.info("Obteniendo url actual");
        final var currentUrl = driver.getCurrentUrl();

        Logs.info("Verificando la url");
        Assert.assertEquals(currentUrl, "hola mundo jaja");
    }

    @Test
    public void inicioSesiontest() {
        final var urlOpencart = "https://opencart.abstracta.us/index.php?route=account/login";
        //final var textBox = driver.findElement(By.name("email"));
        //final var submitButton = driver.findElement(By.cssSelector("Login"));


        Logs.info("Navegando a %s", urlOpencart);
        driver.get(urlOpencart);

        Logs.info("buscando elemento email");
        driver.findElement(By.name("email"));

        Logs.info("Buscando boton Login");
        driver.findElement(By.name("Login"));

        /**Logs.info("ingresando datos a campo email");
         textBox.sendKeys("Selenium");

         Logs.info("Haciendo click en botón");
         submitButton.click(); **/


    }

    @Test
    public void threadSleeptest() {
        final var urlSaucedemo = "https://www.saucedemo.com/";

        Logs.info("navegando a :%s", urlSaucedemo);
        driver.get(urlSaucedemo);

        sleep(2000);

        Logs.info("Obteniendo url actual");
        final var currentUrl = driver.getCurrentUrl();

        Logs.info("Verificando la url");
        Assert.assertEquals(currentUrl, "hola mundo");
    }

    @Test
    public void threadSleep2test() {
        final var urlHeroku = "https://the-internet.herokuapp.com/";
        final var urlGitHub = "https://github.com/";

        Logs.info("Navegando a: %s", urlHeroku);
        driver.get(urlHeroku);

        sleep(2000);

        Logs.info("Navegando a: %s", urlGitHub);
        driver.get(urlGitHub);

        sleep(3000);

        Logs.info("Regresando a la pagina anterior");
        driver.navigate().back();

        sleep(1500);

        Logs.info("Obteniendo url actual");
        final var currentUrl = driver.getCurrentUrl();

        Logs.info("Verificando que las url sean iguales");
        Assert.assertEquals(currentUrl, urlHeroku);

    }
}
