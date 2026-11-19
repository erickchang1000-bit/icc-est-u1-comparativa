import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Generador g = new Generador();
        Benchmark b = new Benchmark();
        Metodos m = new Metodos();
        //10000
        List<Integer> list1 = g.generate(10000);
        List<Integer> list2 = g.generate(50000);
        List<Integer> list3 = g.generate(10000000);
        //clone de las listas 
        List<Integer> list2c1 = Arrays.copyOf(list2,list2.size())
        Results resultaM1S1 = Benchmark.medir)


    }
}