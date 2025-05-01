package org.example;
import java.util.*;
import java.time.*;
import java.io.*;

public class Payment {
    public static void Payments() {
        try {
            Scanner scanner = new Scanner(System.in);
            FileWriter filePayment = new FileWriter("transactions.csv", true);
            BufferedWriter bufferPayment = new BufferedWriter(filePayment);
            Scanner scannerP = new Scanner(System.in);

            System.out.println("Enter Payment Description");
            String userDescriptionInput = scannerP.nextLine();

            System.out.println("Enter Vendor name");
            String userVendorInput = scannerP.nextLine();

            System.out.println("Enter Amount");
            String userAmountInput = scannerP.nextLine();

            System.out.println("Ledger:" + LocalDate.now() + LocalTime.now() + userVendorInput + userAmountInput);
            System.out.println();

            bufferPayment.write(LocalDate.now() + "|" + LocalTime.now() + "|" + userDescriptionInput + "|" + userVendorInput + "|-" + userAmountInput);
            bufferPayment.newLine();

            bufferPayment.close();
            //mainMenu = false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

