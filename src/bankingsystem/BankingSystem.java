package bankingsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankingSystem {
    private static Map<String, Account> accounts = new HashMap<>();

    public static void createAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account number already exists.");
            return;
        }

        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();

        System.out.print("Enter initial deposit: ");
        double initialDeposit = Double.parseDouble(scanner.nextLine());

        Account account = new Account(accountNumber, accountHolderName, initialDeposit);
        accounts.put(accountNumber, account);

        System.out.println("Account created successfully.");
    }

    public static void deposit(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter deposit amount: ");
        double depositAmount = Double.parseDouble(scanner.nextLine());

        account.deposit(depositAmount);
    }

    public static void withdraw(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter withdrawal amount: ");
        double withdrawalAmount = Double.parseDouble(scanner.nextLine());

        account.withdraw(withdrawalAmount);
    }

    public static void transferFunds(Scanner scanner) {
        System.out.print("Enter sender account number: ");
        String senderAccountNumber = scanner.nextLine();
        Account senderAccount = accounts.get(senderAccountNumber);

        if (senderAccount == null) {
            System.out.println("Sender account not found.");
            return;
        }

        System.out.print("Enter receiver account number: ");
        String receiverAccountNumber = scanner.nextLine();
        Account receiverAccount = accounts.get(receiverAccountNumber);

        if (receiverAccount == null) {
            System.out.println("Receiver account not found.");
            return;
        }

        System.out.print("Enter transfer amount: ");
        double transferAmount = Double.parseDouble(scanner.nextLine());

        if (senderAccount.getBalance() < transferAmount) {
            System.out.println("Insufficient balance.");
            return;
        }

        senderAccount.withdraw(transferAmount);
        receiverAccount.deposit(transferAmount);

        System.out.println("Funds transferred successfully.");
    }

    public static void checkBalance(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Current balance: " + account.getBalance());
    }

    public static void showTransactionHistory(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.showTransactionHistory();
    }
}

