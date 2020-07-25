package main.client.model.receptionistMenu;

import main.shared.Item;

import java.util.ArrayList;

public interface IReceptionistMenuModel {
    void loadReceptionist();

    ArrayList<Item> getMenu();
}
