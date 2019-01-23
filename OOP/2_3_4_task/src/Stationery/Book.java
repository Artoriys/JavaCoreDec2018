package Stationery;

public class Book extends ReadTools {

    public Book(double cost, int pageNum) {
        super(cost, pageNum);
    }

    public Book() {
        super(40, 100);
    }

    @Override
    public String getName() {
        return "Book";
    }
}
