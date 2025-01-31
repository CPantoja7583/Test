package parser;

import modelos.Monstruo;
import reader.ExcelReader;

public class MonstruoParser {
    public static Monstruo[] obtenerArrayMonstruo() {
        final var listraMonstruo = ExcelReader.obtenerListaMonstruo();
        final var n = listraMonstruo.size();

        final var arrayMonstruo = new Monstruo[n];

        for (var i = 0; i < n; i++) {
            arrayMonstruo[i] = listraMonstruo.get(i);

        }

        return arrayMonstruo;

    }
}
