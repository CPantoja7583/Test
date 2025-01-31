package reader;

import com.poiji.bind.Poiji;
import modelos.Monstruo;
import modelos.Producto;
import modelos.VideoJuego;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private final static String excelPath = "src/main/resources/Data/dataExcel (1).xlsx";

    public static List<VideoJuego> obtenerListaVideoJuego() {
        return Poiji.fromExcel(new File(excelPath), VideoJuego.class);

    }

    public static List<Monstruo> obtenerListaMonstruo() {
        return Poiji.fromExcel(new File(excelPath), Monstruo.class);

    }

    public static List<Producto> obtenerListaProducto() {
        return Poiji.fromExcel(new File(excelPath), Producto.class);

    }

}
