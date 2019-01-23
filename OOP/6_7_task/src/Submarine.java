@Powerfull
public class Submarine {

    Submarine() {
        System.out.println("Submarine constructed without engine!");
    }

    public void joinEngine(SubmarineEngine engine) {
        System.out.println("Engine joined to submarine!");
    }

    public static void main(String[] args) {
        Submarine u96 = new Submarine();
        SubmarineEngine u96engine = new Submarine.SubmarineEngine();
        u96.joinEngine(u96engine);
        u96engine.startEngine();
    }

    public static class SubmarineEngine {

        SubmarineEngine() {
            System.out.println("Engine constructed!");
        }

        public void startEngine() {
            System.out.println("Submarine engine started! Sailing!");
        }

    }

}
