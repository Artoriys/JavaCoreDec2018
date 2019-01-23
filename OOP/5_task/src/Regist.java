import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Regist {
    private static boolean isWorking = true;
    private static Regist reg = new Regist();
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to Student Register 1.0.");
        System.out.println("If you need help enter \"help\".");
        System.out.println("Author: Nikita Alemaskin");
        while (isWorking) {
            reg.consoleRun(reg.enterFromKeyboard());
        }
    }

    private void consoleRun(String input) {

        switch (input) {

            case "add": reg.addStudent();
                break;

            case "standard": reg.makeStandard();
                break;

            case "d": reg.removeStudent();
                break;

            case "o": reg.showAll();
                break;

            case "mark": reg.showStudentsByDisciplines();
            break;

            case "help": reg.showHelp();
                break;

            case "q": Regist.setIsWorking(false);
                break;


            default: System.out.println("Ooops! Wrong command!");
        }
    }

    private String enterFromKeyboard() {
        System.out.print("Enter: ");
        return scan.nextLine();
    }

    private void addStudent() {
        boolean cont = true;
        String dis = "";
        Student student = new Student();

        System.out.print("Enter student name: ");
        String name = scan.nextLine();
        student.setName(name);
        System.out.println("Disciplines are:" + "\n" + "    PHYSICS - 'phys',\n" +
                "    MATH - 'math',\n" +
                "    ENGLISH - 'eng',\n" +
                "    CHEMISTRY - 'chem',\n" +
                "    PROGRAMMING - 'prog',\n" +
                "    BIOLOGY - 'bio'");
        while (cont) {
            System.out.print("Enter discipline: ");
            dis = scan.nextLine();
            if (dis.equals("stop")) cont = false;
            student = disciplineAdder(student, dis);

        }
        students.add(student);
    }

    private Student disciplineAdder(Student student, String dis) {
        Disciplines disciplines;
        double double_mark;
        String mark;
        switch (dis) {

            case "phys": disciplines = Disciplines.PHYSICS;
                System.out.println("PHYSICS added.");
                System.out.println( "Please add double mark: ");
                mark = scan.nextLine();
                double_mark = Double.parseDouble(mark);
                student.addMark(disciplines,double_mark);
            break;

            case "math": disciplines = Disciplines.MATH;
                System.out.println("MATH added.");
                System.out.println("Please add double mark: ");
                mark = scan.nextLine();
                double_mark = Double.parseDouble(mark);
                student.addMark(disciplines,double_mark);;
            break;

            case "eng" : disciplines = Disciplines.ENGLISH;
                System.out.println("ENGLISH added");
                System.out.println("Please add int mark: ");
                mark = scan.nextLine();
                double_mark = Double.parseDouble(mark);
                student.addMark(disciplines,double_mark);
            break;

            case "chem" : disciplines = Disciplines.CHEMISTRY;
                System.out.println("CHEMISTRY added");
                System.out.println("Please add int mark: ");
                mark = scan.nextLine();
                double_mark = Double.parseDouble(mark);
                student.addMark(disciplines,double_mark);
            break;

            case "prog": disciplines = Disciplines.PROGRAMMING;
                System.out.println("PROGRAMMING added");
                System.out.println("Please add double mark: ");
                mark = scan.nextLine();
                double_mark = Double.parseDouble(mark);
                student.addMark(disciplines,double_mark);
            break;

            case "bio" : disciplines = Disciplines.BIOLOGY;
                System.out.println("BIOLOGY added");
                System.out.println("Please add double mark: ");
                mark = scan.nextLine();
                double_mark = Double.parseDouble(mark);
                student.addMark(disciplines,double_mark);
            break;

            case "stop" :System.out.println("Stop entering disciplines");
            break;

            default:
                System.out.println("Wrong discipline!");
                return null;
        }
        return student;
    }

    private void removeStudent() {
        System.out.print("Enter index: ");
        int index = scan.nextInt();
       students.remove(index);
    }

    private void makeStandard() {
        Disciplines phys = Disciplines.PHYSICS;
        Disciplines math = Disciplines.MATH;
        Disciplines eng = Disciplines.ENGLISH;
        Disciplines chem = Disciplines.CHEMISTRY;
        Disciplines prog = Disciplines.PROGRAMMING;
        Disciplines bio = Disciplines.BIOLOGY;


        Student nick = new Student("Nick");
        nick.addMark(phys,4.3);
        nick.addMark(eng, 4);
        nick.addMark(chem, 2.3);
        nick.addMark(prog, 5);
        students.add(nick);

        Student july = new Student("July");
        july.addMark(eng, 5.2);
        july.addMark(chem, 4.1);
        july.addMark(bio, 4.3);
        students.add(july);

        Student john = new Student("John");
        john.addMark(prog, 5.5);
        john.addMark(eng, 4);
        john.addMark(phys, 2.6);
        john.addMark(bio, 3.1);
        students.add(john);

        Student masha = new Student("Masha");
        masha.addMark(eng, 2);
        masha.addMark(math, 3.4);
        masha.addMark(chem, 3);
        students.add(masha);


    }


    private void showAll() {
        System.out.println("№   Name    Disciplines     Marks");
        int i = 1;
        for (Student stat: students) {
            System.out.print(i++ + ".   ");
            System.out.print(stat.getName());
            System.out.println(" ");
            for (Disciplines dis: stat.getMarks().keySet()) {
                System.out.println("             " + dis.toString() + "       " + stat.getMarks().get(dis) + "\t" );
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    private void showStudentsByDisciplines() {
        int i = 0;
        HashMap<String, Double> phys = new HashMap<>();
        HashMap<String, Double> math = new HashMap<>();
        HashMap<String, Double> eng = new HashMap<>();
        HashMap<String, Double> chem = new HashMap<>();
        HashMap<String, Double> prog = new HashMap<>();
        HashMap<String, Double> bio = new HashMap<>();
        ArrayList<HashMap<String, Double>> disciplines = new ArrayList<>();
        for (Student student : students) {
            if (student.getMarks().keySet().contains(Disciplines.PHYSICS))
                phys.put(student.getName(), student.getMark(Disciplines.PHYSICS));

            if (student.getMarks().keySet().contains(Disciplines.MATH))
                math.put(student.getName(), student.getMark(Disciplines.MATH));

            if (student.getMarks().keySet().contains(Disciplines.ENGLISH))
                eng.put(student.getName(), student.getMark(Disciplines.ENGLISH));

            if (student.getMarks().keySet().contains(Disciplines.CHEMISTRY))
                chem.put(student.getName(), student.getMark(Disciplines.CHEMISTRY));

            if (student.getMarks().keySet().contains(Disciplines.PROGRAMMING))
                prog.put(student.getName(), student.getMark(Disciplines.PROGRAMMING));

            if (student.getMarks().keySet().contains(Disciplines.BIOLOGY))
                bio.put(student.getName(), student.getMark(Disciplines.BIOLOGY));
        }

        disciplines.add(phys);
        disciplines.add(math);
        disciplines.add(eng);
        disciplines.add(chem);
        disciplines.add(prog);
        disciplines.add(bio);

        System.out.println("Disciplines    Names     Marks");

        for (HashMap<String, Double> discipline : disciplines) {
            System.out.println(" ");
            System.out.println(Disciplines.values()[i].toString());
            for (int j = 0; j < discipline.size(); j++) {
                System.out.println("               " +
                        discipline.keySet().toArray()[j] +
                        "       " + discipline.get(discipline.keySet().toArray()[j]));
            }
            i++;
        }
    }

    private void showHelp() {
        System.out.println("///////////////////////////////////");
        System.out.println("Enter 'add' to add new student");
        System.out.println("Enter 'standard' to add standard pack");
        System.out.println(" ");
        System.out.println("Enter 'd' to remove student");
        System.out.println("Enter 'o' to show all students");
        System.out.println("Enter 'mark' to show all students by disciplines");
        System.out.println("Enter 'q' to end session");
        System.out.println("Enter 'help' to show help");
        System.out.println("///////////////////////////////////");
    }


    private static void setIsWorking(boolean isWorking) {
        Regist.isWorking = isWorking;
    }
}

