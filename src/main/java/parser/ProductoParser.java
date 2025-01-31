package parser;

import modelos.Producto;
import reader.ExcelReader;

import java.util.HashMap;
import java.util.Map;

public class ProductoParser {
    public static Map<String, Producto> getMapProducto() {
        final var listaProducto = ExcelReader.obtenerListaProducto();

        final var mapProducto = new HashMap<String, Producto>();

        for (var producto : listaProducto) {
            mapProducto.put(producto.getNombre(), producto);
        }


        return mapProducto;
    }
}
