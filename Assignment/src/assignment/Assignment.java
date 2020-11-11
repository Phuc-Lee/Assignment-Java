package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Assignment {

    public static void main(String[] args) {
        TreeSet<Problem> problem = loadProblem();
        boolean logIn = logIn();
        TreeSet<Contestant> contestant = loadContestant();

        if (logIn) {
            Iterator<Problem> iter = problem.iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }
            System.out.println("\n");
            Iterator<Contestant> iter1 = contestant.iterator();
            while (iter1.hasNext()) {
                System.out.println(iter1.next());
            }
        }

    }

    static TreeSet<Contestant> loadContestant() {
        TreeSet<Contestant> contestant = new TreeSet<>(new sortByRoll());
        try {
            Scanner sc = new Scanner(new File("contestant.dat"));
            while(sc.hasNext()){
                String[] split = sc.nextLine().split("~");
                contestant.add(new Contestant(split[0],split[1],split[2],split[3],Integer.parseInt(split[4]),split[5]));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        return contestant;
    }


    static TreeSet<Problem> loadProblem() {
        TreeSet<Problem> problem = new TreeSet<>(new sortByCat());
        try {
            Scanner sc = new Scanner(new File("questionBank.dat"));
            while (sc.hasNext()) {
                String[] split = sc.nextLine().split("~");
                problem.add(new Problem(split[0], split[1], split[2], split[3], split[4], Double.parseDouble(split[5]), split[6], split[7]));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");

        if (logIn) {

        }
        return problem;
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

class sortByRoll implements Comparator<Contestant> {

    @Override
    public int compare(Contestant o1, Contestant o2) {
        String[] name1 = o1.getName().split(" ");
        String lastName1 = name1[0] + " " + name1[1];
        String[] name2 = o2.getName().split(" ");
        String lastName2 = name2[0] + " " + name2[1];

        if (o1.getId().compareTo(o2.getId()) != 0) {
            if (name1[2].compareTo(name2[2]) == 0) {
                if (lastName1.compareTo(lastName2) == 0) {
                    return o1.getId().compareTo(o2.getId());
                }else{
                    return lastName1.compareTo(lastName2);
                }
            }else{
                return name1[2].compareTo(name2[2]);
            }
        }
        return 0;
    }
}

class sortByCat implements Comparator<Problem> {

    @Override
    public int compare(Problem o1, Problem o2) {
        if (o1.getCategory().compareTo(o2.getCategory()) == 0) {
            return o1.getProblemID().compareTo(o2.getProblemID());
        } else {
            return o1.getCategory().compareTo(o2.getCategory());
        }
    }
}
