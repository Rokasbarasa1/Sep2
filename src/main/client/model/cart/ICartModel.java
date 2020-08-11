package main.client.model.cart;

import main.shared.Item;

import java.util.ArrayList;

public interface ICartModel {
    ArrayList<Item> getCart();
    void removeItemFromCart(int id);
    void setCustomizeItem(int id);
    Item getCustomizeItem();

    boolean testConnection();
}
