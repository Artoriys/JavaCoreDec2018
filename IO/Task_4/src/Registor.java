import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Registor implements Serializable {
    private static List<Actor> actors = new ArrayList<>();

    static List<Actor> getActors() {
        return actors;
    }

    private Actor makeActor() {
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        String actorName;
        String filmName;

        System.out.print("Enter actor name: ");
        actorName = scan.nextLine();
        Actor actor = new Actor(actorName);
        while (cont) {
            System.out.print("Enter film's name: ");
            filmName = scan.nextLine();
            Film film = new Film(filmName);
            if (!filmName.equals("stop")) {
                actor.addFilm(film);
            } else cont = false;

        }
        return actor;
    }

    void addActor() {
        Actor actor = makeActor();
        actors.add(actor);
    }

    void removeActor() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of actor you want to delete");
        int i = scan.nextInt() - 1;
        actors.remove(i);
    }

    void modifyActor() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of actor you want to modify");
        int i = scan.nextInt() - 1;
        actors.remove(i);
        Actor actor = makeActor();
        actors.add(i, actor);
    }

    void showAll() {
        System.out.println("№   Name  ");
        int i = 1;
        for (Actor actor: actors) {
            System.out.print(i++ + ".   ");
            System.out.print(actor.toString());
            System.out.println(" ");
            /*for (Disciplines dis: stat.getMarks().keySet()) {
                System.out.println("             " + dis.toString() + "       " + stat.getMarks().get(dis) + "\t" );
            }*/
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    void makeStandart() {
        Actor actor = new Actor("Silvester Stallone");
        actor.addFilm(new Film("Cobra"));
        actor.addFilm(new Film("Rembo 1"));
        actor.addFilm(new Film("Rembo 2"));
        actors.add(actor);

        actor = new Actor("Audrey Hepburn");
        actor.addFilm(new Film("Roman Holiday"));
        actor.addFilm(new Film("Breakfast at Tiffany's"));
        actors.add(actor);

        actor = new Actor("Piter O'Tul");
        actor.addFilm(new Film("Lawrence of Arabia"));
        actors.add(actor);
    }
}
