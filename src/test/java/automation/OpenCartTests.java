package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class OpenCartTests extends BaseTest {
    @Test
    public void usuarioInvalidotest() {
        rellenarFormularioLogin("cpan9112@gmail.com", "error");

        Logs.info("verificando el mensaje de error");
        final var errorLabel = driver.findElement(By.className("alert-danger"));

        softAssert.assertTrue(errorLabel.isDisplayed());
        softAssert.assertEquals(errorLabel.getText(),
                "Warning: No match for E-Mail Address and/or Password.");
        softAssert.assertAll();


    }

    @Test
    public void usuarioValidotest() {
        rellenarFormularioLogin("cpan9112@gmail.com", "2dq7qN5H8ra@CC");

        Logs.info("Validando Login ok");
        final var loginSucces = driver.findElement
                (By.className("btn btn-inverse btn-block btn-lg dropdown-toggle"));

        softAssert.assertTrue(loginSucces.isDisplayed());

        //Logs.info("Haciendo click en Your Store");
        //driver.findElement(By.id("logo")).click();

        //Logs.info("Haciendo click en Your Store");
        //driver.findElement(By.xpath("//a[text()='Your Store']")).click();
        //"//a[text()='Your Store']"

        //sleep(5000);


        //("//img[@alt='MacBook']")

    }

    @Test
    public void eleccionProductostest() {
        rellenarFormularioLogin("cpan9112@gmail.com", "2dq7qN5H8ra@CC");

        sleep(2000);

        seleccionProductos();

        /**Logs.info("Haciendo click en Your Store");
         driver.findElement(By.xpath("//a[text()='Your Store']")).click();
         //"//a[text()='Your Store']"

         sleep(2000);

         Logs.info("Haciendo click en MAcbook");
         driver.findElement(By.xpath("//img[@alt='MacBook']")).click();

         sleep(5000);

         Logs.info("Haciendo click add to cart");
         driver.findElement(By.id("button-cart")).click();

         Logs.info("Haciendo click en Your Store");
         driver.findElement(By.xpath("//a[text()='Your Store']")).click();

         sleep(3000);

         Logs.info("Haciendo click en iPhone");
         driver.findElement(By.xpath("//img[@alt='iPhone']")).click();

         sleep(5000);

         Logs.info("Haciendo click add to cart");
         driver.findElement(By.id("button-cart")).click();

         Logs.info("Haciendo click en Your Store");
         driver.findElement(By.xpath("//a[text()='Your Store']")).click();

         sleep(5000);

         Logs.info("Haciendo click en camara");
         driver.findElement(By.xpath("//img[@alt='Canon EOS 5D']")).click();

         final var selectWebElement =
         driver.findElement(By.id("input-option226"));

         final var select = new Select(selectWebElement);

         Logs.info("seleccionando rojo ");
         select.selectByValue("15");

         Logs.info("Haciendo click add to cart");
         driver.findElement(By.id("button-cart")).click();

         sleep(3000); **/


    }

    public void rellenarFormularioLogin(String username, String password) {
        final var urlOpencart = "https://opencart.abstracta.us/index.php?route=account/login";

        Logs.info("Navegando a %s ", urlOpencart);
        driver.get(urlOpencart);

        sleep(3000);

        Logs.info("Haciendo click en opciones avanzadas");
        driver.findElement(By.id("details-button")).click();

        sleep(3000);


        Logs.info("Haciendo click en continuar en openabstract");
        driver.findElement(By.id("proceed-link")).click();

        sleep(5000);

        //cpan9112@gmail.com
        Logs.info("Escribiendo el username");
        driver.findElement(By.id("input-email")).sendKeys(username);

        //2dq7qN5H8ra@CC
        Logs.info("Escribiendo el password");
        driver.findElement(By.id("input-password")).sendKeys(password);

        Logs.info("Haciendo click en botón de login");
        driver.findElement(By.cssSelector("input[value='Login']")).click();

        sleep(2000);


    }

    public void seleccionProductos() {

        Logs.info("Haciendo click en Your Store");
        driver.findElement(By.xpath("//a[text()='Your Store']")).click();
        //"//a[text()='Your Store']"

        sleep(2000);

        Logs.info("Haciendo click en MAcbook");
        driver.findElement(By.xpath("//img[@alt='MacBook']")).click();

        sleep(5000);

        Logs.info("Haciendo click add to cart");
        driver.findElement(By.id("button-cart")).click();

        Logs.info("Haciendo click en Your Store");
        driver.findElement(By.xpath("//a[text()='Your Store']")).click();

        sleep(3000);

        Logs.info("Haciendo click en iPhone");
        driver.findElement(By.xpath("//img[@alt='iPhone']")).click();

        sleep(5000);

        Logs.info("Haciendo click add to cart");
        driver.findElement(By.id("button-cart")).click();

        Logs.info("Haciendo click en Your Store");
        driver.findElement(By.xpath("//a[text()='Your Store']")).click();

        sleep(5000);

        Logs.info("Haciendo click en camara");
        driver.findElement(By.xpath("//img[@alt='Canon EOS 5D']")).click();

        final var selectWebElement =
                driver.findElement(By.id("input-option226"));

        final var select = new Select(selectWebElement);

        Logs.info("seleccionando rojo ");
        select.selectByValue("15");

        Logs.info("Haciendo click add to cart");
        driver.findElement(By.id("button-cart")).click();

        sleep(3000);

    }
}
