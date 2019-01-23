import java.util.HashMap;

public class Student {
    private String name;
    private HashMap<Disciplines, Double> marks = new HashMap<>();
    Student() {}
    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addMark (Disciplines dis, double mark) {

        if (dis == Disciplines.CHEMISTRY || dis == Disciplines.ENGLISH){
            mark = Math.round(mark);
        }
        marks.put(dis, mark);
    }

    public HashMap<Disciplines, Double> getMarks() {
        return marks;
    }

    public Double getMark(Disciplines dis) {
        Double mark = marks.get(dis);
        return mark;
    }

    @Override
    public String toString() {
        return name;
    }
}



