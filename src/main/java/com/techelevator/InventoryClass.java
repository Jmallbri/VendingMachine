package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class InventoryClass {
    private static final int MAX_INVENTORY_PER_ITEM = 5;
    VendingMachine vMachine = new VendingMachine();

    Scanner userInput = new Scanner(System.in);

    public Map<String, Product> setInventory() {
        File vendingMachineFile = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-5\\vendingmachine.csv");
        Map<String, Product> inventoryMap = new TreeMap<>();

        try {
            Scanner reader = new Scanner(vendingMachineFile);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] inventoryArray = line.split("\\|");
                if (inventoryArray[3].equals("Chip")) {
                    Chip chip = new Chip();
                    chip.setName(inventoryArray[1]);
                    BigDecimal price = new BigDecimal(inventoryArray[2]);
                    chip.setPrice(price);
                    chip.setQuantity(MAX_INVENTORY_PER_ITEM);
                    inventoryMap.put(inventoryArray[0], chip);
                }
                if (inventoryArray[3].equals("Candy")) {
                    Candy candy = new Candy();
                    candy.setName(inventoryArray[1]);
                    BigDecimal price = new BigDecimal(inventoryArray[2]);
                    candy.setPrice(price);
                    candy.setQuantity(MAX_INVENTORY_PER_ITEM);
                    inventoryMap.put(inventoryArray[0], candy);
                }
                if (inventoryArray[3].equals("Drink")) {
                    Drink drink = new Drink();
                    drink.setName(inventoryArray[1]);
                    BigDecimal price = new BigDecimal(inventoryArray[2]);
                    drink.setPrice(price);
                    drink.setQuantity(MAX_INVENTORY_PER_ITEM);
                    inventoryMap.put(inventoryArray[0], drink);
                }
                if (inventoryArray[3].equals("Gum")) {
                    Gum gum = new Gum();
                    gum.setName(inventoryArray[1]);
                    BigDecimal price = new BigDecimal(inventoryArray[2]);
                    gum.setPrice(price);
                    gum.setQuantity(MAX_INVENTORY_PER_ITEM);
                    inventoryMap.put(inventoryArray[0], gum);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inventoryMap;
    }
}