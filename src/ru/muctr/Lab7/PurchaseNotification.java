package ru.muctr.Lab7;

import java.util.Map;

public class PurchaseNotification {
    private String itemName;
    private Map<String, Integer> stockQuantities;

    public PurchaseNotification(String itemName, Map<String, Integer> stockQuantities) {
        this.itemName = itemName;
        this.stockQuantities = stockQuantities;
    }

    public String getItemName() {
        return itemName;
    }

    public Map<String, Integer> getStockQuantities() {
        return stockQuantities;
    }
}

