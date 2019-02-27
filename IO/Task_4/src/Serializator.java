import java.io.*;
import java.util.List;

class Serializator {
    void saveActors() {
        try {
            FileOutputStream outputStream = new FileOutputStream(new File(
                    "src\\Actors.txt"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(Registor.getActors());
            outputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Saved: " + Registor.getActors().size() + " films!!!");
        }
    }

    void loadActors() {
        int i = 0;
        try {
            FileInputStream inputStream = new FileInputStream(new File(
                    "src\\Actors.txt"));
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            List<Actor> actors = (List<Actor>) objectInputStream.readObject();
            for(Actor actor: actors) {
                Registor.getActors().add(actor);
                i++;
            }
            inputStream.close();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Loaded: " + i + " films!!!");
        }
    }
}
