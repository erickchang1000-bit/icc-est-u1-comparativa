public class Benchmark {

    public static Results medir(Runnable accion, String nombre, String sample) {
        long nanoTimeInicial = System.nanoTime();
        try {
            accion.run();
        } catch (RuntimeException e) {
            throw new RuntimeException(
                    "Fallo en '" + nombre + "' (sample=" + sample + "): " + e.getMessage(), e);
        }
        long nanoTimeFinal = System.nanoTime();

        return new Results(nombre, nanoTimeFinal - nanoTimeInicial, sample);
    }
}