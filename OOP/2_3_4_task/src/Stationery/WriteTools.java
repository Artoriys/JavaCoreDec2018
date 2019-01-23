package Stationery;

public class WriteTools extends Stationery {

    private double length;

    private String color;

    WriteTools(double cost, double length, String color) {
        this.cost = cost;
        this.length = length;
        this.color = color;
    }

    WriteTools() {
        this.cost = 10;
        this.length = 5;
        this.color = "red";
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
