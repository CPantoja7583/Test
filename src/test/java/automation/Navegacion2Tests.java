package automation;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class Navegacion2Tests extends BaseTest {
    @Test(groups = {regression})
    public void fallatest() {

        final var urlHeroku = "https://the-internet.herokuapp.com/";

        Logs.info("navegando a :%s", urlHeroku);
        driver.get(urlHeroku);

        Logs.info("Obteniendo url actual");
        final var currentUrl = driver.getCurrentUrl();

        Logs.info("Verificando la url");
        Assert.assertEquals(currentUrl, "hola mundo");
    }

    @Test(groups = {regression})
    public void tecnovatest() {

        final var urlOpencart = "https://opencart.abstracta.us/index.php?route=account/login";

        Logs.info("Navegando a : %s", urlOpencart);
        driver.get(urlOpencart);

        Logs.info("Obteniendo url actual");
        final var currentUrl = driver.getCurrentUrl();

        Logs.info("verificando la url");
        Assert.assertEquals(currentUrl, "tecnova");
    }


}
