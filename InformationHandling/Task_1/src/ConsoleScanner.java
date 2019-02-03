import java.util.Scanner;

public class ConsoleScanner {

    private static boolean isWorking = true;
    private static ConsoleScanner reg = new ConsoleScanner();
    private Scanner scan = new Scanner(System.in);
    private CrazyLogger logger = new CrazyLogger();


    public static void main(String[] args) {
        System.out.println("Welcome to CrazyLogger 1.0.");
        System.out.println("If you need help enter \"help\".");
        System.out.println("Author: Nikita Alemaskin");
        while (isWorking) {
            reg.consoleRun(reg.enterFromKeyboard());
        }
    }

    private void consoleRun(String input) {

        switch (input) {
            case "help": reg.showHelp();
            break;

            case "add": reg.addMessage();
            break;

            case "show": reg.showLog();
            break;

            case "q": ConsoleScanner.setIsWorking(false);
            break;

            case "find": reg.find();
            break;

            case "stan": reg.makeStandard();
            break;

            default: System.out.println("Ooops! Wrong command!");
        }
    }

    private void find() {
        System.out.println("Enter message you want to find");
        System.out.print(logger.logSearch(scan.nextLine()));
    }

    private void addMessage() {
        System.out.println("Enter your message:");
        String message = scan.nextLine();
        String currnetTime = logger.getCurrentTime();
        logger.addLog(message, currnetTime);
    }

    private String enterFromKeyboard() {
        System.out.print("Enter: ");
        return scan.nextLine();
    }

    private void showLog() {
        System.out.println(logger.getLog());
    }

    private void makeStandard() {
        logger.addLog("Hello, my name is Nick", logger.getCurrentTime());
        logger.addLog("Start making this", logger.getCurrentTime());
        logger.addLog("Something wrong, where is my cake", logger.getCurrentTime());
        logger.addLog("Goodbye my love", logger.getCurrentTime());
    }



    private void showHelp() {
        System.out.println("///////////////////////////////////");
        System.out.println("Enter 'q' to end session");
        System.out.println("Enter 'help' to show help");
        System.out.println("///////////////////////////////////");
    }


    private static void setIsWorking(boolean isWorking) {
        ConsoleScanner.isWorking = isWorking;
    }
}

