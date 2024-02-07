import java.util.Scanner;

public class Bank_Mainpage {
    public static void main(String[] args) {
        Bank_Login_Signup Mainlog = new Bank_Login_Signup();

        Scanner scan = new Scanner(System.in);

        System.out.println("");
        System.out.println("Enter account number: ");
        String accountNumber = scan.nextLine();

        Bank account = new Bank(accountNumber);

        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Log-out");
            System.out.println("Choose an Option: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit: ");
                    double depositAmount = scan.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw: ");
                    double withdrawAmount = scan.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Logging out...");
                    Mainlog.main(args);
                    break;
                default:
                    System.out.println("Invalid choice. please choose again. ");
                    break;
            }

        }
    }
}
