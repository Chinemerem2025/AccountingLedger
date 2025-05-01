package org.example;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.*;
import java.io.*;
import java.io.BufferedReader;

import java.util.Scanner;

public class Ledger {

    public static void LedgerMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("===Chose from the LedgerMenu options=== ");
        System.out.println("A) View All Entries \nD) View Deposit only \nP) View Payments only \nR) View Reports");
        String userLedgerInput = scanner.nextLine();

        if (userLedgerInput.equalsIgnoreCase("A")) {
            viewALLEntries();

        } else if (userLedgerInput.equalsIgnoreCase("D")) {
            viewDeposit();

        } else if (userLedgerInput.equalsIgnoreCase("P")) {
            viewAllPayment();

        } else if (userLedgerInput.equalsIgnoreCase("R")) {
            Report.ViewReports();

        } else {
            System.out.println("Invalid Input! choose from the options provided");
        }
    }


    // Method to Display all Transactions
    public static List<Transactions> viewAllTransactions() {
        //store all transaction
        List<Transactions> allTransactions = new ArrayList<>();
        try {
            //fileReader to read all transaction
            FileReader fileReadAllEntries = new FileReader("transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReadAllEntries);
            bufferedReader.readLine();

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                //parts the data from csv file
                String[] splitParts = line.split("\\|");
                LocalDate date = LocalDate.parse(splitParts[0].trim());
                LocalTime time = LocalTime.parse(splitParts[1].trim());
                String description = splitParts[2].trim();
                String vendor = splitParts[3].trim();
                double amount = Double.parseDouble(splitParts[4].trim());

                Transactions t = new Transactions(date, time, description, vendor, amount);
                allTransactions.add(t);
            }
            bufferedReader.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return allTransactions;

        //Method to display all Entries in csv
    }public static void viewALLEntries(){
        try{
            //List<Transactions> allTransactions = Ledger.viewAllTransactions();
            for (Transactions t : viewAllTransactions()) {
                System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: %.2f%n",
                        t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // Display Deposit only
    public static void viewDeposit() {
        //List<Transactions> printDepositOnly = new ArrayList<>();
        for (Transactions t : Ledger.viewAllTransactions()) {
            if ((t.getAmount() > 0)) {
                System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: %.2f%n",
                        t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
            }
        }
        //return printDepositOnly;
    }
    // Display Payments only
    public static void viewAllPayment() {
        try {
            for (Transactions t : Ledger.viewAllTransactions()) {
                if ((t.getAmount() < 0)) {
                    System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: %.2f%n",
                            t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}