package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Assignment {

    public static void main(String[] args) {
//        int id = (int)Math.floor((Math.random()*899999)+100000);
//        String ID = "HE" + Double.toString(id);
//        Contestant phuc = new Contestant("lehoangphuc", ID, "lehoangphuc@fpt.edu.vn", "1234567890", 1, "1234");

        boolean logIn = logIn();

        TreeSet<Problem> problem = new TreeSet<>(new sortByID());
        try {
            Scanner sc = new Scanner(new File("questionBank.dat"));
            while (sc.hasNext()) {
                String[] split = sc.next().split("~");
                problem.add(new Problem());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");;
        }

        if (logIn) {
            

        }

    }

    static boolean logIn() {
        Scanner sc = new Scanner(System.in);

        System.out.print("User name(Email): ");
        String name = sc.nextLine();
        boolean checkName = check(name, 'n');
        System.out.print("Password: ");
        String pass = sc.nextLine();
        boolean checkPass = check(pass, 'p');

        if (checkName && checkPass) {
            System.out.println("Welcome back!");
            return true;
        }else {
            System.out.println("Check email or password!");
            logIn();
        }
        return false;
    }

    static boolean check(String str, char a) {
        HashMap<String, String> loginfo = new HashMap<>();
        try {
            Scanner sc1 = new Scanner(new File("contestant.dat"));
            while (sc1.hasNext()) {
                String[] split = sc1.nextLine().split("~");
//                System.out.println(split.length);
                loginfo.put(split[2], split[split.length - 1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        boolean i = true;

        for (Map.Entry ele : loginfo.entrySet()) {
            if (a == 'n') {
                if (str.equals(ele.getKey())) {
                    i = true;
                } else {
                    i = false;
                }
            } else if (a == 'p') {
                if (str.equals(ele.getValue())) {
                    i = true;
                } else {
                    i = false;
                }
            }
        }

        return i;

    }

}

class sortByID implements Comparator<Problem> {

    @Override
    public int compare(Problem o1, Problem o2) {
        return 1;
    }
}
