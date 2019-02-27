import java.io.Serializable;

public class Film implements Serializable {
    private String name;

    Film(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
