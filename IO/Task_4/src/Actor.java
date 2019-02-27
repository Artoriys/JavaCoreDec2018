import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Actor implements Serializable {
    private String name;
    private List<Film> films = new ArrayList<>();

    Actor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String str = "Actor is: " + "\n" + name + "\n"
                + "Films with: " + "\n" + films.toString();
        return str;
    }


    void addFilm(Film film) {
        films.add(film);
    }

}