package Stationery;

public class Pen extends WriteTools {

 public Pen(double cost, double length, String color) {
     super(cost, length, color);
 }

 public Pen() {
     super(20, 6, "green");
 }

 @Override
 public String getName() {
     return "Pen";
 }
}
