import java.util.Arrays;
import java.util.Comparator;

public class PruebasAceptacion {

    public static void main(String[] args) {
        Metodos m = new Metodos();
        Comparator<Integer> comp = (a, b) -> Integer.compare(a, b);

        // CA02: n = 0 y n negativo
        System.out.println("CA02 (n=0): longitud = " + Generador.generate(0).length);
        try {
            Generador.generate(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("CA02 (n=-5): capturado -> " + e.getMessage());
        }

        // CA04: [7, 2, 7, 0, 4, 2]
        int[] ca04 = { 7, 2, 7, 0, 4, 2 };
        probarTodasLasVariantes("CA04", ca04, m, comp);

        // CA05: [], [5], [3, 3, 3]
        probarTodasLasVariantes("CA05-vacio", new int[] {}, m, comp);
        probarTodasLasVariantes("CA05-uno", new int[] { 5 }, m, comp);
        probarTodasLasVariantes("CA05-repetidos", new int[] { 3, 3, 3 }, m, comp);

        // CA06: [0, 1, 2, 3] y [3, 2, 1, 0]
        probarTodasLasVariantes("CA06-ordenado", new int[] { 0, 1, 2, 3 }, m, comp);
        probarTodasLasVariantes("CA06-inverso", new int[] { 3, 2, 1, 0 }, m, comp);

        // CA09: Operación que lanza excepción en Benchmark
        try {
            Benchmark.medir(() -> {
                throw new IllegalStateException("Fallo simulado");
            }, "OperacionFallida", "10");
        } catch (RuntimeException e) {
            System.out.println("CA09: capturado -> " + e.getMessage()
                    + " | causa original: " + e.getCause().getClass().getSimpleName());
        }

        // Prueba de caso desfavorable para Quick Sort (arreglo ya ordenado de 5000 elementos)
        int[] ordenado = new int[5000];
        for (int i = 0; i < ordenado.length; i++) {
            ordenado[i] = i;
        }
        int[] aleatorio = Generador.generate(5000);
        Results rAleatorio = Benchmark.medir(() -> m.sortQuick(aleatorio), "Quick Sort (aleatorio)", "5.000");
        Results rOrdenado = Benchmark.medir(() -> m.sortQuick(ordenado), "Quick Sort (ya ordenado)", "5.000");
        System.out.println("\n=== CASO DESFAVORABLE QUICK SORT (n=5000) ===");
        System.out.println(rAleatorio);
        System.out.println(rOrdenado);
    }

    private static void probarTodasLasVariantes(String id, int[] base, Metodos m, Comparator<Integer> comp) {
        int[] v1 = base.clone();
        int[] v2 = base.clone();
        int[] v3 = base.clone();
        Integer[] v4 = new Integer[base.length];
        for (int i = 0; i < base.length; i++) {
            v4[i] = base[i];
        }

        m.sortBubble(v1);
        m.sortQuick(v2);
        m.sortArrays(v3);
        m.sortArraysComparator(v4, comp);

        System.out.println(id + " -> V1:" + Arrays.toString(v1)
                + " | V2:" + Arrays.toString(v2)
                + " | V3:" + Arrays.toString(v3)
                + " | V4:" + Arrays.toString(v4));
    }
}