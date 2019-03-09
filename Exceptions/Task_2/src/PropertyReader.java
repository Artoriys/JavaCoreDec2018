import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private Properties properties = new Properties();


    public static void main(String[] args) {
        PropertyReader propertyReader = new PropertyReader();
        propertyReader.readProperty();
        propertyReader.checkKeys();
        propertyReader.showProperty();
    }

    private void readProperty() {
        try(FileReader fileReader = new FileReader("prop.properties")) {
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("Illegal argument");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showProperty() {
         properties.forEach((a, b) -> System.out.println(a + " = " + b));
    }

    private void checkKeys() {
        properties.forEach((a,b) -> {
            if (a.equals("")) throw new IllegalArgumentException("Missing key");});
    }
}


