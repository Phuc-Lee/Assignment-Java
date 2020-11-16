package assignment;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Problem {

    private String problemID;
    private String category;
    private String author;
    private String date;
    private String name;
    private double mark_weight;
    private String short_decrip;
    private String long_decrip;

//    private double total_mark;
    public Problem() {
        this.problemID = "0";
        this.date = "0";
        this.name = "0";
        this.short_decrip = "0";
        this.long_decrip = "0";
        this.mark_weight = 0;
        this.category = "0";
        this.author = "0";
    }

    public Problem(String problemID) {
        this.problemID = problemID;
        this.date = "0";
        this.name = "0";
        this.short_decrip = "0";
        this.long_decrip = "0";
        this.mark_weight = 0;
        this.category = "0";
        this.author = "0";
    }

    public Problem(String problemID, String category, String author, String date, String name, double mark_weight, String short_decrip, String long_decrip) {
        this.problemID = problemID;
        this.date = date;
        this.name = name;
        this.short_decrip = short_decrip;
        this.long_decrip = long_decrip;
        this.mark_weight = mark_weight;
        this.category = category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase();
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_decrip() {
        return short_decrip;
    }

    public void setShort_decrip(String short_decrip) {
        this.short_decrip = short_decrip;
    }

    public String getLong_decrip() {
        return long_decrip;
    }

    public void setLong_decrip(String long_decrip) {
        this.long_decrip = long_decrip;
    }

    public double getMark_weight() {
        return mark_weight;
    }

    public void setMark_weight(double mark_weight) {
        this.mark_weight = mark_weight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProblemID() {
        return problemID;
    }

    public void setProblemID(String problemID) {
        this.problemID = problemID;
    }

    public double getTotal_mark(List<Problem> qs) {
        double total_mark = 0;
        for (int i = 0; i < qs.size(); i++) {
            total_mark += qs.get(i).mark_weight;
        }
        return total_mark;
    }

    public void Sort(List<Problem> qs) {
        Collections.sort(qs, new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2) {
                if (o1.getCategory().compareTo(o2.getCategory()) > 0) {
                    return 1;
                }
                if (o1.getCategory().compareTo(o2.getCategory()) < 0) {
                    return -1;
                } else {
                    if (o1.getProblemID().compareToIgnoreCase(o2.getProblemID()) > 1) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }

        });
    }

    @Override
    public String toString() {
        return "problemID=" + problemID + ", category=" + category + ", author=" + author + ", date=" + date + ", name=" + name + ", mark_weight=" + mark_weight + ", short_decrip=" + short_decrip + ", long_decrip=" + long_decrip;
    }

    public void addQues() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc1 = new Scanner(System.in);
        String time = formatter.format(date);
        System.out.println("Question's Date: " + time);
        setDate(time);
        Random ran = new Random();
        int a = (int) Math.floor(Math.random() * 899 + 100);
        String qs = "QS" + Integer.toString(a);
        setProblemID(qs);

        setAuthor(assignment.Main.mail);

        System.out.print("Question's Name : ");
        String name;
        do {
            name = sc1.nextLine();
            if (!checkNull(name)) {
                System.out.print("Invalid! Re-enter: ");
            }
        } while (!checkNull(name));
        setName(name);

        System.out.print("Category: ");
        String category;
        do {
            category = sc1.nextLine();
            if (checkNull(category)) {
                System.out.print("Invalid! Re-enter: ");
            }
        } while (!checkNull(category));
        setCategory(category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase());

        Scanner sc2 = new Scanner(System.in);
        System.out.print("Markweight : ");
        String weight;
        do {
            weight = sc2.nextLine();
            if (!checkValid(weight)) {
                System.out.print("Invalid! Re-enter: ");
            }
        } while (!checkValid(weight));
        setMark_weight(Double.parseDouble(weight));

        System.out.print("Short decription : ");
        String shortDes;
        do {
            shortDes = sc1.nextLine();
            if (!checkNull(shortDes)) {
                System.out.print("Invalid! Re-enter: ");
            }
        } while (!checkNull(shortDes));
        setShort_decrip(shortDes);

        System.out.print("Long decription : ");
        String longDes;
        do {
            longDes = sc1.nextLine();
            if (!checkNull(longDes)) {
                System.out.print("Invalid! Re-enter: ");
            }
        } while (!checkNull(longDes));
        setLong_decrip(longDes);
    }

    public void updateQues() {
        System.out.println("Change problem's information ");
        System.out.println("If you want to change, enter new information. If not, press enter");
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc1 = new Scanner(System.in);
        String time = formatter.format(date);
        System.out.println("Question's Date : " + time);
        setDate(time);

        System.out.println("Current name: " + getName());
        System.out.print("Question's Name : ");
        String name;
        name = sc1.nextLine();
        if (checkNull(name)) {
            setName(name);
        }

        System.out.println("Current category: " + getCategory());
        System.out.print("Category: ");
        String category = sc1.nextLine();
        if (checkNull(category)) {
            setCategory(category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase());
        }

        setAuthor(Main.mail);

        System.out.println("Current markweight: " + getMark_weight());
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Markweight : ");
        String weight = sc2.nextLine();
        if (checkNull(weight)) {
            setMark_weight(Double.parseDouble(weight));
        }

        System.out.println("Current short description: " + getShort_decrip());
        System.out.print("Short description : ");
        String shortDes = sc1.nextLine();
        if (checkNull(shortDes)) {
            setShort_decrip(shortDes);
        }

        System.out.println("Current long description: " + getLong_decrip());
        System.out.print("Long decription : ");
        String longDes = sc1.nextLine();
        if (checkNull(longDes)) {
            setLong_decrip(longDes);
        }
    }

    private boolean checkValid(String weight) {
        try {
            double dbForm = Double.parseDouble(weight);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean checkNull(String a) {
        if (a.length() < 1) {
            return false;
        }
        return true;
    }
}
