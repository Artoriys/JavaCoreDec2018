import java.io.*;

public class SymbolReader {

    private String message;

    public void readInputStreamChars(File file) {
        StringBuilder contentBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fileReader);
            String str;
            while ((str = br.readLine()) != null) {
                contentBuilder.append(str+ "\r\n");
            }
            br.close();
        } catch (Exception e) {}
        message = contentBuilder.toString();
    }

    public String getMessage() {
        return message;
    }
}
