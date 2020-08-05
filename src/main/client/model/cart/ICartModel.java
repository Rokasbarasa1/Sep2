package main.client.model.cart;

import main.shared.Item;

import java.util.ArrayList;

public interface ICartModel {
    ArrayList<Item> getCart();
    int getIdForOrder();
    void makeOrder(int id);
    void clearCart();
    void removeItemFromCart(int id);
    int getIdSaved();
    void setCustomizeItem(int id);

    Item getCustomizeItem();
}
