import java.util.ArrayList;
import static java.lang.System.out;

public class Tan {

    private ArrayList<Double> x = new ArrayList<>();
    private ArrayList<Double> y = new ArrayList<>();

    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double h = Double.parseDouble(args[2]);
        Tan tan = new Tan();
        tan.makeXArray(a, b, h);
        tan.makeYArray();
        tan.print();
    }


    private void makeXArray(double a, double b, double h) {
        double element = a;
        x.add(a);
        do {
            element += h;
            x.add(element);
        } while (element <= b);
    }

    private void makeYArray() {
        for(double element: x) {
            y.add(Math.tan(2*(element))-3);
        }
    }

    private void print() {
        out.print("x        " + "y");
        for(int i = 0; i < x.size(); i++) {
            out.printf("%n%.3f%9.3f", x.get(i), y.get(i));
        }
    }
}
