package model;

public interface PricedItem {
    double getPrice();

    static boolean isValidPrice(double price) {
        return price > 0;
    }
}
