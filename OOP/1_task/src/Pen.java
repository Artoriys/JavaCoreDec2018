public class Pen {
    Pen() {
        this.color = "";
        this.size = 0;
        this.cost = 0;
    }
    Pen(String color, double size, double cost) {
        this.color = color;
        this.size = size;
        this.cost = cost;
    }
    String color;
    double size;
    double cost;

    @Override
    public boolean equals(Object obj) {
        Pen other =  (Pen) obj;
        if (other == null ) return false;
        if (!this.color.equals(other.color)) return false;
        if (this.size != other.size) return false;
        if (this.cost != other.cost) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 100;
        hash = 13 * hash + (!this.color.equals("") ? this.StringToInt(color) : 0);
        hash = 13 * hash + (int)this.size;
        hash = 13 * hash + (int)this.cost;
        return hash;
    }

    @Override
    public String toString() {
        return "Color: " + this.color + "; " + "Size: "
                + this.size + "; " + "Cost: " + this.cost + ";";
    }

    public int StringToInt(String color) {
        char[] chars = color.toCharArray();
        int result = 1;
        for (char a: chars) {
            result += a;
        }
        return result;
    }
}
