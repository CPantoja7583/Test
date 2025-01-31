package automation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class SauceDemoTests extends BaseTest {

    @Test
    public void usuarioInvalidotest() {
        rellenarFormularioLogin("standard_user", "secret_sae");

        Logs.info("Verificando el mensaje de error");
        final var errorInicio = driver.findElement(By.cssSelector("H3[data-test='error']"));

        softAssert.assertTrue(errorInicio.isDisplayed());
        softAssert.assertEquals(errorInicio.getText(),
                "Epic sadface: Username and password do not match any user in this service");
        softAssert.assertAll();


    }

    @Test
    public void usuarioValido() {
        rellenarFormularioLogin("standard_user", "secret_sauce");

        final var inventoryList = driver.findElement(By.className("inventory_list"));

        Logs.info("Verificando que el InventoriList esté visible");
        Assert.assertTrue(inventoryList.isDisplayed());
    }

    @Test
    public void detalleProductostest() {
        rellenarFormularioLogin("standard_user", "secret_sauce");

        final var inventoryList = driver.findElement(By.className("inventory_list"));
        final var imageList =
                driver.findElements(By.cssSelector("img[class='inventory_item_img']"));


        Logs.info("Verificando que el InventoriList esté visible");
        Assert.assertTrue(inventoryList.isDisplayed());

        sleep(3000);


        Logs.info("Haciendo click en el primer elemento de la lista");
        imageList.get(0).click();

        Logs.info("Esperando que cargue la pagina");
        sleep(3000);

        Logs.info("Verificando el detalle del producto");
        softAssert.assertTrue(
                driver.findElement(By.className("inventory_details_name")).isDisplayed());
        softAssert.assertTrue(
                driver.findElement(By.className("inventory_details_desc")).isDisplayed());
        softAssert.assertTrue(
                driver.findElement(By.className("inventory_details_price")).isDisplayed());
        softAssert.assertTrue(
                driver.findElement(By.xpath("//button[text()='Add to cart']")).isDisplayed());
        softAssert.assertTrue(
                driver.findElement(By.className("inventory_details_img")).isDisplayed());


        softAssert.assertAll();
    }

    private void rellenarFormularioLogin(String username, String password) {
        Logs.info("navegando a la pagina");
        driver.get("https://www.saucedemo.com/");

        sleep(5000);

        Logs.info("Escribiendo el username");
        driver.findElement(By.id("user-name")).sendKeys(username);

        Logs.info("Escribiendo la contraseña");
        driver.findElement(By.id("password")).sendKeys(password);

        Logs.info("Haciendo click en Login");
        driver.findElement(By.id("login-button")).click();

        sleep(5000);

    }
}
