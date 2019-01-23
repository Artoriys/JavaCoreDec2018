import Stationery.*;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Regist {
    private static boolean isWorking = true;
    private static Regist reg = new Regist();
    private LinkedList<Stationery> stationeries = new LinkedList<Stationery>();
    private Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to Stationery Register 1.0.");
        System.out.println("If you need help enter \"help\".");
        System.out.println("Author: Nikita Alemaskin");
        while (isWorking) {
            reg.consoleRun(reg.enterFromKeyboard());
        }
    }

    private void consoleRun(String input) {

        switch (input) {
            case "pen": WriteTools pen = new Pen();
                        reg.addStationary(pen);
                        break;

            case "pencil": WriteTools pencil = new Pencil();
                           reg.addStationary(pencil);
                           break;

            case "feltpen": WriteTools feltpen = new FeltPen();
                            reg.addStationary(feltpen);
                            break;

            case "book": ReadTools book = new Book();
                        reg.addStationary(book);
                        break;

            case "notebook": ReadTools notebook = new Notebook();
                            reg.addStationary(notebook);
                            break;

            case "standard": reg.makeStandard();
                            break;

            case "d": reg.removeStationery();
                        break;

            case "o": reg.showAll();
                        break;

            case "cost": reg.showCost();
                        break;

            case "help": reg.showHelp();
                        break;

            case "q": Regist.setIsWorking(false);
                        break;

            case "sortC": reg.sortByCost();
                        break;

            case "sortN": reg.sortByName();
                        break;

            case "sortCN": reg.sortByCostName();
                        break;

            default: System.out.println("Ooops! Wrong command!");
        }
    }


    private String enterFromKeyboard() {
        System.out.print("Enter: ");
        return scan.nextLine();
    }


    private void addStationary(WriteTools n) {
        System.out.print("Enter cost: ");
        double cost = Double.parseDouble(scan.nextLine());
        System.out.print("Enter color: ");
        String color = scan.nextLine();
        System.out.print("Enter length: ");
        double length = Double.parseDouble(scan.nextLine());
        n.setColor(color);
        n.setLength(length);
        n.setCost(cost);
        stationeries.add(n);
    }

    private void addStationary(ReadTools n) {
        System.out.print("Enter cost: ");
        double cost = Double.parseDouble(scan.nextLine());
        System.out.print("Enter number of pages: ");
        int pageNum = Integer.parseInt(scan.nextLine());
        n.setPageNum(pageNum);
        n.setCost(cost);
        stationeries.add(n);
    }

    private void removeStationery() {
        System.out.print("Enter index: ");
        int index = scan.nextInt();
        stationeries.remove(index);
    }

    private void makeStandard() {
        stationeries.add(new Pen());
        stationeries.add(new Pen());
        stationeries.add(new Pencil());
        stationeries.add(new FeltPen());
        stationeries.add(new Notebook());
        stationeries.add(new Book());
    }

    private void showCost() {
        double cost = 0;

        for (Stationery stat: stationeries) {
            cost += stat.getCost();
        }
        System.out.println("Full cost is " + cost);
    }

    private void showAll() {
        System.out.println("№   Name    Cost");
        int i = 1;
        for (Stationery stat: stationeries) {
            System.out.print(i++ + ".   ");
            System.out.print(stat.getName() + "    " + stat.getCost() + "\t");
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    private void showHelp() {
        System.out.println("///////////////////////////////////");
        System.out.println("Enter 'pen' to add pen");
        System.out.println("Enter 'pencil' to add pencil");
        System.out.println("Enter 'feltpen' to add feltpen");
        System.out.println("Enter 'book' to add book");
        System.out.println("Enter 'notebook' to add notebook");
        System.out.println("Enter 'standard' to add standard pack");
        System.out.println(" ");
        System.out.println("Enter 'd' to remove stationery");
        System.out.println("Enter 'o' to show all stationery");
        System.out.println("Enter 'cost' to show cost of all stationery");
        System.out.println("Enter 'q' to end session");
        System.out.println("Enter 'help' to show help");
        System.out.println("Enter 'sortC' to sort by cost");
        System.out.println("Enter 'sortN' to sort by name");
        System.out.println("Enter 'sortCN' to sort by name");
        System.out.println("///////////////////////////////////");
    }

    private void sortByCost() {
         stationeries.sort(Comparator.comparingDouble(Stationery::getCost));

    }

    private void sortByName() {
        stationeries.sort(Comparator.comparing(Stationery::getName));
    }

    private void sortByCostName() {
        stationeries.sort(Comparator.comparing(Stationery::getCost)
                    .thenComparing(Stationery::getName));
    }


    private static void setIsWorking(boolean isWorking) {
        Regist.isWorking = isWorking;
    }
}

