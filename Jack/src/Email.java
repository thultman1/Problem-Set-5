
import java.util.Scanner;

public class Email {
    private final String firstName;
    private final String lastName;
    private String password;
    private final String department;
    private final String email;
    private int mailboxCapacity = 500;
    private final int defaultPasswordLength = 10;
    private String alternateEmail;
    private final String companySuffix = "company.com";

    //set up constructor to take in first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartmemt();
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your Password is: " + this.password  );

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;



    }
    public String setDepartmemt() {
        System.out.println("New Worker: " + firstName + ". Department Codes:\n1 for Sales \n2 for Development \n3 for Accounting \n0 for none \n Enter Department Code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        }
        else if (depChoice == 2) {
            return "dev";
        }
        else if (depChoice == 3) {
            return "acct";
        }
        else {
            return "";
        }
    }
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    public void changePassword(String password) {
        this.password = password;
    }
    public int  getMailboxCapacity()  {
        return mailboxCapacity;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword() {
        return password;
    }
    public String showInfo() {
        return "Display Name:" + firstName + " " + lastName +
                "\n Company Email: " + email + " \n Mailbox Capacity: " + mailboxCapacity + "mb";
    }
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@$%^&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }



}



