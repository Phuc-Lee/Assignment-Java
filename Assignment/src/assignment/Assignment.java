package assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Assignment {
    public static void main(String[] args) {
        try {
            FileWriter writeToFile  = new FileWriter("questionBank.dat",true);  // true is for appending to the end of the file
            writeToFile.append("This is a test for reading and writing file!\n");
            writeToFile.close();
            String[] lines = Files.readAllLines(new File("questionBank.dat").toPath()).toArray(new String[0]);
            System.out.println(lines.length);
            for(String i: lines){
                System.out.println(i);
            }
        } catch (IOException ex) {
            System.out.println("You have not put question bank file!");
        }
    }
    
}
