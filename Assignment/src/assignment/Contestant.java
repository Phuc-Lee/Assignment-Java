package assignment;

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

    public void changeInfor() {
        System.out.println("Change contestant's information ");
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Name: ");
        String name = sc.nextLine(); 
        setName(name) ;
        
        System.out.print("Email: ");
        String mail = sc.nextLine();
        setEmail(mail) ;

        System.out.print("MobilePhone: ");
        String phone;
        do{
            phone = sc.nextLine();
        }while(!checkValidation(phone, 'h'));
        setMobilephone(phone);

        System.out.print("Password (must be longer than 8 charaters): ");
        String pass;
        do{
            pass = sc.nextLine();
        }while(!checkValidation(pass,'a'));
        setPassword(pass);
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
