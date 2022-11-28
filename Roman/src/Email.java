import java.util.Scanner;

public class Email {
    private final String firstName;
    private final String lastName;
    private String password;
    private final String dept;
    private int mailboxCap = 500;
    private String altEmail;
    private final String email;
    private final String companySuffix = "aeycompany.com";
    private final int defaultPasswordLength = 10;

    // Constructor receives first name and last name

    public Email (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.dept = setDept();

        this.password = setRanPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + dept + "." + companySuffix;
    }

    // Ask for department

    private String setDept() {
        System.out.print("New worker: " + firstName + ". Enter Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n" +
                "Enter department code: ");
        Scanner sc = new Scanner(System.in);
        int deptChoice = sc.nextInt();

        if (deptChoice == 1) {
            return "sales";
        } else if (deptChoice == 2) {
            return "dev";
        } else if (deptChoice == 3) {
            return "acct";
        } else {
            return "";
        }

    }

    // Generate random password

    private String setRanPassword (int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());    // random between 0 - 1
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCap = capacity;
    }

    // Set alternate email
    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCap;
    }
    public String getAlternateEmail() {
        return altEmail;
    }
    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: " + mailboxCap + "MB";
    }

}
