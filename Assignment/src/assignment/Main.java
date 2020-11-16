package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static TreeSet<Problem> problem;
    static TreeSet<Contestant> contestant;
    static HashMap<String, String> contestID = new HashMap<>();

    public static void main(String[] args) throws IOException {
        problem = loadProblem();
        contestant = loadContestant();
        contestID = loadAllContestID();
        boolean logIn = logIn();

        
        int choice = 9;

        while (logIn) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n----------------\nPlease choose your option:");
            System.out.println("\t0. Log out and quit");
            System.out.println("\t1. Change your infomation ");
            System.out.println("\t2. Add a new question ");
            System.out.println("\t3. Update problem ");
            System.out.println("\t4. Available problems ");
            System.out.println("\t5. Generate a contest ");
            System.out.println("\t6. Print information of a contest");
            int flag = 1;
            do {
                try {
                    choice = sc.nextInt();
                } catch (InputMismatchException a) {
                    System.out.print("Invalid choice! Choose again: ");
                    flag = 0;
                }
            } while (flag!=1);

            switch (choice) {
                case 1:
                    for (Contestant i : contestant) {
//                        System.out.println(i);
                        if (i.getEmail().equals(mail)) {
                            i.changeInfor();
                            System.out.println("Your information has been changed: ");
                            System.out.println(i);
                            break;
                        }
                    }
                    FileWriter writerCT = new FileWriter("contestant.dat");
                    for (Contestant i : contestant) {
//                        System.out.println(i);
                        try {
                            writerCT.write(i.getName() + "~" + i.getId() + "~" + i.getEmail() + "~" + i.getMobilephone()
                                    + "~" + String.valueOf(i.getRank()) + "~" + i.getPassword() + "\n");
                            writerCT.flush();
                        } catch (IOException ex) {
                            System.out.println("File does not exist");
                        }
                    }
                    writerCT.close();
                    break;

                case 2:
                    Problem e = new Problem();
                    e.addQues();
                    problem.add(e);
                    System.out.println("You just added a problem into the question bank:");
                    System.out.println(e);
                    FileWriter writerQS = new FileWriter("QBs.dat");
                    try {
                        for (Problem i : problem) {
                            writerQS.write(i.getProblemID() + "~" + i.getCategory() + "~" + i.getAuthor() + "~" + i.getDate() + "~" + i.getName()
                                    + "~" + String.valueOf(i.getMark_weight()) + "~" + i.getShort_decrip() + "~" + i.getLong_decrip() + "\n");
                        }
                        writerQS.flush();
                    } catch (IOException ex) {
                        System.out.println("File does not exist");
                    }
                    writerQS.close();
                    break;

                case 3:
                    System.out.print("Problem ID : ");
                    Scanner scan = new Scanner(System.in);
                    String qsId = scan.nextLine();

                    boolean check = false;
                    for (Problem e1 : problem) {
                        if (e1.getProblemID().equals(qsId)) {
                            e1.updateQues();
                            check = true;
                            System.out.println("Problem is updated:");
                            System.out.println(e1);
                        }
                    }
                    if (check == false) {
                        System.out.println("Problem's ID does not exist!");
                    }

                    FileWriter writerQS1 = new FileWriter("QBs.dat");
                    for (Problem em1 : problem) {
//                        System.out.println(em1);
                        try {
                            writerQS1.write(em1.getProblemID() + "~" + em1.getCategory() + "~" + em1.getAuthor() + "~" + em1.getDate() + "~" + em1.getName() + "~" + em1.getMark_weight() + "~" + em1.getShort_decrip() + "~" + em1.getLong_decrip() + "\n");
                            writerQS1.flush();
                        } catch (IOException ex) {
                            System.out.println("File does not exist");
                        }
                    }
                    writerQS1.close();
                    break;

                case 4:
                    listAllProb(problem);
                    break;

                case 5:
                    generateContest();
                    break;

                case 6:
                    printContest();
                    break;
            }
            if (choice == 0) {
                System.out.println("\nSee you soon!");
                sc.close();
                break;
            }
        }
    }

    private static void listAllProb(TreeSet<Problem> a) {
        Iterator<Problem> iter = a.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("\n");
    }

    private static TreeSet<Contestant> loadContestant() {
        contestant = new TreeSet<>(new sortByRoll());
        try {
            Scanner sc = new Scanner(new File("contestant.dat"));
            while (sc.hasNext()) {
//                System.out.println(sc.next());
                String[] split = sc.nextLine().split("~");
//                System.out.println(split.length);
//                for(String i: split){
//                    System.out.print(i + " ");
//                    System.out.println("");
//                }
                contestant.add(new Contestant(split[0], split[1], split[2], split[3], Integer.parseInt(split[4]), split[5]));
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
//        for (Contestant i : contestant) {
//            System.out.print(i + " ");
//            System.out.println("");
//        }
        return contestant;
    }

    private static HashMap<String, String> loadAllContestID() {
        Scanner sc;
        try {
            sc = new Scanner(new File("contestID_contestName.dat"));
            while (sc.hasNext()) {
                String[] split = sc.next().split("~");
                contestID.put(split[0], split[1]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contestID;
    }

    private static TreeSet<Problem> loadProblem() {
        TreeSet<Problem> problem = new TreeSet<>(new sortByCat());
        try {
            Scanner sc = new Scanner(new File("QBs.dat"));
            while (sc.hasNext()) {
                String[] split = sc.nextLine().split("~");
                problem.add(new Problem(split[0], split[1], split[2], split[3], split[4], Double.parseDouble(split[5]), split[6], split[7]));
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        return problem;
    }

    static String mail;
    static String user;

    private static boolean logIn() {
        boolean check = false;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Email: ");
            mail = sc.nextLine();
            System.out.print("Password: ");
            String pass = sc.nextLine();
            check = check(mail, pass);

            if (check) {
                System.out.println("Welcome back! ");
            } else {
                System.out.println("Check email or password!");
            }
        } while (!check);

        return check;
    }

    private static boolean check(String name, String pass) {
        HashMap<String, String> loginfo = new HashMap<>();
        try {
            Scanner sc1 = new Scanner(new File("contestant.dat"));
            while (sc1.hasNext()) {
                String[] split = sc1.nextLine().split("~");
                loginfo.put(split[2], split[split.length - 1]);
            }
            sc1.close();
        } catch (FileNotFoundException e) {
            System.out.println("File contestant.dat not found");
        }

        for (Contestant i : contestant) {
            if (i.getEmail().equals(mail)) {
                user = i.getName();
            }
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

    private static void generateContest() {
        String[] category = {"calculus", "geometry", "greedy", "dynamic", "graph"};
        Random rand = new Random();
        TreeSet<Problem> contest = new TreeSet<>(new sortByCat());
        TreeSet<Problem> cal = new TreeSet<>(new sortByCat());
        TreeSet<Problem> geo = new TreeSet<>(new sortByCat());
        TreeSet<Problem> gre = new TreeSet<>(new sortByCat());
        TreeSet<Problem> dyn = new TreeSet<>(new sortByCat());
        TreeSet<Problem> gra = new TreeSet<>(new sortByCat());
        
        System.out.println("Questions added to the test: ");
        cal.add(new Problem());
        geo.add(new Problem());
        gre.add(new Problem());
        dyn.add(new Problem());
        gra.add(new Problem());

        for (Problem pro : problem) {
            if (pro.getCategory().equalsIgnoreCase(category[0])) {
                cal.add(pro);
            } else if (pro.getCategory().equalsIgnoreCase(category[1])) {
                geo.add(pro);
            } else if (pro.getCategory().equalsIgnoreCase(category[2])) {
                gre.add(pro);
            } else if (pro.getCategory().equalsIgnoreCase(category[3])) {
                dyn.add(pro);
            } else if (pro.getCategory().equalsIgnoreCase(category[4])) {
                gra.add(pro);
            }
        }

        int[] ranNum = {rand.nextInt(cal.size()), rand.nextInt(geo.size()), rand.nextInt(gre.size()), rand.nextInt(dyn.size()), rand.nextInt(gra.size())};
        if (cal.size() > 1) {
            contest.add(take1Pro(cal, ranNum[0] != 0 ? ranNum[0] : 1));
        }
        if (geo.size() > 1) {
            contest.add(take1Pro(geo, ranNum[1] != 0 ? ranNum[1] : 1));
        }
        if (gre.size() > 1) {
            contest.add(take1Pro(gre, ranNum[2] != 0 ? ranNum[2] : 1));
        }
        if (dyn.size() > 1) {
            contest.add(take1Pro(dyn, ranNum[3] != 0 ? ranNum[3] : 1));
        }
        if (gra.size() > 1) {
            contest.add(take1Pro(gra, ranNum[4] != 0 ? ranNum[4] : 1));
        }

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy__hh_mm");
        String fileName = "Contest_" + formatter.format(date) + ".txt";
        String ContestID = "Test" + String.valueOf(1 + rand.nextInt(998));
        contestID.put(ContestID, fileName);
        System.out.println("Created a contest with ID: " + ContestID);
        try {
            File myfile = new File(fileName);
        
            if (myfile.createNewFile()) {
                try (FileWriter writer = new FileWriter(fileName)) {
                    writer.write("Contest\n\n");
                    writer.flush();
                    double sum = 0;
                    for (Problem pro : contest) {
                        writer.write(pro.toString() + "\n");
                        sum += pro.getMark_weight();
                    }
                    writer.write("\n\nAuthor: " + mail + "\tDate created: " + formatter.format(date) + "\n");
                    writer.flush();
                    writer.write("Total weight: " + sum + "\t" + "Contest ID: " + ContestID);
                }
            }
            try (FileWriter writer1 = new FileWriter("contestID_contestName.dat", true)) {
                writer1.write(ContestID + "~" + fileName + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    
    private static Problem take1Pro(TreeSet<Problem> a, int ranNum) {
        int i = 0;
        Problem prob = null;
        for (Problem pro : a) {
            if (i == ranNum) {
                System.out.println((pro));
                prob = pro;
            }
            i++;
        }
        return prob;

    }

    private static void printContest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Contest ID to find information: ");
        String contestId = sc.nextLine();
        String fileName = "";
        if (contestID.containsKey(contestId)) {
            try {
                for (Map.Entry<String, String> entry : contestID.entrySet()) {
                    if (entry.getKey().equals(contestId)) {
                        fileName = entry.getValue();
                    }
                }
                File myFile = new File(fileName);
                try (Scanner read = new Scanner(myFile)) {
                    System.out.println("");
                    while (read.hasNextLine()) {
                        System.out.println(read.nextLine());
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Contest file not found");
            }

        } else {
            System.out.println("Contest's ID does not exist!");
        }
    }

}

class sortByRoll implements Comparator<Contestant> {

    @Override
    public int compare(Contestant o1, Contestant o2) {
        String[] name1 = o1.getName().split(" ");
        String lastName1 = o1.getName().substring(0, o1.getName().length() - name1[name1.length - 1].length());
        String[] name2 = o2.getName().split(" ");
        String lastName2 = o2.getName().substring(0, o2.getName().length() - name2[name2.length - 1].length());

//        System.out.println(name1[name1.length - 1] + "- -" + lastName1);
//        System.out.println(name2[name2.length - 1] + "- -" + lastName2);
        if (o1.getId().compareTo(o2.getId()) != 0) {
            if (name1[name1.length - 1].compareTo(name2[name2.length - 1]) == 0) {
                if (lastName1.compareTo(lastName2) == 0) {
                    return o1.getId().compareTo(o2.getId());
                } else {
                    return lastName1.compareTo(lastName2);
                }
            } else {
                return name1[name1.length - 1].compareTo(name2[name2.length - 1]);
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
