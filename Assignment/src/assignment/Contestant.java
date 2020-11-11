package assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Contestant {
    private String name;
    private String id;
    private String email;
    private String mobilephone;
    private int rank;
    private String password;

    public Contestant() {
        this.name = "Unknown";
        this.email = "Unknown";
        this.id = "Unkonwn";
        this.password = "Unknown";
        this.rank = 0;
        this.mobilephone = "Unknown";
    }

    public Contestant(String name, String id, String email, String mobilephone, int rank, String Password) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.mobilephone = mobilephone;
        this.rank = rank;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Contestant{" + "name=" + name + ", id=" + id + ", email=" + email + ", mobilephone=" + mobilephone + ", rank=" + rank + ", password=" + password + '}';
    }

    public void changeInfor() throws FileNotFoundException, IOException {
//        FileInputStream fis = new FileInputStream("Contestant.dat");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        while(true){
//        try {
//            Contestant pX = (Contestant)ois.readObject();
//            if(pX.getEmail().equals(o.getEmail())){}
//        } catch (IOException | ClassNotFoundException e ) {
//        }
//        }

        System.out.println("Change contestant's information ");
        Scanner sc = new Scanner(System.in);
        
        System.out.print("New name: ");
        String name1 = sc.nextLine(); 
        setName(name1) ;
        
        System.out.print("New email: ");
        String mail = sc.nextLine();
        setEmail(mail) ;

        System.out.print("New mobilePhone: ");
        String phone;
        do{
            phone = sc.nextLine();
        }while(!checkValidation(phone, 'h'));
        setMobilephone(phone);

        System.out.print("New password (must be longer than 8 charaters): ");
        String pass;
        do{
            pass = sc.nextLine();
        }while(!checkValidation(pass,'a'));
        setPassword(pass);
        
        
//        try {
//            File f = new File("contestant.dat");
//            FileOutputStream fos = new FileOutputStream(f);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
////            oos.writeObject(p1);
//            oos.flush();
//            oos.close();
//            fos.close();
//        } catch (IOException e) {
//        }
    }
    
    private boolean checkValidation(String str, char type){
        if(type == 'a'){
            if(str.length() < 8 || str.length() > 32){
                return false;
            }
        }else if(type == 'h'){
            if(str.length() != 10){
                return false;
            }
            
            try{
                int intForm = Integer.parseInt(str);
            }catch(NumberFormatException e){
                return false;                
            }
        }
        return true;
    }
}
