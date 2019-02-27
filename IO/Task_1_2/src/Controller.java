import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

   static ByteReader byteReader = new ByteReader();
   static SymbolReader symbolReader = new SymbolReader();
   static ByteSymbolWriter byteSymbolWriter = new ByteSymbolWriter();
   Pattern keyWords = Pattern.compile("abstract|continue|for|new|switch|" +
           "assert|default|goto|package|synchronized|" +
           "boolean|do|if|private|this|" +
           "break|double|implements|protected|throw|" +
           "byte|else|import|public|throws|" +
           "case|enum|instanceof|return|transient|" +
           "catch|extends|int|short|try|" +
           "char|final|interface|static|void|" +
           "class|finally|long|strictfp|volatile|" +
           "const|float|native|super|while");
    static File fileRead = new File("C:\\Programming\\EPAM\\JavaCoreDec2018\\IO\\Task_1_2\\src\\Massive.java");
    static File fileWrite = new File("C:\\Programming\\EPAM\\JavaCoreDec2018\\IO\\Task_1_2\\src\\Notes.txt");

    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.fileCleaner(fileWrite);

        byteReader.readInputFileBytes(fileRead);
        symbolReader.readInputStreamChars(fileRead);

        controller.analyzeForKeyWords();
    }

    public void fileCleaner(File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void analyzeForKeyWords() {
        Scanner scannerBytes = new Scanner(byteReader.getMessage());
        Scanner scannerChars = new Scanner(symbolReader.getMessage());
        String str = "";
        int byteCount = 0;
        int charCount = 0;
        byteSymbolWriter.charWriterToFile(fileWrite, "Start byte analyze" + "\r\n");
        try {
            while ((str = scannerBytes.nextLine()) != null) {
                Matcher keyWordMatcher = keyWords.matcher(str);
                while (keyWordMatcher.find()) {
                    byteSymbolWriter.charWriterToFile(fileWrite, keyWordMatcher.group() + "\r\n");
                    byteCount++;
                }
            }
        } catch (NoSuchElementException e) {
        }

        byteSymbolWriter.charWriterToFile(fileWrite, "Stop byte analyze. Number of key words: " + byteCount + "\r\n" + "\r\n");

        byteSymbolWriter.charWriterToFile(fileWrite, "Start symbol analyze" + "\r\n");
        try {
            while ((str = scannerChars.nextLine()) != null) {
                Matcher keyWordMatcher = keyWords.matcher(str);
                while (keyWordMatcher.find()) {
                    byteSymbolWriter.charWriterToFile(fileWrite, keyWordMatcher.group() + "\r\n");
                    charCount++;
                }
            }
        } catch (NoSuchElementException e) {
        }

        byteSymbolWriter.charWriterToFile(fileWrite, "Stop symbol analyze. Number of key words: " + charCount);

    }

}
