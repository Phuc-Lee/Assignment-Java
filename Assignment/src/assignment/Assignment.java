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

        while (logIn) {
            System.out.println("What do you want ?");
            System.out.println("1.Change your infomation ");
            System.out.println("2.Add a Question ");
            System.out.println("3.Change Question's infomation ");
            System.out.println("4.Show list Question ");
            System.out.println("5.Generate a Contest ");
            System.out.println("6.Print Contest");
            System.out.println("7.Sort list Question ");
            System.out.println("8.Save/Load/Export");
            int choice;
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case '1': {
                }
            }
        }

    }

    static boolean logIn() {
        Scanner sc = new Scanner(System.in);

        System.out.print("User name(Email): ");
        String name = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        boolean check = check(name, pass);

        if (check) {
            System.out.println("Welcome back!");
            return true;
        } else {
            System.out.println("Check email or password!");
            logIn();
        }
        return false;
    }

    static boolean check(String name, String pass) {
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

        for (Map.Entry ele : loginfo.entrySet()) {
            if (name.equals(ele.getKey())) {
                if (pass.equals(ele.getValue())) {
                    return true;
                }
            }
        }

        return false;
    }
}

class sortByID implements Comparator<Problem> {

    @Override
    public int compare(Problem o1, Problem o2) {
        return 1;
    }
}
