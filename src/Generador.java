import java.util.Random;

public class Generador {

    public static int[] generate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El tamaño n no puede ser negativo: " + n);
        }
        int[] datos = new int[n];
        Random random = new Random();
        long limiteSuperior = (long) n + 1; 
        for (int i = 0; i < n; i++) {
            datos[i] = (int) random.nextLong(limiteSuperior);
        }
        return datos;
    }
}