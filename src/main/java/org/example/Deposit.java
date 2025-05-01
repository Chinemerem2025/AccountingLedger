package org.example;
import java.util.*;
import java.time.*;
import java.io.*;

public class Deposit {
    public static void deposit() {
        try {
            FileWriter fileDeposit = new FileWriter("transactions.csv", true);
            BufferedWriter bufferDeposit = new BufferedWriter(fileDeposit);
            Scanner scanner = new Scanner(System.in);

            // bufferW.write(LocalDateTime.now() + " " + userMenuInput);
            //bufferW.newLine();

            // Deposit
            System.out.println("Enter Deposit Description");
            String userDescriptionInput = scanner.nextLine();

            System.out.println("Enter Vendor name");
            String userVendorInput = scanner.nextLine();

            System.out.println("Enter Amount");
            String userAmountInput = scanner.nextLine();

            System.out.println("Ledger:" + LocalDate.now() + LocalTime.now() + userDescriptionInput + userVendorInput + userAmountInput);

            bufferDeposit.write(LocalDate.now() + "" + LocalTime.now() + "|" + userDescriptionInput + "|" + userVendorInput + "|" + userAmountInput);
            bufferDeposit.newLine();

            bufferDeposit.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //Display Deposit Only

}
