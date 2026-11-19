import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Metodos m = new Metodos();
        Comparator<Integer> comp = (a, b) -> Integer.compare(a, b);

        // LOS 3 ARREGLOS BASE
        int[] list1 = Generador.generate(10000);
        int[] list2 = Generador.generate(50000);
        int[] list3 = Generador.generate(100000);

        // REFERENCIAS ORDENADAS (fuera del cronómetro, solo para validar)
        int[] ref1 = list1.clone();
        Arrays.sort(ref1);
        int[] ref2 = list2.clone();
        Arrays.sort(ref2);
        int[] ref3 = list3.clone();
        Arrays.sort(ref3);

        // COPIAS INDEPENDIENTES
        int[] list1c1 = list1.clone();
        int[] list1c2 = list1.clone();
        int[] list1c3 = list1.clone();
        Integer[] list1c4 = convertirAInteger(list1);

        int[] list2c1 = list2.clone();
        int[] list2c2 = list2.clone();
        int[] list2c3 = list2.clone();
        Integer[] list2c4 = convertirAInteger(list2);

        int[] list3c1 = list3.clone();
        int[] list3c2 = list3.clone();
        int[] list3c3 = list3.clone();
        Integer[] list3c4 = convertirAInteger(list3);

        // LISTADO DE RESULTADOS
        List<Results> resultados = new ArrayList<>();

        // V1: Burbuja
        Results resultaM1S1 = Benchmark.medir(() -> m.sortBubble(list1c1), "Bubble Sort", "10.000");
        validar(list1c1, ref1, "Bubble Sort", "10.000");
        resultados.add(resultaM1S1);

        Results resultaM1S2 = Benchmark.medir(() -> m.sortBubble(list2c1), "Bubble Sort", "50.000");
        validar(list2c1, ref2, "Bubble Sort", "50.000");
        resultados.add(resultaM1S2);

        Results resultaM1S3 = Benchmark.medir(() -> m.sortBubble(list3c1), "Bubble Sort", "100.000");
        validar(list3c1, ref3, "Bubble Sort", "100.000");
        resultados.add(resultaM1S3);

        // V2: Quick Sort
        Results resultaM2S1 = Benchmark.medir(() -> m.sortQuick(list1c2), "Quick Sort", "10.000");
        validar(list1c2, ref1, "Quick Sort", "10.000");
        resultados.add(resultaM2S1);

        Results resultaM2S2 = Benchmark.medir(() -> m.sortQuick(list2c2), "Quick Sort", "50.000");
        validar(list2c2, ref2, "Quick Sort", "50.000");
        resultados.add(resultaM2S2);

        Results resultaM2S3 = Benchmark.medir(() -> m.sortQuick(list3c2), "Quick Sort", "100.000");
        validar(list3c2, ref3, "Quick Sort", "100.000");
        resultados.add(resultaM2S3);

        // V3: Arrays.sort - int[]
        Results resultaM3S1 = Benchmark.medir(() -> m.sortArrays(list1c3), "Arrays.sort - int[]", "10.000");
        validar(list1c3, ref1, "Arrays.sort - int[]", "10.000");
        resultados.add(resultaM3S1);

        Results resultaM3S2 = Benchmark.medir(() -> m.sortArrays(list2c3), "Arrays.sort - int[]", "50.000");
        validar(list2c3, ref2, "Arrays.sort - int[]", "50.000");
        resultados.add(resultaM3S2);

        Results resultaM3S3 = Benchmark.medir(() -> m.sortArrays(list3c3), "Arrays.sort - int[]", "100.000");
        validar(list3c3, ref3, "Arrays.sort - int[]", "100.000");
        resultados.add(resultaM3S3);

        // V4: Arrays.sort + Comparator - Integer[]
        Results resultaM4S1 = Benchmark.medir(() -> m.sortArraysComparator(list1c4, comp),
                "Arrays.sort + Comparator - Integer[]", "10.000");
        validarInteger(list1c4, ref1, "Arrays.sort + Comparator - Integer[]", "10.000");
        resultados.add(resultaM4S1);

        Results resultaM4S2 = Benchmark.medir(() -> m.sortArraysComparator(list2c4, comp),
                "Arrays.sort + Comparator - Integer[]", "50.000");
        validarInteger(list2c4, ref2, "Arrays.sort + Comparator - Integer[]", "50.000");
        resultados.add(resultaM4S2);

        Results resultaM4S3 = Benchmark.medir(() -> m.sortArraysComparator(list3c4, comp),
                "Arrays.sort + Comparator - Integer[]", "100.000");
        validarInteger(list3c4, ref3, "Arrays.sort + Comparator - Integer[]", "100.000");
        resultados.add(resultaM4S3);

        // IMPRESIÓN FINAL DE LOS 12 RESULTADOS
        for (Results r : resultados) {
            System.out.println(r);
        }
    }

    private static Integer[] convertirAInteger(int[] datos) {
        Integer[] copia = new Integer[datos.length];
        for (int i = 0; i < datos.length; i++) {
            copia[i] = datos[i];
        }
        return copia;
    }

    private static void validar(int[] resultado, int[] referencia, String metodo, String sample) {
        if (!Arrays.equals(resultado, referencia)) {
            throw new IllegalStateException("Error de ordenamiento en " + metodo + " (" + sample + ")");
        }
    }

    private static void validarInteger(Integer[] resultado, int[] referencia, String metodo, String sample) {
        if (resultado.length != referencia.length) {
            throw new IllegalStateException("Longitud incorrecta en " + metodo + " (" + sample + ")");
        }
        for (int i = 0; i < referencia.length; i++) {
            if (resultado[i] == null || resultado[i] != referencia[i]) {
                throw new IllegalStateException("Error de ordenamiento en " + metodo + " (" + sample + ")");
            }
        }
    }
}