package main.server.persistence.item;

import main.shared.Item;

import java.util.ArrayList;

public interface IItemDAO {
    ArrayList<Item> getMenuItems();
    boolean addItem(Item item);
}
