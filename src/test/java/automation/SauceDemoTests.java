package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class SauceDemoTests extends BaseTest {

    @Test(groups = {regression, smoke})
    public void usuarioInvalidotest() {
        rellenarFormularioLogin("standard_user", "secret");

        Logs.info("Verificando el mensaje de error");
        final var errorInicio = driver.findElement(By.cssSelector("H3[data-test='error']"));

        softAssert.assertTrue(errorInicio.isDisplayed());
        softAssert.assertEquals(errorInicio.getText(),
                "Epic sadface: Username and password do not match any user in this service");
        softAssert.assertAll();


    }

    @Test(groups = {regression, smoke})
    public void usuarioValido() {
        rellenarFormularioLogin("standard_user", "secret_sauce");

        final var inventoryList = driver.findElement(By.className("inventory_list"));

        Logs.info("Verificando que el InventoriList esté visible");
        Assert.assertTrue(inventoryList.isDisplayed());
    }

    @Test(groups = {regression, smoke})
    public void detalleProductostest() {
        rellenarFormularioLogin("standard_user", "secret_sauce");

        final var inventoryList = driver.findElement(By.className("inventory_list"));
        final var imageList =
                driver.findElements(By.cssSelector("img[class='inventory_item_img']"));


        Logs.info("Verificando que el InventoriList esté visible");
        Assert.assertTrue(inventoryList.isDisplayed());

        //sleep(3000);


        Logs.info("Haciendo click en el primer elemento de la lista");
        imageList.get(0).click();

        //Logs.info("Esperando que cargue la pagina");
        //sleep(3000);

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

    @Test(groups = {regression, smoke})
    public void select1test() {
        rellenarFormularioLogin("standard_user", "secret_sauce");

        final var selectWebElement =
                driver.findElement(By.cssSelector("select[data-test='product-sort-container']"));

        final var select = new Select(selectWebElement);

        Logs.info("seleccionamos los items de manera alfabetica Z->A");
        select.selectByValue("za");

        final var itemList = driver.findElements(By.className("inventory_item_name"));

        Logs.info("obteniendo el primer elemento");
        final var primerElemento = itemList.get(0).getText();

        Logs.info("Obteneiendo el ultimo elemento");
        final var ultimoElemento = itemList.get(itemList.size() - 1).getText();

        Logs.info("Verificando los nombres");
        softAssert.assertEquals(primerElemento, "Test.allTheThings() T-Shirt (Red)");
        softAssert.assertEquals(ultimoElemento, "Sauce Labs Backpack");
        softAssert.assertAll();

    }

    @Test(groups = {regression, smoke})
    public void select2test() {
        rellenarFormularioLogin("standard_user", "secret_sauce");

        final var selectWebElement =
                driver.findElement(By.cssSelector("select[data-test='product-sort-container']"));

        final var select = new Select(selectWebElement);

        Logs.info("Seleccionamos los item de menos a mayor precio");
        select.selectByValue("lohi");

        final var priceList = driver.findElements(By.className("inventory_item_price"));

        Logs.info("Obteniendo el primer precio");
        final var primerPrecio = Double.parseDouble(
                priceList.get(0).getText().replace("$", ""));


        Logs.info("Obteniendo el ultimo precio");
        final var ultimoPrecio = Double.parseDouble(
                priceList.get(priceList.size() - 1).getText().replace("$", ""));

        Logs.info("Verificando los precios");
        softAssert.assertEquals(primerPrecio, 7.99);
        softAssert.assertEquals(ultimoPrecio, 49.99);
        softAssert.assertAll();


    }

    @Test(groups = {regression, smoke})
    public void link1test() {
        rellenarFormularioLogin("standard_user", "secret_sauce");

        final var facebookLabel = driver.findElement(
                By.xpath("//a[text()='Facebook']"));

        Logs.info("Verificando que hipervinculo sea correcto");
        softAssert.assertTrue(facebookLabel.isDisplayed());
        softAssert.assertTrue(facebookLabel.isEnabled());
        softAssert.assertEquals(facebookLabel.getAttribute("href"),
                "https://www.facebook.com/saucelabs");
        softAssert.assertAll();
    }

    @Test(groups = {regression, smoke})
    public void link2test() {
        rellenarFormularioLogin("standard_user", "secret_sauce");

        final var linkedinLabel = driver.findElement(
                By.xpath("//a[text()='LinkedIn']"));

        Logs.info("Verificando que hipervinculo sea correcto");
        softAssert.assertTrue(linkedinLabel.isDisplayed());
        softAssert.assertTrue(linkedinLabel.isEnabled());
        softAssert.assertEquals(linkedinLabel.getAttribute("href"),
                "https://www.linkedin.com/company/sauce-labs/");
        softAssert.assertAll();

    }

    @Test(groups = {regression, smoke})
    public void link3test() {
        rellenarFormularioLogin("standard_user", "secret_sauce");

        Logs.info("Abriendo el menu burger");
        driver.findElement(By.id("react-burger-menu-btn")).click();

        Logs.info("Esperando que cargue");
        sleep(5000);

        final var aboutLink = driver.
                findElement(By.id("about_sidebar_link"));

        Logs.info("Verificando el vinculo about");
        softAssert.assertTrue(aboutLink.isDisplayed());
        softAssert.assertTrue(aboutLink.isEnabled());
        softAssert.assertEquals(aboutLink.getAttribute("href"),
                "https://saucelabs.com/");
        softAssert.assertAll();
    }

    @Test(groups = {regression, smoke})
    public void logouttest() {
        rellenarFormularioLogin("standard_user", "secret_sauce");

        Logs.info("Abriendo el menu burger");
        driver.findElement(By.id("react-burger-menu-btn")).click();

        //Logs.info("Esperando que cargue");
        //sleep(5000);

        final var logoutButton = driver.findElement(By.id("logout_sidebar_link"));

        Logs.info("Haciendo click en boton logout");
        logoutButton.click();

        //Logs.info("Esperando que llegue a pagina principal");
        //sleep(2000);

        Logs.info("Verificando un elemento de la pagina principal");
        Assert.assertTrue(driver.findElement(By.id("user-name")).isDisplayed());
    }

    private void rellenarFormularioLogin(String username, String password) {
        Logs.info("navegando a la pagina");
        driver.get("https://www.saucedemo.com/");

        //sleep(5000);

        Logs.info("Escribiendo el username");
        driver.findElement(By.id("user-name")).sendKeys(username);

        Logs.info("Escribiendo la contraseña");
        driver.findElement(By.id("password")).sendKeys(password);

        Logs.info("Haciendo click en Login");
        driver.findElement(By.id("login-button")).click();

        //sleep(5000);

    }
}
