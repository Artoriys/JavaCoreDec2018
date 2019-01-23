package Stationery;

public class Stationery {

     double cost;
    private String name;



    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

   /*public class CostComparator implements Comparator<Stationery> {

        @Override
        public int compare(Stationery o1, Stationery o2) {
            return (int) o1.getCost() - (int) o2.getCost();
        }
    }

    public class NameComparator implements Comparator<Stationery> {

        @Override
        public int compare(Stationery o1, Stationery o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }*/

}
