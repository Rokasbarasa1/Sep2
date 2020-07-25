package main.client.model.customerMenu;

import main.shared.Item;

import java.util.ArrayList;

public interface ICustomerMenuModel {
    void addToCart(int id);
    ArrayList<Item> getMenu();
    ArrayList<Item> getCart();
}
