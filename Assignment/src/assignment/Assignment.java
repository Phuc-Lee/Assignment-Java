package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Assignment {
    public static void main(String[] args) {
        boolean logIn = logIn();
        
        TreeSet<Problem> problem = new TreeSet<>(new sortByID());
        try {
            Scanner sc = new Scanner(new File("questionBank.dat"));
            while(sc.hasNext()){
                String[] split = sc.next().split("~");
                problem.add(new Problem());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Assignment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(logIn){
            System.out.println("hello");
            
        }
 
    }
    
    static boolean logIn(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("User name: ");
        String name = sc.nextLine();
        boolean checkName = check(name,'n');        
        System.out.print("Password: ");
        String pass = sc.nextLine();
        boolean checkPass = check(pass,'p');

        if(checkName && checkPass){
            System.out.println("Welcome back!");
            return true;
        }else{
            System.out.println("Check again username or password!");
            logIn();
        }
        return false;
    }
    
    static boolean check(String str, char a){
        HashMap<String, String> loginfo = new HashMap<>();
        try {
            Scanner sc1 = new Scanner(new File("contestant.dat"));
            while (sc1.hasNext()){
                String[] split = sc1.next().split("~");
                loginfo.put(split[0], split[1]);
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
                    return false;
                }
            }else if (a == 'p') {
                if (str.equals(ele.getValue())) {
                    i = true;
                } else {
                    return false;
                }
            }
        }
        
        return i;
    }

    
}


class sortByID implements Comparator<Problem>{
    @Override
    public int compare(Problem o1, Problem o2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
