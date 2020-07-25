package main.client.viewModel;

import main.client.model.customerMenu.ICustomerMenuModel;
import main.shared.Item;

import java.util.ArrayList;

public class CustomerMenuViewModel {
    private ICustomerMenuModel model;

    public CustomerMenuViewModel(ICustomerMenuModel customerMenuModel) {
        model = customerMenuModel;
    }

    public void addToCart(int id) {
        model.addToCart(id);
    }

    public ArrayList<Item> getMenu() {
        return model.getMenu();
    }
}
