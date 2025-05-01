package org.example;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean mainMenu = true;
        while(mainMenu) {
            //List<Transactions> aLLTransaction = Ledger.viewAllTransactions(); it will display my csv file while mainMenu is true before user input
            System.out.println();
            System.out.println("===Chose from the MainMenul options=== ");
            System.out.println("D - Deposit \nP - Make Payment(Debit) \nL - Ledger \nX - Exit");
            String userMenuInput = scanner.nextLine();

            if (userMenuInput.equalsIgnoreCase("D")) {
                Deposit.deposit();
            } else if (userMenuInput.equalsIgnoreCase("P")) {
                Payment.Payments();
            } else if (userMenuInput.equalsIgnoreCase("L")) {
                Ledger.LedgerMenu();
            } else if (userMenuInput.equalsIgnoreCase("X")) {
                System.out.println("Exiting....");
                mainMenu = false;
            }else {
                System.out.println("Invalid Input! choose from the options provided");
                System.out.println();
            }
        }
    }
}