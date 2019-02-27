import static java.lang.System.out;
public class Massive {


    public static void main(String[] args) {
        Massive massive = new Massive();
        Double[] nums = massive.stringToDouble(args);
        massive.maxValue(nums);
    }



    private Double[] stringToDouble(String[] args){
        Double[] a = new Double[args.length];
        int i =0;
        for(String arg: args) {
           a[i] = Double.parseDouble(arg);
           i++;
        }
        return a;
    }

    private void maxValue(Double[] a) {
        double max = 0;
        int j = a.length-1;
        int i = 0;
        int s_i = 0;
        int s_j = 0;
        while (i < j){
            if ((a[i] + a[j]) > max) {
                max = a[i] + a[j];
                s_i = i;
                s_j = j;
            }
            i++;
            j--;
        }
        Print(max, s_i, s_j, a);
    }

    private void Print( double max, int s_i, int s_j, Double[] a) {
        out.print("Входной массив: ");
        for (Double z:a){
            out.print(z + " ");
        }
        out.println();
        out.println("Максимальное значение: " + max);
        out.print("Индексы элементов: " + s_i + ", " + s_j);
    }
}
