package principal;

import modelos.Monstruo;
import parser.MonstruoParser;

import java.util.Arrays;

public class Ejercicio2 {
    public static void main(String[] args) {
        final var arrayMonstruo = MonstruoParser.obtenerArrayMonstruo();
        ordenarArrayMonstruo(arrayMonstruo);

        System.out.printf("El array de monstruo es: %s%n", Arrays.toString(arrayMonstruo));

    }

    private static void ordenarArrayMonstruo(Monstruo[] array) {
        final var n = array.length;

        for (var i = 0; i < n; i++) { //pasos
            for (var j = 0; j < n - i - 1; j++) { //subpasos
                //condicion desordenado
                if (array[j].getNivel() < array[j + 1].getNivel()) {
                    final var temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;

                }

            }

        }
        {

        }
    }
}
