
import java.util.Scanner;

class Bank {
    private String accountNumber;
    private double balance;

    public Bank(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully! ");
        } else {
            System.out.println("Invalid amount.Deposit failed.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully! ");
        } else {
            System.out.println("Invalid amount or insufficient balance. Withdrawal failed. ");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class Accounts {
    private String username;
    private String password;

    public Accounts(String username, String password) {
        this.username = username; // variable creation
        this.password = password; // variable creation
    }

    public String getUsername() { // getters method
        return username;
    }

    public String getPassword() { // getters method
        return password;
    }
}

class AccManager {
    private Accounts[] accs;
    private int accCount;

    public AccManager(int capacity) {
        this.accs = new Accounts[capacity];
        this.accCount = 0;
    }

    public boolean signUp(String username, String password) {
        if (username.trim().isEmpty() || password.isEmpty()) {
            System.out.println("Please fill out all fields");
            return false;
        }
        if (findAcc(username) == -1) {
            Accounts newAcc = new Accounts(username, password);
            accs[accCount++] = newAcc;
            System.out.println("Sign up successful!");
            return true;
        } else {
            System.out.println("Username already exits. Please choose another");
            return false;
        }
    }

    public boolean login(String username, String password) {
        int accIndex = findAcc(username);

        if (username.trim().isEmpty() || password.isEmpty()) {
            System.out.println("Please enter both username and password");
            return false;
        }

        if (accIndex != -1) {
            Accounts acc = accs[accIndex];
            if (acc.getPassword().equals(password)) {
                System.out.println("Login successful");
                return true;
            } else {
                System.out.println("Incorrect password. Please try again");
                return false;
            }
        } else {
            System.out.println("Account not found. Please sign up");

            return false;
        }

    }

    private int findAcc(String username) {
        for (int i = 0; i < accCount; i++) {
            if (accs[i].getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }
}

public class Bank_Login_Signup {

    public static void login() {
        Scanner wordscan = new Scanner(System.in);

    }

    public static void main(String[] args) {
        AccManager accManager = new AccManager(10);
        Scanner wordscan = new Scanner(System.in);
        Scanner intscan = new Scanner(System.in);
        Bank_Mainpage Pagecall = new Bank_Mainpage();

        while (true) {

            System.out.println("");
            System.out.println("Welcome to Demacian Bank");
            System.out.println("");
            System.out.println("What's your agenda today?");
            System.out.println("");
            System.out.println("[1] Login");
            System.out.println("");
            System.out.println("[2] Sign-up");
            System.out.println("");
            System.out.println("[3] Exit");
            int choice = intscan.nextInt();
            System.out.println("");

            switch (choice) {
                case 1:
                    System.out.println("Login");
                    System.out.println("");
                    System.out.println("Enter your Username: ");
                    String loginUsername = wordscan.nextLine();
                    System.out.println("");
                    System.out.println("Enter your Password: ");
                    String loginPassword = wordscan.nextLine();
                    accManager.login(loginUsername, loginPassword);
                    Pagecall.main(args);
                    return; // replace with return instead of break to stop while looping
                case 2:
                    System.out.println("Sign-up");
                    System.out.println("");
                    System.out.println("Create your Username: ");
                    String signUsername = wordscan.nextLine();
                    System.out.println("");
                    System.out.println("Create your Password: ");
                    String signPassword = wordscan.nextLine();
                    accManager.signUp(signUsername, signPassword);
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice please try again");

            }
        }

    }
}
