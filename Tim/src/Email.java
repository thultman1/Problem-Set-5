import java.util.Scanner;
public class Email {
    private final String lastName;
    private final String firstName;
    private String password;
    private final String department;
    private String altEmail;
    private final String email;
    private final String companySuffix="aeycompany.com";
    private int mailboxCapacity=500;
    private final int defaultPasswordLength=10;

    public Email(String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;


        this.department=setDepartment();


        this.password=randomPassword(defaultPasswordLength);
        System.out.println("You password is: "+this.password);

        this.email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;


    }
    private String setDepartment(){
        System.out.print("New worker: " +firstName+". Department codes\n1 for sales\n2 for development\n3 for accounting\n0 for none\nEnter department code:");
        Scanner scan = new Scanner(System.in);
        int depChoice= scan.nextInt();
        if(depChoice==1) {
            return "sales";
        }
        else if (depChoice==2){
            return "development";
        }
        else if (depChoice==3){
            return "accounting";
        }
        else{
            return "";
        }
    }

    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password=new char[length];
        for(int i=0;i<length;i++){
            int rand =(int)(Math.random()*passwordSet.length());
            password[i]=passwordSet.charAt(rand);

        }
        return new String(password);

    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    public void changePassword(String password){
        this.password=password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAltEmail() {
        return altEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: "+firstName+" "+lastName+
                "\nCOMPANY EMAIL: "+email+
                "\nMAILBOX CAPACITY: "+mailboxCapacity+" mb";
    }
}
