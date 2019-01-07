import java.util.ArrayList;
import static java.lang.System.out;

public class Main {

    private ArrayList<Double> elements = new ArrayList<>();
    private int j = 0;


    public static void main(String args[]) {
        double eps = Double.parseDouble(args[0]);
        Main m = new Main();
        m.makeArray(eps);
        m.print();
    }

    public void makeArray(double eps) {
        int i = 1;
        double el;
       do {
            el = 1 / Math.pow(i + 1, 2);
            elements.add(el);
            i++;
        } while (elements.get(j++) > eps);
    }

    public void print() {
        int n = 1;
        out.println("Наименьший номер элемента" +
                   " последовательности: " + j);
        for (double element: elements) {
            out.println(n + ".  " + element);
            n++;
        }
    }
}
