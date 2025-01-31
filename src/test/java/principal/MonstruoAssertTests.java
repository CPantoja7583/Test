package principal;

import modelos.Monstruo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reader.ExcelReader;
import utilities.BaseTest;

import java.util.List;

public class MonstruoAssertTests extends BaseTest {
    private List<Monstruo> listaMonstruo;

    @BeforeMethod
    public void setUp() {
        listaMonstruo = ExcelReader.obtenerListaMonstruo();

    }

    @Test
    public void primertest() {
        final var primerMounstruo = listaMonstruo.get(0);
        //System.out.printf("El nombre del primero monstruo es %s%n", primerMounstruo.getNombre());
        Assert.assertEquals(primerMounstruo.getNombre(), "TOLOSA",
                "1ER NOMBRE NO HACE MATCH");
    }

    @Test
    public void segundotest() {
        final var n = listaMonstruo.size();
        //System.out.printf("El tamaño de la lista monstruo es: %d%n", n);
        Assert.assertEquals(n, 14, "longuitud incorrecta");
    }

    @Test
    public void tercertest() {
        final var tercerMonstruo = listaMonstruo.get(2);
        //System.out.printf("el nivel del 3er mosntruo es: %d%n", tercerMonstruo.getNivel());
        Assert.assertEquals(tercerMonstruo.getNivel(), 22,
                "3er nivel no hace match");
    }
}
