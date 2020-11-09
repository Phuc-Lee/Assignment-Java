package assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Assignment {
    public static void main(String[] args) {
        boolean logIn = logIn();
        
        if(logIn){
            System.out.println("hello");
        }
        
//        try {
//            FileWriter writeToFile  = new FileWriter("questionBank.dat",true);  // true is for appending to the end of the file
//            writeToFile.append("This is a test for reading and writing file!\n");
//            writeToFile.close();
//            String[] lines = Files.readAllLines(new File("questionBank.dat").toPath()).toArray(new String[0]);
//            
//        } catch (IOException ex) {
//            System.out.println("You have not put question bank file!");
//        }
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
        } catch (Exception e) {
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
