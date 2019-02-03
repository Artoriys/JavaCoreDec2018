
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class RuEnQuestions {
    private Locale locale = new Locale("en", "EN");
    private Scanner scan = new Scanner(System.in);
    private ResourceBundle resource = ResourceBundle.getBundle("Resource", locale);
    private ResourceBundle questions = ResourceBundle.getBundle("Questions", locale);
    private ResourceBundle answears = ResourceBundle.getBundle("Answers", locale);
    private ResourceBundle help = ResourceBundle.getBundle("Help", locale);

    public void chooseLang() {
        System.out.println(resource.getString("lang_are") + ":" + "\n"
                + "1. " + resource.getString("eng") + "\n" +
                "2. " + resource.getString("rus") + "\n" +
                resource.getString("lang_number_choose") + ":");

        String number = scan.nextLine();

        if (number.equals("1")) {
            locale = new Locale("en" , "EN");
        }
        if (number.equals("2")) {
            locale = new Locale("ru", "RU");
        }
        resource = ResourceBundle.getBundle("Resource", locale);
        questions = ResourceBundle.getBundle("Questions", locale);
        answears = ResourceBundle.getBundle("Answers", locale);
        help = ResourceBundle.getBundle("Help", locale);
    }


    public void showQuestions() {
        if (questions != null) {
            int i = 1;
            for (String str : questions.keySet()) {
                System.out.print(i + ". " + questions.getString(str) + "\n");
                i++;
            }
            showAnswers();
        } else {
            System.out.println("You need to choose language");
        }
    }


    private void showAnswers() {
        boolean work = true;
       while (work) {
           System.out.println("\n" + resource.getString("choose_q_a"));
           String ans = scan.nextLine();
           switch (ans) {
               case "1" :
                   System.out.println(answears.getString("a1"));
                   break;
               case "2" :
                   System.out.println(answears.getString("a2"));
                   break;
               case "3" :
                   System.out.println(answears.getString("a3"));
                   break;
               case "q" : work = false;
               break;
           }
       }
    }

    public ResourceBundle getResource() {
        return resource;
    }

    public String getHelp() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("//////////////////////////" + "\n");
        for (String str : help.keySet()) {
            stringBuilder.append(help.getString(str) + "\n");
        }
        stringBuilder.append("//////////////////////////" + "\n");
        return stringBuilder.toString();
    }

}
