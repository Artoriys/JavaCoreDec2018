import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteReader {

    private byte[] bytesFromFile;
    private String message;

    public void readInputFileBytes(File file) {
        try(FileInputStream byteInputStream = new FileInputStream(file)) {

            bytesFromFile = new byte[(int) file.length()];
            byteInputStream.read(bytesFromFile);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            message = new String(bytesFromFile);
        }
    }

    public byte[] getBytesFromFile() {
        return bytesFromFile;
    }
    public String getMessage() {
        return message;
    }
}
