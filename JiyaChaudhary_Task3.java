 import java.util.ArrayList;
import java.util.Scanner;

public class JiyaChaudhary_Task3 {

    private double balance;
    private int pin;
    private ArrayList<String> transactionHistory;

    public JiyaChaudhary_Task3(int pin, double initialBalance) {
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean validatePIN(int enteredPin) {
        return this.pin == enteredPin;
    }

    public void checkBalance() {
        System.out.println("Your current balance is: Rs. " + balance);
        transactionHistory.add("Checked balance: Rs. " + balance);
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn Rs. " + amount);
            transactionHistory.add("Withdrawn: Rs. " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited Rs. " + amount);
            transactionHistory.add("Deposited: Rs. " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void changePIN(int newPin) {
        this.pin = newPin;
        System.out.println("PIN successfully changed.");
        transactionHistory.add("PIN changed.");
    }

    // Transfer Money
    public void transferMoney(String accountNumber, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;

            System.out.println("Successfully transferred Rs. " + amount);
            System.out.println("To Account: " + accountNumber);

            transactionHistory.add(
                "Transferred Rs. " + amount + " to Account: " + accountNumber
            );
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void showTransactionHistory() {
        System.out.println("\n--- Transaction History ---");

        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        JiyaChaudhary_Task3 atm = new JiyaChaudhary_Task3(1234, 5000);

        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (!atm.validatePIN(enteredPin)) {
            System.out.println("Invalid PIN. Exiting...");
            scanner.close();
            return;
        }

        while (true) {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. View Transaction History");
            System.out.println("6. Transfer Money");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.print("Enter deposit amount: Rs. ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 4:
                    System.out.print("Enter new PIN: ");
                    int newPin = scanner.nextInt();
                    atm.changePIN(newPin);
                    break;

                case 5:
                    atm.showTransactionHistory();
                    break;

                case 6:
                    scanner.nextLine();

                    System.out.print("Enter recipient account number: ");
                    String accountNumber = scanner.nextLine();

                    System.out.print("Enter transfer amount: Rs. ");
                    double transferAmount = scanner.nextDouble();

                    atm.transferMoney(accountNumber, transferAmount);
                    break;

                case 7:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
} 