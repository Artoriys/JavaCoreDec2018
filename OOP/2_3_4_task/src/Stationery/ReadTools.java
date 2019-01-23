package Stationery;

public class ReadTools extends Stationery {
    private int pageNum;

     ReadTools(double cost, int pageNum) {
        this.cost = cost;
        this.pageNum = pageNum;
    }

    public ReadTools() {
        this.cost = 40;
        this.pageNum = 100;
    }

    public int getPageNum() {
        return this.pageNum;
    };

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

}
