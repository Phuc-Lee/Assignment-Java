package assignment;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
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
    }

    public Problem(String problemID, String category, String author, String date, String name, double mark_weight, String short_decrip, String long_decrip) {
        this.problemID = problemID;
        this.date = date;
        this.name = name;
        this.short_decrip = short_decrip;
        this.long_decrip = long_decrip;
        this.mark_weight = mark_weight;
        this.category = category;
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

//    public void setTotal_mark(double total_mark) {
//        this.total_mark = total_mark;
//    }
    @Override
    public String toString() {
        return "problemID=" + problemID + ", category=" + category + ", author=" + author + ", date=" + date + ", name=" + name + ", mark_weight=" + mark_weight + ", short_decrip=" + short_decrip + ", long_decrip=" + long_decrip + "\n";
    }

    public void addQues() {
        Date date = new Date();
        System.out.println("Question's Date : " + date.toString());

        Scanner sc1 = new Scanner(System.in);
        System.out.print("Question's Name : ");
        setName(sc1.nextLine());

        Scanner sc = new Scanner(System.in);
        System.out.print("Category : ");
        setName(sc.nextLine());

        Scanner sc2 = new Scanner(System.in);
        System.out.print("Short decription : ");
        setShort_decrip(sc2.nextLine());
        
        Scanner sc3 = new Scanner(System.in);
        System.out.print("Long decription : ");
        setLong_decrip(sc3.nextLine());
        
        Scanner sc4 = new Scanner(System.in);
        System.out.print("Markweight : ");
        setMark_weight(sc4.nextDouble());
        
        Scanner sc5 = new Scanner(System.in);
        System.out.print("Author : ");
        setAuthor(sc5.nextLine());
    }

//    public void updateQues() {
//        Date date = new Date();
//        System.out.print("Question's Date : " + date.toString());
//        Scanner sc1 = new Scanner(System.in);
//        System.out.print("Question's Name : ");
//        setName(sc1.nextLine());
//        Scanner sc2 = new Scanner(System.in);
//        System.out.print("Short decription : ");
//        setShort_decrip(sc2.nextLine());
//        Scanner sc3 = new Scanner(System.in);
//        System.out.print("Long decription : ");
//        setLong_decrip(sc3.nextLine());
//        Scanner sc4 = new Scanner(System.in);
//        System.out.print("Markweight : ");
//        setMark_weight(sc4.nextDouble());
//        Scanner sc5 = new Scanner(System.in);
//        System.out.print("Author : ");
//        setAuthor(sc5.nextLine());
//    }

}
