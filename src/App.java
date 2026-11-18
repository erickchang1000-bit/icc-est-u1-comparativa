import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Generador g = new Generador();
        Benchmark b = new Benchmark();
        
        // Generar y mostrar lista de prueba
        List<Integer> list = g.generate(10);
        System.out.println(list);
        
        // Medir el rendimiento
        Results benGenList = b.medir(() -> g.generate(10000));
        System.out.println(benGenList);
    }
}