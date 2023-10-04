import java.util.ArrayList;
import java.util.Scanner;

public class ATMSystem {
    private static double balance = 1000; // Initial account balance
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM System !!");
        System.out.print("Please enter your user ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter your user PIN : ");
        int userPin = scanner.nextInt();

        // Simulate user authentication (In a real system, this would be done securely)
        if (authenticateUser(userId, userPin)) {
            int choice;
            do {
                displayMenu();
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        displayTransactionHistory();
                        break;
                    case 2:
                        withdrawMoney(scanner);
                        break;
                    case 3:
                        depositMoney(scanner);
                        break;
                    case 4:
                        transferMoney(scanner);
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM System. Have a Nice Day!!");
                        break;
                    default:
                        System.out.println("Invalid Option chosen. Please try again.");
                }
            } while (choice != 5);
        } else {
            System.out.println("Authentication failed. Exiting...");
        }

        scanner.close();
    }

    private static boolean authenticateUser(int userId, int userPin) {
        // In this basic example, any non-zero user ID and PIN combination is considered valid.
        return userId != 0 && userPin != 0;
    }

    private static void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. View Transaction History");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Transfer Money");
        System.out.println("5. Quit");
        System.out.print("Enter your choice: ");
    }

    private static void displayTransactionHistory() {
        System.out.println("Transaction history:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter the withdrawal amount: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            String transaction = "Withdrawal: Rs. " + amount + " - New Balance: Rs. " + balance;
            transactionHistory.add(transaction);
            System.out.println("Withdrawal successful. Current balance: Rs. " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance in your Account.");
        } else {
            System.out.println("Invalid Amount.");
        }
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter the deposit amount: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            String transaction = "Deposit: Rs. " + amount + " - New Balance: Rs. " + balance;
            transactionHistory.add(transaction);
            System.out.println("Deposit successful. Current balance: Rs. " + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private static void transferMoney(Scanner scanner) {
        System.out.print("Enter the recipient's account number: ");
        int recipientAccount = scanner.nextInt();
        System.out.print("Enter the transfer amount: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            String transaction = "Transfer: Rs. " + amount + " - New Balance: Rs. " + balance;
            transactionHistory.add(transaction);
            System.out.println("Transfer successful. Current balance: Rs. " + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }
}
