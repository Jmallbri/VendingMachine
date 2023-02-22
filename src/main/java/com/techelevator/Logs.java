package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logs {
    File log = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-5\\src\\main\\resources\\log.txt");
//    File salesLog = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-5\\src\\main\\resources\\salesLog.txt");

    boolean append = log.exists();

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    String formatDateTime = now.format(formatter);

    public void purchaseLog(VendingMachineCLI vendingMachineCLI, String slotChoice) {
        String productName = vendingMachineCLI.inventory.get(slotChoice).getName();
        BigDecimal productPrice = vendingMachineCLI.inventory.get(slotChoice).getPrice();
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, true))) {
            writer.print(formatDateTime);
            writer.print(" " + productName);
            writer.print(" " + slotChoice);
            writer.println(" " + productPrice);
            //vendingMachineCLI.returnToSecondMenu();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found.");
            //vendingMachineCLI.returnToSecondMenu();
        }
    }

//    public void salesLog(VendingMachineCLI vendingMachineCLI, String slotChoice) {
//        String productName = vendingMachineCLI.inventory.get(slotChoice).getName();
//        BigDecimal productPrice = vendingMachineCLI.inventory.get(slotChoice).getPrice();
//        try (PrintWriter writer = new PrintWriter(new FileOutputStream(salesLog, true))) {
//            writer.print(formatDateTime);
//            writer.print(" " + productName);
//            writer.println(" " + productPrice);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("File not found.");
//        }
//    }
}

