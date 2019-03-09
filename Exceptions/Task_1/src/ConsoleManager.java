import java.util.Scanner;

public class ConsoleManager {
    private static boolean isWorking = true;
    private static ConsoleManager consoleManager = new ConsoleManager();
    private CatalogWatcher catalogWatcher = new CatalogWatcher();

    private Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to Actor Registration 1.0.");
        System.out.println("If you need help enter \"help\".");
        System.out.println("Author: Nikita Alemaskin");
        while (isWorking) {
            consoleManager.consoleRun(consoleManager.enterFromKeyboard());
        }
    }
    private void consoleRun(String input) {

        switch (input) {
            case "root": catalogWatcher.moveUp();
            break;

            case "cd": catalogWatcher.moveToSub(chooseDirectory());
            break;

            case "showPath": catalogWatcher.showPath();
            break;

            case "showFiles": catalogWatcher.showFiles();
            break;

            case "nf": catalogWatcher.createTextFile(generateFileName());
            break;

            case "read": catalogWatcher.readFile(generateFileName());
            break;

            case "write": catalogWatcher.
                    writeFile(generateFileName(), generateMessage());
            break;

            case "delete": catalogWatcher.deleteFile(generateFileName());
            break;

            case "help":
                consoleManager.showHelp();
                break;

            case "q":
                switchIsWorking();
                break;


            default:
                System.out.println("Ooops! Wrong command!");
        }
    }
    private String chooseDirectory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose directory");
        return scanner.nextLine();

    }

    private String generateMessage() {
        boolean isWriting = true;
        StringBuilder message = new StringBuilder();
        String buffer;

        Scanner scanner = new Scanner(System.in);
        System.out.println ("Enter message");
        while (isWriting){
            buffer = scanner.nextLine();
            if (buffer.equals("$stop")) {
                isWriting = false;
            } else {
                message.append(buffer).append("\r\n");
            }
        }
       return message.toString();
    }



    private String generateFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose file name");
        return scanner.nextLine();
    }

    private String enterFromKeyboard() {
        System.out.print("Enter: ");
        return scan.nextLine();
    }

    private void showHelp() {
        System.out.println("///////////////////////////////////");
        System.out.println("Enter 'root' to move to parent directory");
        System.out.println("Enter 'cd' to move down to directory");
        System.out.println("Enter 'showPath' to show current path");
        System.out.println("Enter 'showFiles' to showFiles in the directory");
        System.out.println("Enter 'nf' to create new text file");
        System.out.println("Enter 'read' to read text file");
        System.out.println("Enter 'write' to write into text file");
        System.out.println("Enter 'delete' to delete text file (Not directory)");
        System.out.println("Enter 'q' to end session");
        System.out.println("Enter 'help' to show help");
        System.out.println("///////////////////////////////////");
    }


    private static void switchIsWorking() {
        ConsoleManager.isWorking = false;
    }

}
