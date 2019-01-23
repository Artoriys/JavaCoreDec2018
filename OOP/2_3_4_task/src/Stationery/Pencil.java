package Stationery;

public class Pencil extends WriteTools {

    public Pencil(double cost, double length, String color) {
        super(cost, length, color);
    }

    public Pencil() {
        super(10, 15, "red");
    }

    @Override
    public String getName() {
        return "Pencil";
    }
}
