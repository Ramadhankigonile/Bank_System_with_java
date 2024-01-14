import java.util.*;
import java.text.DecimalFormat;



public class BankApplication {

    public static void main(String[] args) {


// try and catch statements to control an exception frm users while entering wrong inputs..
try {
        BankAccountt obj = new BankAccountt("","");
        obj.showMenu();
     
} catch (Exception e) {

    // TODO: handle exception

    System.out.println("something went wrong try again");

}
    }
}


// concrete methods for definitions of all abstract methods inherited from ATM interface
class BankAccountt implements ATM { 
    
    Scanner scanner = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("###0.00Tzs");

    int balance;
    int previousTransactions;
    String customerName;
    String customerId;

    BankAccountt(String cname, String cId) {

        customerName = cname;
        customerId = cId;

    }

    public void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransactions = amount;
        }
    }

    public void withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            previousTransactions = - amount;
        }
    }

    public void getPreviousTransactions() {
        if (previousTransactions > 0) {

            System.out.println("Deposited:" + previousTransactions);

        } else if (previousTransactions < 0) {

            System.out.println("Withdrawn:" + Math.abs(previousTransactions));

        } else {

            System.out.println("No transactions occured");
        }

    }


    public void showMenu() {
        int choice;
        System.out.println("DIGITAL-PESA FASTA BANK");
        System.out.println();
        System.out.print("Enter Your Account Name: ");
        customerName = scanner.nextLine();
        System.out.println();
        System.out.print("Enter Your Card ID: ");
        customerId = scanner.nextLine();
        System.out.println();
        
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID " + customerId);
        System.out.println();
        System.out.println("1. Check Balance");
        System.out.println("2.Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Previous Transactions");
        System.out.println("5. Exit");

        do {
            System.out.println("================================================");
            System.out.print("enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("================================================");
                    System.out.println("balance =" + df.format(balance));
                    System.out.println("--------------------------------");

                    break;
                case 2:
                    System.out.println("================================================");
                    System.out.println("enter the amount to Deposit");
                    System.out.println("--------------------------------");
                    int amount = scanner.nextInt();
                    df.format(amount);                
                    deposit(amount);

                  break;

                case 3:
                    System.out.println("================================================");
                    System.out.println("enter the amount to withdraw");
                    System.out.println("--------------------------------");
                    int amount2 = scanner.nextInt();
                    df.format(amount2);
                    withdraw(amount2);

                    break;

                case 4:
                    System.out.println("--------------------------------");
                    getPreviousTransactions();
                    System.out.println("--------------------------------");

                    break;

                case 5:

                    System.out.println("********************************");

                    break;
                    
                default:

                    System.out.println("invalid choice please try again");
                    

                    break;
            }

        }
        while (choice != 5);
        
        System.out.println("Thanks for using our Services");


    }
}
