public class Benchmark {
        public static Results medir(Runnable accion, String nombre, String sample){
           // System.out.println("Funcion:" + nombre);
           long nanoTimeInicial = System.nanoTime();
           accion.run();
           long nanoTimeFinal = System.nanoTime();

           Results results = new Results(nombre,(nanoTimeFinal-nanoTimeInicial), sample);
           return results;
        }

    }