package com.techelevator;

import com.techelevator.view.VendingMenu;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

    private final VendingMenu menu;
    private final Scanner userInput = new Scanner(System.in);

    public VendingMachineCLI(VendingMenu menu) {
        this.menu = menu;
    }

    public static void main(String[] args) {
        VendingMenu menu = new VendingMenu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }

    public void printInventory(Map<String, Product> inventory) {
        for (Map.Entry<String, Product> entry : inventory.entrySet()) {
            String key = entry.getKey();
            String name = entry.getValue().getName();
            BigDecimal price = entry.getValue().getPrice();
            int quantity = entry.getValue().getQuantity();
            System.out.println(key + ": " + name + " " + price + " " + "(" + quantity + " remaining)");
        }
    }

    InventoryClass inventoryClass = new InventoryClass();
    Map<String, Product> inventory = inventoryClass.setInventory();
    PaymentCalculator paymentCalculator = new PaymentCalculator();
    Logs log = new Logs();
    boolean isCustomer = true;
    Chip chip = new Chip();
    Drink drink = new Drink();
    Candy candy = new Candy();
    Gum gum = new Gum();

    public void run() {

        boolean running = true;
        while (running) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
// display vending machine items
            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                printInventory(inventory);
            }

            if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                try {

                    while (isCustomer) {
                        String secondChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

                        if (secondChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                            System.out.println("Please enter a whole dollar amount: $1, $5, $10");
                            int feedUserInput = Integer.parseInt(userInput.nextLine());
                            paymentCalculator.feedMoney(BigDecimal.valueOf(feedUserInput));
                         //   log.feedMoneyLog(this);
                        }

                        if (secondChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                            printInventory(inventory);
                            System.out.println("Please select a slot. (ie. A1, A2...)");
                            String slotChoice = userInput.nextLine();
                            paymentCalculator.dispenseItem(this, slotChoice);
                            switch (slotChoice) {
                                case "A1":
                                    chip.response();
                                case "A2":
                                    chip.response();
                                case "A3":
                                    chip.response();
                                case "A4":
                                    chip.response();
                                    break;
                                case "B1":
                                    candy.response();
                                case "B2":
                                    candy.response();
                                case "B3":
                                    candy.response();
                                case "B4":
                                    candy.response();
                                    break;
                                case "C1":
                                    drink.response();
                                case "C2":
                                    drink.response();
                                case "C3":
                                    drink.response();
                                case "C4":
                                    drink.response();
                                    break;
                                case "D1":
                                    gum.response();
                                case "D2":
                                    gum.response();
                                case "D3":
                                    gum.response();
                                case "D4":
                                    gum.response();
                                    break;
                                default:
                                    break;
                            }
                            //log.purchaseLog(this, slotChoice);
                            //isCustomer = true;
                        }

                        if (secondChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                            paymentCalculator.getChange(this);

                            isCustomer = false;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("You did something wrong.");

                }
            }
            if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                paymentCalculator.getChange(this);


                running = false;
            }

        }
    }


}



