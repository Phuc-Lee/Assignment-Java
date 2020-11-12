//package nhap;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Collection;
//import java.util.Comparator;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Random;
//import java.util.Scanner;
//import java.util.Set;
//import java.util.TreeSet;
//
//public class Assignment {
//
//    static TreeSet<Problem> problem;
//    static TreeSet<Contestant> contestant;
//
//    public static void main(String[] args) throws IOException {
//        problem = loadProblem();
//        contestant = loadContestant();
//        boolean logIn = logIn();
//
//        Scanner sc = new Scanner(System.in);
//        int choice;
//
//        while (logIn) {
//            System.out.println("\n----------------\nPlease choose your option:");
//            System.out.println("\t0. Log out and quit");
//            System.out.println("\t1. Change your infomation ");
//            System.out.println("\t2. Add a new question ");
//            System.out.println("\t3. Update problem ");
//            System.out.println("\t4. Available problems ");
//            System.out.println("\t5. Generate a contest ");
//            System.out.println("\t6. Print information of a contest");
//
//            choice = sc.nextInt();
//
//            switch (choice) {
//                case 1:
//                    FileWriter writerCT = new FileWriter("contestant.dat");
//                    for (Contestant i : contestant) {
////                        System.out.println(i);
//                        if (i.getEmail().equals(mail)) {
//                            i.changeInfor();
//                            System.out.println("Your information has been changed: ");
//                            System.out.println(i);
//                            break;
//                        }
//                    }
//                    for (Contestant i : contestant) {
////                        System.out.println(i);
//                        try {
//                            writerCT.write(i.getName() + "~" + i.getId() + "~" + i.getEmail() + "~" + i.getMobilephone()
//                                    + "~" + String.valueOf(i.getRank()) + "~" + i.getPassword() + "\n");
//                            writerCT.flush();
//                        } catch (IOException ex) {
//                            System.out.println("File does not exist");
//                        }
//                    }
//                    writerCT.close();
//                    break;
//
//                case 2:
//                    FileWriter writerQS = new FileWriter("QBs.dat");
//                    Problem e = new Problem();
//                    e.addQues();
//                    problem.add(e);
//                    try {
//                        for (Problem i : problem) {
//                            writerQS.write(i.getProblemID() + "~" + i.getCategory() + "~" + i.getAuthor() + "~" + i.getDate() + "~" + i.getName()
//                                    + "~" + String.valueOf(i.getMark_weight()) + "~" + i.getShort_decrip() + "~" + i.getLong_decrip() + "\n");
//                        }
//                        writerQS.flush();
//                    } catch (IOException ex) {
//                        System.out.println("File does not exist");
//                    }
//                    writerQS.close();
//                    break;
//
//                case 3:
//                    
//                    System.out.print("Problem ID : ");
//                    Scanner scan = new Scanner(System.in);
//                    String qsId = scan.nextLine();
//
//                    for (Problem e1 : problem) {
//                        if (e1.getProblemID().equals(qsId)) {
//                            e1.updateQues();
//                            System.out.println(e1);
//                        }
//                    }
//                    
//                    FileWriter writerQS1 = new FileWriter("QBs.dat");
//                    for (Problem em1 : problem) {
////                        System.out.println(em1);
//                        try {
//                            writerQS1.write(em1.getProblemID() + "~" + em1.getCategory() + "~" + em1.getAuthor() + "~" + em1.getDate() + "~" + em1.getName() + "~" + em1.getMark_weight() + "~" + em1.getShort_decrip() + "~" + em1.getLong_decrip() + "\n");
//                            writerQS1.flush();
//                        } catch (IOException ex) {
//                            System.out.println("File does not exist");
//                        }
//                    }
//                    writerQS1.close();
//                    break;
//
//                case 4:
//                    listAllProb(problem);
//                    break;
//
//                case 5:
//                    generateContest();
//                    break;
//
//                case 6:
////                    PrintContest();
//                    break;
//            }
//            if (choice == 0) {
//                System.out.println("\nSee you soon!");
//                sc.close();
//                break;
//            }
//        }
//    }
//
//    private static void listAllProb(TreeSet<Problem> a) {
//        Iterator<Problem> iter = a.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
//        System.out.println("\n");
//    }
//
//    private static TreeSet<Contestant> loadContestant() {
//        contestant = new TreeSet<>(new sortByRoll());
//        try {
//            Scanner sc = new Scanner(new File("contestant.dat"));
//            while (sc.hasNext()) {
////                System.out.println(sc.next());
//                String[] split = sc.nextLine().split("~");
////                System.out.println(split.length);
////                for(String i: split){
////                    System.out.print(i + " ");
////                    System.out.println("");
////                }
//                contestant.add(new Contestant(split[0], split[1], split[2], split[3], Integer.parseInt(split[4]), split[5]));
//            }
//            sc.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println("File not found");
//        }
////        for (Contestant i : contestant) {
////            System.out.print(i + " ");
////            System.out.println("");
////        }
//        return contestant;
//    }
//
//    private static TreeSet<Problem> loadProblem() {
//        TreeSet<Problem> problem = new TreeSet<>(new sortByCat());
//        try {
//            Scanner sc = new Scanner(new File("QBs.dat"));
//            while (sc.hasNext()) {
//                String[] split = sc.nextLine().split("~");
//                problem.add(new Problem(split[0], split[1], split[2], split[3], split[4], Double.parseDouble(split[5]), split[6], split[7]));
//            }
//            sc.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println("File not found");
//        }
//        return problem;
//    }
//
//    static String mail;
//    static String user;
//
//    private static boolean logIn() {
//        boolean check = false;
//
//        do {
//            Scanner sc = new Scanner(System.in);
//            System.out.print("Email: ");
//            mail = sc.nextLine();
//            System.out.print("Password: ");
//            String pass = sc.nextLine();
//            check = check(mail, pass);
//
//            if (check) {
//                System.out.println("Welcome back! ");
//            } else {
//                System.out.println("Check email or password!");
//            }
//        } while (!check);
//
//        return check;
//    }
//
//    private static boolean check(String name, String pass) {
//        HashMap<String, String> loginfo = new HashMap<>();
//        try {
//            Scanner sc1 = new Scanner(new File("contestant.dat"));
//            while (sc1.hasNext()) {
//                String[] split = sc1.nextLine().split("~");
//                loginfo.put(split[2], split[split.length - 1]);
//            }
//            sc1.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("File contestant.dat not found");
//        }
//
//        for (Contestant i : contestant) {
//            if (i.getEmail().equals(mail)) {
//                user = i.getName();
//            }
//        }
//
//        for (Map.Entry ele : loginfo.entrySet()) {
//            if (name.equals(ele.getKey())) {
//                if (pass.equals(ele.getValue())) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    private static void generateContest() {
//        String[] category = {"calculus", "geometry", "greedy", "dynamic", "graph"};
//        Random rand = new Random();
//        TreeSet<Problem> contest = new TreeSet<>(new sortByCat());
//        TreeSet<Problem> cal = new TreeSet<>(new sortByCat());
//        TreeSet<Problem> geo = new TreeSet<>(new sortByCat());
//        TreeSet<Problem> gre = new TreeSet<>(new sortByCat());
//        TreeSet<Problem> dyn = new TreeSet<>(new sortByCat());
//        TreeSet<Problem> gra = new TreeSet<>(new sortByCat());
//
//        cal.add(new Problem());
//        geo.add(new Problem());
//        gre.add(new Problem());
//        dyn.add(new Problem());
//        gra.add(new Problem());
//
//        for (Problem pro : problem) {
//            if (pro.getCategory().equals(category[0])) {
//                cal.add(pro);
//            } else if (pro.getCategory().equals(category[1])) {
//                geo.add(pro);
//            } else if (pro.getCategory().equals(category[2])) {
//                gre.add(pro);
//            } else if (pro.getCategory().equals(category[3])) {
//                dyn.add(pro);
//            } else if (pro.getCategory().equals(category[4])) {
//                gra.add(pro);
//            }
//        }
//
//        int[] ranNum = {rand.nextInt(cal.size()), rand.nextInt(geo.size()), rand.nextInt(gre.size()), rand.nextInt(dyn.size()), rand.nextInt(gra.size())};
//        if (cal.size() > 1) {
//            contest.add(take1Pro(cal, ranNum[0] != 0 ? ranNum[0] : 1));
//        }
//        if (geo.size() > 1) {
//            contest.add(take1Pro(geo, ranNum[1] != 0 ? ranNum[1] : 1));
//        }
//        if (gre.size() > 1) {
//            contest.add(take1Pro(gre, ranNum[2] != 0 ? ranNum[2] : 1));
//        }
//        if (dyn.size() > 1) {
//            contest.add(take1Pro(dyn, ranNum[3] != 0 ? ranNum[3] : 1));
//        }
//        if (gra.size() > 1) {
//            contest.add(take1Pro(gra, ranNum[4] != 0 ? ranNum[4] : 1));
//        }
//
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");
////        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy   hh/mm/ss");
//        String fileName = "Contest_" + formatter.format(date) + ".txt";
//        int ContestID = (1 + rand.nextInt(999));
//        try {
//            File myfile = new File(fileName);
//            if (myfile.createNewFile()) {
//                FileWriter writer = new FileWriter(fileName);
//                writer.write("Contest\n\n");
//                writer.flush();
//                double sum = 0;
//                for (Problem pro : contest) {
//                    writer.write(pro.toString() + "\n");
//                    sum += pro.getMark_weight();
//                }
//                writer.write("\n\nAuthor: " + mail + "\tDate created: " + formatter.format(date) + "\n");
//                writer.flush();
//                writer.write("Total weight: " + sum + "\t" + "Contest ID: " + ContestID);
//                writer.close();
//            }
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
////        try {
////            FileWriter writeContest = new FileWriter("allContest.dat", true);
////            writeContest.write(fileName + "~" + "Contest ID: " + Integer.toString(ContestID) + "\n");
////            writeContest.flush();
////            writeContest.close();
////        } catch (IOException e) {
////            System.out.println(e.getMessage());
////        }
//    }
//
////    static void PrintContest() {
////        TreeSet<Problem> ContestProblem = new TreeSet<>(new sortByCat());
////        HashMap<String, String> contest = new HashMap<String, String>();
////        Scanner sc = new Scanner(System.in);
////        System.out.print("Contest ID: ");
////        String id = sc.nextLine();
////        String Id = "ContestID" + id;
////        try {
////            Scanner scC = new Scanner(new File("allContest.txt"));
////            while (scC.hasNext()) {
////                String[] split = sc.nextLine().split("~");
////                contest.put(split[1], split[0]);
////            }
////            sc.close();
////        } catch (FileNotFoundException ex) {
////            System.out.println("File not found");
////        }
////        for (Map.Entry<String, String> entry : contest.entrySet()) {
////            String key = entry.getKey();
////            String value = entry.getValue();
////            if (Id.equals(entry.getKey())) {
////                File readContest = new File(entry.getValue());
////                try {
////                    Scanner sc1 = new Scanner(readContest);
////                    while (sc1.hasNext()) {
////                        String[] split = sc.nextLine().split("~");
////                        ContestProblem.add(new Problem(split[0], split[1], split[2], split[3], split[4], Double.parseDouble(split[5]), split[6], split[7]));
////                    }
////                    sc.close();
////                } catch (FileNotFoundException ex) {
////                    System.out.println("File not found");
////                }
////                for (Problem problem1 : ContestProblem) {
////                    System.out.println(problem1);
////                }
////            }
////        }
////    }
//
//    private static Problem take1Pro(TreeSet<Problem> a, int ranNum) {
//        int i = 0;
//        Problem prob = null;
//        for (Problem pro : a) {
//            if (i == ranNum) {
//                System.out.println((pro));
//                prob = pro;
//            }
//            i++;
//        }
//        return prob;
//
//    }
//
//}
//
//class sortByRoll implements Comparator<Contestant> {
//
//    @Override
//    public int compare(Contestant o1, Contestant o2) {
//        String[] name1 = o1.getName().split(" ");
//        String lastName1 = name1[0] + " " + name1[1];
//        String[] name2 = o2.getName().split(" ");
//        String lastName2 = name2[0] + " " + name2[1];
//
//        if (o1.getId().compareTo(o2.getId()) != 0) {
//            if (name1[2].compareTo(name2[2]) == 0) {
//                if (lastName1.compareTo(lastName2) == 0) {
//                    return o1.getId().compareTo(o2.getId());
//                } else {
//                    return lastName1.compareTo(lastName2);
//                }
//            } else {
//                return name1[2].compareTo(name2[2]);
//            }
//        }
//        return 0;
//    }
//}
//
//class sortByCat implements Comparator<Problem> {
//
//    @Override
//    public int compare(Problem o1, Problem o2) {
//        if (o1.getCategory().compareTo(o2.getCategory()) == 0) {
//            return o1.getProblemID().compareTo(o2.getProblemID());
//        } else {
//            return o1.getCategory().compareTo(o2.getCategory());
//        }
//    }
//}
