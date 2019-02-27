import java.util.Scanner;

public class ConsoleManager {
    private static boolean isWorking = true;
    private static ConsoleManager consoleManager = new ConsoleManager();

    private Scanner scan = new Scanner(System.in);
    private Registor reg = new Registor();
    private Serializator ser = new Serializator();

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
            case "save":
                ser.saveActors();
                break;

            case "load":
                ser.loadActors();
                break;

            case "add":
                reg.addActor();
                break;

            case "standard":
                reg.makeStandart();
                break;

            case "d":
                reg.removeActor();
                break;

            case "o":
                reg.showAll();
                break;

            case "mod":
                reg.modifyActor();
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

    private String enterFromKeyboard() {
        System.out.print("Enter: ");
        return scan.nextLine();
    }

    private void showHelp() {
        System.out.println("///////////////////////////////////");
        System.out.println("Enter 'add' to add new actor");
        System.out.println("Enter 'standard' to add standard actors");
        System.out.println("Enter 'save' to save list of actors");
        System.out.println("Enter 'load' to load list of actors");
        System.out.println("Enter 'd' to remove actor");
        System.out.println("Enter 'o' to show all actors");
        System.out.println("Enter 'q' to end session");
        System.out.println("Enter 'help' to show help");
        System.out.println("///////////////////////////////////");
    }


    private static void switchIsWorking() {
        ConsoleManager.isWorking = false;
    }

}
