package ru.muctr.Lab7;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class DeliveryService implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof PurchaseNotification && o instanceof Warehouse) {
            PurchaseNotification notification = (PurchaseNotification) arg;
            String purchasedItem = notification.getItemName();
            Map<String, Integer> stockQuantities = notification.getStockQuantities();
            System.out.println("Поступил новый заказ на доставку! Товар: \"" + purchasedItem + "\"");
            deliverGoods(purchasedItem, stockQuantities);
        }
    }

    private void deliverGoods(String itemPurchased, Map<String, Integer> stock) {
        if (stock != null && itemPurchased != null && stock.containsKey(itemPurchased) && stock.get(itemPurchased) >= 0) {
            System.out.println("Доставка товара \"" + itemPurchased + "\" успешно выполнена!");
        } else {
            System.out.println("Доставка недоступна.");
        }
    }
}
