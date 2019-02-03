import java.util.Scanner;

public class ConsoleScanner {
    private static boolean isWorking = true;
    private RuEnQuestions ruEnQuestions = new RuEnQuestions();
    private static ConsoleScanner scanner = new ConsoleScanner();
    private Scanner scan = new Scanner(System.in);

     public static void main(String[] args) {
        System.out.println("Welcome to CrazyLogger 1.0.");
        System.out.println("If you need help enter \"help\".");
        System.out.println("Author: Nikita Alemaskin");

        while (isWorking) {
            scanner.consoleRun(scanner.enterFromKeyboard());
        }
    }

    private void consoleRun(String input) {

        switch (input) {

            case "lang": ruEnQuestions.chooseLang();
                break;

            case "help": scanner.showHelp();
                break;

            case "ans": ruEnQuestions.showQuestions();
                break;

            case "q": scanner.setIsWorking(false);
                break;


            default: System.out.println("Ooops! Wrong command!");
        }
    }

    private String enterFromKeyboard() {
        System.out.print(ruEnQuestions.getResource().getString("enter") + ": ");
        return scan.nextLine();
    }

    private void showHelp() {
        System.out.println(ruEnQuestions.getHelp());
    }

    private static void setIsWorking(boolean isWorking) {
       scanner.isWorking = isWorking;
    }
}
