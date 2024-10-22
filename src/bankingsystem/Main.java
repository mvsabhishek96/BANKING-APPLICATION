package bankingsystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Banking System Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Check Balance");
            System.out.println("6. Show Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    BankingSystem.createAccount(scanner);
                    break;
                case 2:
                    BankingSystem.deposit(scanner);
                    break;
                case 3:
                    BankingSystem.withdraw(scanner);
                    break;
                case 4:
                    BankingSystem.transferFunds(scanner);
                    break;
                case 5:
                    BankingSystem.checkBalance(scanner);
                    break;
                case 6:
                    BankingSystem.showTransactionHistory(scanner);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}

