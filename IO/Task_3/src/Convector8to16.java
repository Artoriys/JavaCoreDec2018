import java.io.*;

public class Convector8to16 {
    File fileIn = new File("C:\\Programming\\EPAM\\JavaCoreDec2018\\IO\\Task_3\\src\\Java.txt");
    File fileOut = new File("C:\\Programming\\EPAM\\JavaCoreDec2018\\IO\\Task_3\\src\\Java_out.txt");
    char[] fileChars = new char[(int) fileIn.length()];

    public static void main(String[] args) {
        Convector8to16 convector8to16 = new Convector8to16();
        convector8to16.readUTF8();
        convector8to16.writeUTF16();
    }
    public void readUTF8() {

        try {
            FileInputStream fileInputStream = new FileInputStream(fileIn);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            inputStreamReader.read(fileChars, 0, (int) fileIn.length());
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeUTF16() {
        try {
            FileOutputStream outputStream = new FileOutputStream(fileOut, false);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
            outputStreamWriter.write(fileChars,0,fileChars.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
