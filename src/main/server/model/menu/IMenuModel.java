package main.server.model.menu;

import main.shared.Item;

import java.util.ArrayList;

public interface IMenuModel {
    ArrayList<Item> getMenu();
    String addItemToMenu(Item item);
    void deleteItemFromMenu(int id);
}
