package Stationery;

public class FeltPen extends WriteTools {

    public FeltPen(double cost, double length, String color) {
        super(cost, length, color);
    }

    public FeltPen() {
        super(25, 10, "yellow");
    }

    @Override
    public String getName() {
        return "Felt Pen";
    }
}
