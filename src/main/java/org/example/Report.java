package org.example;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class Report {
    public static void ViewReports() {
        Scanner scanner = new Scanner(System.in);

        boolean reports = true;
        while (reports) {
            System.out.println("===Chose from the ReportMenu options=== ");
            System.out.println("1) View Month To Date \n2) View Previous Month \n3) View Year To Date " +
                    "\n4) View Previous Year \n5) Search by Vendor \n0) Back");
            String userReportInput = scanner.nextLine();


            switch (userReportInput) {
                case "1":
                    viewMonthToDate();
                    break;
                case "2":
                    viewPreviousMonth();
                    break;
                case "3":
                    viewYearToDate();
                    break;
                case "4":
                    viewPreviousYear();
                    break;
                case "5":
                    searchByVendor();
                    break;
                case "0":
                    reports = false;
                default:System.out.println("Invalid Input! choose from the options provided");

                    System.out.println();

            }
        }
        //View report month to date
    } public static void viewMonthToDate() {
        try {

            LocalDate today = LocalDate.now();
            YearMonth currentMonth = YearMonth.from(today);

            for (Transactions t : Ledger.viewAllTransactions()) {
                YearMonth monthToDateTransaction = YearMonth.from(t.getDate());
                if (monthToDateTransaction.equals(currentMonth)) {
                    System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: %.2f%n",
                            t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //View report previous month
    } public static void viewPreviousMonth() {
        try {
            LocalDate today = LocalDate.now();
            YearMonth previousMonth = YearMonth.now().minusMonths(1);

            for (Transactions t : Ledger.viewAllTransactions()) {
                YearMonth previousMonthTransaction = YearMonth.from(t.getDate());
                if (previousMonthTransaction.equals(previousMonth)) {
                    System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: %.2f%n",
                            t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //View report Year to date
    } public static void viewYearToDate() {
        try {
            int yearToDateTransaction = LocalDate.now().getYear();

            for (Transactions t : Ledger.viewAllTransactions()) {
                if (t.getDate().getYear() == yearToDateTransaction) {
                    System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: %.2f%n",
                            t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // View previous year report
    }public static void viewPreviousYear() {
        try {
            int previousYearTransaction = LocalDate.now().getYear() - 1;

            for (Transactions t : Ledger.viewAllTransactions()) {
                if (t.getDate().getYear() == previousYearTransaction) {
                    System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: %.2f%n",
                            t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Search report using vendor name
    }public static void searchByVendor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Vendor name");
        String userVendorInput = scanner.nextLine().toLowerCase();

        boolean vendor = true;
        try {
            for (Transactions t : Ledger.viewAllTransactions()) {
                if (t.getVendor().toLowerCase().contains(userVendorInput)) {
                    System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: %.2f%n",
                            t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

