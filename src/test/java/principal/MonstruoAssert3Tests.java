package principal;

import modelos.Monstruo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reader.ExcelReader;
import utilities.BaseTest;

import java.util.List;

public class MonstruoAssert3Tests extends BaseTest {
    private List<Monstruo> listaMonstruo;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        listaMonstruo = ExcelReader.obtenerListaMonstruo();

    }

    @Test
    public void primertest() {
        final var primerMounstruo = listaMonstruo.get(0);
        Assert.assertEquals(primerMounstruo.getNombre(), "TOLOSA",
                "1ER NOMBRE NO HACE MATCH");
    }

    @Test
    public void segundotest() {
        final var n = listaMonstruo.size();
        Assert.assertEquals(n, 14, "longuitud incorrecta");
    }

    @Test
    public void tercertest() {
        final var tercerMonstruo = listaMonstruo.get(2);
        Assert.assertEquals(tercerMonstruo.getNivel(), 22,
                "3er nivel no hace match");
    }

    @Test
    public void cuartotest() {
        final var ultimoMounstruo = listaMonstruo.get(listaMonstruo.size() - 1);

        softAssert.assertEquals(ultimoMounstruo.getNombre(), "LUCENA");
        softAssert.assertEquals(ultimoMounstruo.getEdad(), 3);
        softAssert.assertEquals(ultimoMounstruo.getPeso(), 8.57);
        softAssert.assertEquals(ultimoMounstruo.getGenero(), "MACHO");
        softAssert.assertEquals(ultimoMounstruo.getTipo(), "PLANTA");
        softAssert.assertEquals(ultimoMounstruo.getNivel(), 36);

        softAssert.assertAll();

    }
}
