package Stationery;

public class Notebook extends ReadTools {
    public Notebook(double cost, int pageNum) {
        super(cost, pageNum);
    }

    public Notebook() {
        super(30, 60);
    }

    @Override
    public String getName() {
        return "Notebook";
    }
}
