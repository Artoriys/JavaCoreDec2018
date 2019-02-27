import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class ByteSymbolWriter {

    public void byteWriterToFile(File file, byte[] fileBytes) {
        try (FileOutputStream outputStream = new FileOutputStream(file, true)) {
            outputStream.write(fileBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void charWriterToFile(File file, String message) {
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
