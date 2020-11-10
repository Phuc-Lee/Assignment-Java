package generateData;

import assignment.Contestant;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.TreeSet;

public class GenerateData {

    public static void main(String[] args) throws IOException {
        String[] ho = {"Le", "Nguyen", "Ho", "Dinh", "Bui", "Do", "Phan", "Pham", "Hoang", "Trinh",};
        String[] dem = {"Hoang", "Anh", "Quoc", "Manh", "Tien", "Thu", "Minh", "Thi", "Van", "Thanh"};
        String[] ten = {"Nhi", "Anh", "Phuc", "Trang", "Lan", "Tien", "Thu", "Minh", "Lam", "Tra", "Hai", "Ha", "Hanh", "Tam", "Thuy", "Phong", "Vu", "Hieu", "Trung"};
        String[] roll = {"HE", "SE", "MK", "EN", "IA", "AI"};

        TreeSet<Contestant> lst = new TreeSet<>();
        Random ran = new Random();
        FileWriter writer = new FileWriter(new File("contestant.dat"));
        for (int i = 0; i < 100; i++) {
            String a = ho[ran.nextInt(ho.length)];
            String b = dem[ran.nextInt(dem.length)];
            String c = ten[ran.nextInt(ten.length)];
            String fullName = (a + " " + b + " " + c).toUpperCase();
            String shortName = (c + a.charAt(0) + b.charAt(0)).toLowerCase();
            String number = "";
            String fone = "0";
            for (int j = 0; j < 9; j++) {
                if (j < 6) {
                    number += String.valueOf(ran.nextInt(9));
                }
                fone += String.valueOf(ran.nextInt(9));
            }
            String rollNum = roll[ran.nextInt(roll.length)] + number;
            String mail = shortName + rollNum.toLowerCase() + "@fpt.edu.vn";
            try {

                writer.write(fullName + "~" + rollNum + "~" + mail + "~" + fone + "~" + 0 + "~" + "0" + "\n");
                writer.flush();
                
            } catch (IOException ex) {
                System.out.println("File does not exist");
            }
        }
        writer.close();
    }
}
