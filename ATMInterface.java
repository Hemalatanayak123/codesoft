package hemalata;

import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount(int initialAmount) {
        this.balance = initialAmount;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of " + amount + " Rs was successful.");
        } else {
            System.out.println("Invalid entry! Please choose a number above 0.");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " Rs was successful.");
        } else {
            System.out.println("Invalid entry! Insufficient balance or negative value entered.");
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Select an Option:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Leave");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option;

        while (true) {
            displayMenu();
            System.out.println("Pick an option:");
           
            // Input validation for the option
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 4.");
                sc.next(); // discard invalid input
            }
            option = sc.nextInt();

            if (option == 4) {
                System.out.println("Thanks for using Jain Bank.");
                break;
            }

            switch (option) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a positive integer.");
                        sc.next(); // discard invalid input
                    }
                    int depositAmount = sc.nextInt();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a positive integer.");
                        sc.next(); // discard invalid input
                    }
                    int withdrawAmount = sc.nextInt();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance() + " Rs");
                    break;
                default:
                    System.out.println("Invalid entry! Enter only the given options.");
            }
        }
        sc.close();
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(30000);
        ATM atm = new ATM(userAccount);

        System.out.println("Enter Your PIN:");
        String pin = sc.nextLine();
       
        // Securely comparing the entered PIN
        if ("1234".equals(pin)) {
            atm.run();
        } else {
            System.out.println("Wrong PIN.");
        }

        sc.close();
    }
}