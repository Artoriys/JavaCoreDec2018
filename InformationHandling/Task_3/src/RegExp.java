import java.io.*;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegExp {
    private String content;
    private LinkedHashSet<String> groups = new LinkedHashSet<>();
    private StringBuilder sentences = new StringBuilder();

    public static void main(String[] args) {
        RegExp regExp = new RegExp();
        regExp.htmlReader();
        regExp.htmlParser();
        regExp.printSet();
        regExp.printSentence();
    }

    private void htmlReader() {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            InputStreamReader isr = new InputStreamReader(
                    new FileInputStream("Java.SE.03.Information handling_task_attachment.html"),
                    "CP1251");
            BufferedReader br = new BufferedReader(isr);
            String str;
            while ((str = br.readLine()) != null) {
                contentBuilder.append(str + "\n");
            }
            br.close();
        } catch (Exception e) {}
        content = contentBuilder.toString();
    }

    private void htmlParser() {
        Pattern sentencePat = Pattern.compile("(<div>|<p>)(.*(\\([Рр]ис\\. \\d{1,2}\\)).*)(</div>|</p>$)");
        Pattern imagePat = Pattern.compile("(\\([Рр]ис\\. \\d{1,2}\\))");
        Scanner scanner = new Scanner(content);
        String str;
        try {
            while ((str = scanner.nextLine()) != null) {
                Matcher senMatcher = sentencePat.matcher(str);
                Matcher imageMatcher = imagePat.matcher(str);
                if (senMatcher.matches()){
                    sentences.append(senMatcher.group(2) + "\n");
                    while (imageMatcher.find()) {
                        groups.add(imageMatcher.group(0).replace('р', 'Р'));
                    }
                }
            }
        } catch (NoSuchElementException e) {
        }

    }

    private void printSet() {
        System.out.println("");
        System.out.println("Set of references:" + "\n");
        for (String str: groups) {
            System.out.println(str);
        }
    }
    private void printSentence() {
        System.out.println("");
        System.out.println(sentences.toString());
    }
}
