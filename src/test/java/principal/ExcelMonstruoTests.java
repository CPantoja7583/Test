package principal;

import modelos.Monstruo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reader.ExcelReader;
import utilities.BaseTest;

import java.util.List;

public class ExcelMonstruoTests extends BaseTest {
    private List<Monstruo> listaMonstruo;

    @BeforeMethod
    public void setUp() {
        listaMonstruo = ExcelReader.obtenerListaMonstruo();

    }

    @Test
    public void primertest() {
        final var primerMounstruo = listaMonstruo.get(0);
        System.out.printf("El nombre del primero monstruo es %s%n", primerMounstruo.getNombre());
    }

    @Test
    public void segundotest() {
        final var n = listaMonstruo.size();
        System.out.printf("El tamaño de la lista monstruo es: %d%n", n);
    }

    @Test
    public void tercertest() {
        final var tercerMonstruo = listaMonstruo.get(2);
        System.out.printf("el nivel del 3er mosntruo es: %d%n", tercerMonstruo.getNivel());
    }
}
