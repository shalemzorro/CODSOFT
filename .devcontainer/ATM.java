import java.util.Scanner;

public class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM Machine!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performOption(int option) {
        switch (option) {
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM Machine!");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void withdraw() {
        System.out.println("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Withdrawal failed. Insufficient balance.");
        }
    }

    private void deposit() {
        System.out.println("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
        System.out.println("Deposit successful!");
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + bankAccount.getBalance());
    }

    public void start() {
        while (true) {
            displayMenu();
            System.out.println("Enter your choice: ");
            int option = scanner.nextInt();
            if (option == 4) {
                break;
            }
            performOption(option);
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(500); // Initial balance of 500
        ATM atm = new ATM(account);
        atm.start();
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

