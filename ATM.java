package Banking;
import java.util.Scanner;

public class ATM{
    public static void main(String [] args){
        login();
    }

    static Integer balance = 10000;
    static Integer choice = 0;
    static Scanner input = new Scanner(System.in); 

    public static void setBalance(Integer balance) {
        ATM.balance = balance;
    }

    public static Integer getBalance() {
        return balance;
    }
    

    private static void login() {
        Integer ACCOUNTNO = 2023;
        Integer PIN = 0000;

        System.out.println("\t\t\tONLINE BANKING SYSTEM\n\t\t\t\tPLEASE LOGIN TO CONTINUE...");
        System.out.println("\t\t\t1. Enter Account Number: ");
        ACCOUNTNO = input.nextInt();
        if(ACCOUNTNO == 2023){
            System.out.println("\t\t\t1. Enter Pin: ");
            PIN = input.nextInt();
            if(PIN == 0000){
                System.out.println("Success");
                menu();
            } else {
                System.out.println("Error!!");
                login();
            }
        } else {
            System.out.println("\t\t\t1. Sorry! Check Account Number and Try Again");
        }
    }

    public static void menu(){
        System.out.println("\t\tWelcome to Online Banking System.");
        System.out.println("\t\t\t1. Check Balance");
        System.out.println("\t\t\t2. Transfer funds");
        System.out.println("\t\t\t3. Change Pin");
        System.out.println("\t\t\t4. Exit");

        choice = input.nextInt();

        switch(choice){
            case 1:
                balance();
            case 2:
                transact();
            case 3:
                pin();
            case 4:
                System.exit(0);
            default:
                System.out.println("\t\t\tPlease confirm your selection.");
        }
    }
    
    public static void balance(){
        System.out.println("Check your balance...");
        System.out.println("\t1. Yes");
        System.out.println("\t2. No");
        choice = input.nextInt();
        if(choice == 1){
            System.out.println("\tYour balance is: "+ATM.balance);
            System.out.println("1. Back to main menu\n2. Exit");
            choice = input.nextInt();
                if(choice == 1){
                    menu();
                } else {
                    System.exit(0);
                }

        } else {
            System.exit(0);
        }
    }

    public static void transact(){
        
        Integer account;
        Integer amount;
        System.out.println("Enter amount to transfer: ");
        amount = input.nextInt();
        System.out.println("\t Enter account number: ");
        account = input.nextInt();
        //if(account){
            System.out.println("\t Are you sure you want to transfer "+amount+" to account no: "+account+"?");
            System.out.println("\t1. Yes \n\t2. No");
            choice = input.nextInt();
            if(choice == 1){
                setBalance(balance - amount);
                System.out.println("You have successfully transfered "+amount+" to :"+account);
                System.out.println("\tTo exit press 1.\n\tTo return to main screen press 2.");
                choice = input.nextInt();
                if(choice == 1){
                    System.exit(0);
                } else {
                    menu();
                }
            }
        //}
    }

    public static void pin(){
        System.out.println("Do you want to change your pin?\n\t1. Yes\t2. No");
        choice = input.nextInt();
        Integer PIN = 0000;

        switch(PIN){
            case 0000:
                if(choice == 1 ){
                    System.out.println("Enter New Pin: ");
                    Integer newPin; 
                    newPin = input.nextInt();
                    System.out.println("Please confirm new Pin: ");
                    Integer confirmPin;
                    confirmPin = input.nextInt();
                    
                    if(confirmPin == newPin){
                        System.out.println("Pin Changed Succesfully!");
                        menu();
                    } else {
                        System.out.println("Pin entered do not match.\nPlease Try Again");
                        pin();
                    }
                }
            default : 
                System.out.println("Wrong Current pin.\nPlease Try Again.");
                pin();
        }
    }
}