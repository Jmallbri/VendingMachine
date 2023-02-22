package com.techelevator;

import java.math.BigDecimal;

public class PaymentCalculator {
    private BigDecimal currentMoney = new BigDecimal(0);

//    Logs logs = new Logs();

    public BigDecimal feedMoney(BigDecimal feedUserInput) {
        BigDecimal feedAmount = new BigDecimal(String.valueOf(feedUserInput));
        if (feedAmount.compareTo(BigDecimal.ZERO) > 0) {
            currentMoney = currentMoney.add(feedAmount);
            System.out.println("$" + feedAmount + " has been inserted.");
            System.out.println("Total money inserted: " + getCurrentMoney());
            return currentMoney;
        } else {
            System.out.println("Amount must be greater than 0.");
        }
        return currentMoney;
    }


    public void setCurrentMoney(BigDecimal currentMoney) {
        this.currentMoney = currentMoney;
    }

    public BigDecimal getCurrentMoney() {
        return currentMoney;
    }

    public void dispenseItem(VendingMachineCLI vendingMachineCLI, String slotChoice) {
        BigDecimal remainingFunds = vendingMachineCLI.paymentCalculator.getCurrentMoney();
        Product selectedItem = vendingMachineCLI.inventory.get(slotChoice.toUpperCase());
        if (selectedItem.getQuantity() > 0) {
            if (remainingFunds.compareTo(selectedItem.getPrice()) >= 0) {
                selectedItem.setQuantity(selectedItem.getQuantity() - 1);
                vendingMachineCLI.paymentCalculator.setCurrentMoney(remainingFunds.subtract(selectedItem.getPrice()));
                System.out.println("Here's your " + selectedItem.getName() + ": " + selectedItem.response());
                //vendingMachineCLI.log.purchaseLog(vendingMachineCLI, slotChoice);
                //vendingMachineCLI.isCustomer = true;

            } else {
                System.out.println("Sorry, you have insufficient funds!");
                System.out.println("Total money inserted: " + getCurrentMoney());
            }
        } else {
            System.out.println("The item is sold out!");
            System.out.println("Total money inserted: " + getCurrentMoney());
        }
    }


    public void getChange(VendingMachineCLI vendingMachineCLI) {
        final int QUARTER = 25;
        final int DIME = 10;
        final int NICKEL = 5;

        BigDecimal multipliedBy100 = vendingMachineCLI.paymentCalculator.getCurrentMoney().multiply(BigDecimal.valueOf(100.0));
        int currentBalance = multipliedBy100.intValue();
//        int currentBalance = (vendingMachineCLI.paymentCalculator.getCurrentMoney().intValue() * 100);
        int numberOfQuarters = (int) (currentBalance / QUARTER);
        currentBalance = currentBalance % QUARTER;
        int numberOfDimes = (int) (currentBalance / DIME);
        currentBalance = currentBalance % DIME;
        int numberOfNickels = (int) (currentBalance / NICKEL);
        currentBalance = currentBalance % NICKEL;

        double valueOfQuarters = numberOfQuarters * ((double) QUARTER / 100);
        double valueOfDimes = numberOfDimes * ((double) DIME / 100);
        double valueOfNickels = numberOfNickels * ((double) NICKEL / 100);
        System.out.println("Your change is: $" + getCurrentMoney() + "\n" + "This equals $" + valueOfQuarters + " in Quarters, $" +
                valueOfDimes + " in Dimes, and $" + valueOfNickels + " in Nickels");
    }
}


