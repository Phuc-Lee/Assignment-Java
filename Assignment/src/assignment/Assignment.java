package assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Assignment {
    public static void main(String[] args) {
        boolean logIn = logIn();
        
        if(logIn)
        
        try {
            FileWriter writeToFile  = new FileWriter("questionBank.dat",true);  // true is for appending to the end of the file
            writeToFile.append("This is a test for reading and writing file!\n");
            writeToFile.close();
            String[] lines = Files.readAllLines(new File("questionBank.dat").toPath()).toArray(new String[0]);
            
        } catch (IOException ex) {
            System.out.println("You have not put question bank file!");
        }
    }
    
    static boolean logIn(){
        Scanner sc = new Scanner(System.in);
        System.out.print("User name: ");
        String name = sc.next();
        boolean checkName = checkName(name);
        System.out.print("Password: ");
        String pass = sc.nextLine();
        boolean checkPass = checkPass(pass);
        if(!checkName){
            System.out.println("Your user name does not exist. Would you like to sign in? (y/n)");
            String choice = sc.next();
            if(choice.equals("y")){
                signIn();
            }else{
                logIn();
            }
        }
        if(checkName && checkPass){
            System.out.println("Welcome back!");
            return true;
        }else{
            logIn();
        }
        return false;
    }
    
    static void signIn(){
        
    }
    
    static boolean checkName(String name){
        return true;
    }
    
    static boolean checkPass(String pass){
        return true;
    }
}
