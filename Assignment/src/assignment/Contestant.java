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
    }

    public Contestant(String name, String id, String email, String mobilephone, int rank) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.mobilephone = mobilephone;
        this.rank = rank;
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

//    @Override
//    public String toString() {
//        return "Contestant{" + "name=" + name + ", id=" + id + ", email=" + email + ", mobilephone=" + mobilephone + ", rank=" + rank + '}';
//    }
    public void changeInfor() {
        System.out.println("Change contestant's information ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Name : ");
        String newName = sc.nextLine();
        System.out.println("Email : ");
        String newEmail = sc.nextLine();
        System.out.println("MobilePhone : ");
        int newPhone = sc.nextInt();
        while(newPhone <= 1000000000 || (newPhone / 1000000000) > 100){
            System.out.println("Invalid Phone Number , please re-enter :");
            newPhone = sc.nextInt();
        }
        System.out.println("Password : ");
        String newPass = sc.nextLine();
    }
}
