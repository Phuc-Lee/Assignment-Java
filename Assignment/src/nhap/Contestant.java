package nhap;

//import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        this.id = "Unknown";
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
        this.password = Password;
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

        System.out.println("Change contestant's information ");
        Scanner sc = new Scanner(System.in);

        System.out.print("New name: ");
        String Name;
        do {
            Name = sc.nextLine();
        } while (!checkValidation(Name, 'n'));
        setName(Name.toUpperCase());

        System.out.print("New email: ");
        String mail;
        do {
            mail = sc.nextLine();
        } while (!checkValidation(mail, 'm'));
        setEmail(mail);

        System.out.print("New mobilePhone: ");
        String phone;
        do {
            phone = sc.nextLine();
        } while (!checkValidation(phone, 'h'));
        setMobilephone(phone);

        System.out.print("New password (must be longer than 7 and less that 33 charaters): ");
        String pass;
        do {
            pass = sc.nextLine();
        } while (!checkValidation(pass, 'a'));
        setPassword(pass);
    }

    private boolean checkValidation(String str, char type) {
        switch (type) {
            case 'a':
                if (str.length() < 8 || str.length() > 32) {
                    System.out.print("Password must > 7 and < 32 characters: ");
                    return false;
                }
                break;
            case 'h':
                if (str.length() != 10) {
                    System.out.print("Phone number must have 10 numbers: ");
                    return false;
                }
                try {
                    int intForm = Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    return false;
                }
                break;
            case 'n':
                String[] checkName;
                checkName = str.split(" ");
                if (checkName.length == 1) {
                    System.out.print("You must enter your fullname:");
                    return false;
                }
                break;
            case 'm':
                if (str.contains("@fpt.edu.vn") == false) {
                    System.out.print("Email is not valid (missing @fpt.edu.vn)! Re-enter:");
                    return false;
                }
                break;
            default:
                break;
        }
        return true;
    }
}
