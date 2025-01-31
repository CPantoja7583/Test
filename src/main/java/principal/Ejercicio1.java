package principal;

import modelos.VideoJuego;
import reader.ExcelReader;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {
        final var listaTotal = ExcelReader.obtenerListaVideoJuego();
        final var listaMayores50 = filtrarDuracion50(listaTotal);

        System.out.printf("La lista es: %s%n", listaMayores50);

    }

    private static List<VideoJuego> filtrarDuracion50(List<VideoJuego> listaTotalVideojuego) {
        final var listaMayores50 = new ArrayList<VideoJuego>();

        for (var videojuego : listaTotalVideojuego) {
            if (videojuego.getDuracion() > 50) {
                listaMayores50.add(videojuego);
            }

        }
        return listaMayores50;
    }
}
