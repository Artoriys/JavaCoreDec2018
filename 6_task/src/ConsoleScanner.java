
import java.util.LinkedList;
import java.util.Scanner;

/** Class "ConsoleScanner"
 * @Author Nikita Alemaskin
 * @Version 1.0
 * Allows to work with Notepad object from console
 */

public class ConsoleScanner {
    /** Programm works while isWorking true*/
   private static boolean isWorking = true;
   /** Notepad object */
   private Notepad n = new Notepad();
   /** ConsoleScanner object */
   private static ConsoleScanner scanner = new ConsoleScanner();
   /** Scanner object */
   private Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
    while(isWorking) {
            scanner.consoleRun(scanner.enterFromKeyboard());
        }
    }

    /** Decides which method to choose based on input values.
     * @param input value entered from console
     */
    public void consoleRun(String input) {
        if (input.equals("a")) scanner.addNotepad();
        if (input.equals("d")) scanner.removeNotepad();
        if (input.equals("r")) scanner.refactNotepad();
        if (input.equals("o")) scanner.showAll();
        if (input.equals("q")) ConsoleScanner.setIsWorking(false);

    }

    /** Print information how work with console and read values from console
     * @return s
     */
    public String enterFromKeyboard() {
        System.out.println("///////////////////////////////////");
        System.out.println("Enter 'a' to add note");
        System.out.println("Enter 'd' to remove note");
        System.out.println("Enter 'r' to change note");
        System.out.println("Enter 'o' to show all notes");
        System.out.println("Enter 'q' to end session");
        System.out.println("///////////////////////////////////");
        String s = scan.nextLine();
        return s;
    }

    /**
     * Read title and record from console and call Notepad addRecord method
     */
    public void addNotepad() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter note tittle");
        String title = scan.nextLine();
        System.out.println("Enter text of the note");
        String record = scan.nextLine();
        n.addRecord(title,record);
    }

    /**
     * Read index from console and call Notepad removeRecord method
     */
    public void removeNotepad() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter index");
        int index = scan.nextInt();
        n.removeRecord(index);
    }

    /**
     * Read index, tittle and record from console and call Notepad refacRecord method
     */
    public void refactNotepad() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter index");
        int index = Integer.parseInt(scan.nextLine());
        System.out.println("Enter new title");
        String title = scan.nextLine();
        System.out.println("Enter new text of the note");
        String record = scan.nextLine();
        n.refacRecord(index, title, record);
    }

    /**
     * Print Notepad massive of NotepadRecords
     */
    public void showAll() {
        LinkedList<NotepadRecord> records = n.showAllRecords();
        System.out.println("№   Title    Note text");
        int i = 0;
        for (NotepadRecord rec: records) {
            System.out.print(i++ + ".   ");
            System.out.print(rec.getTitle() + "       " + rec.getRecord() + "\t");
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    /**
     * isWorking setter
     * @param isWorking
     */

    public static void setIsWorking(boolean isWorking) {
        ConsoleScanner.isWorking = isWorking;
    }
}
