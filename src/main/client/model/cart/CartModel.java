package main.client.model.cart;

import main.client.model.customerMenu.ICustomerMenuModel;
import main.client.model.userSelect.IUserSelectModel;
import main.shared.Item;

import java.util.ArrayList;

public class CartModel implements ICartModel {
    private IUserSelectModel userSelect;
    private ICustomerMenuModel customerMenuModel;
    private Item customize;

    public CartModel(ICustomerMenuModel customerMenuModel, IUserSelectModel userSelect) {
        this.customerMenuModel = customerMenuModel;
        this.userSelect = userSelect;
    }

    @Override
    public ArrayList<Item> getCart() {
        return customerMenuModel.getCart();
    }

    @Override
    public void removeItemFromCart(int id) {
        customerMenuModel.removeItemFromCart(id);
    }

    @Override
    public void setCustomizeItem(int id) {
        customize = getCart().get(id);
    }

    @Override
    public Item getCustomizeItem() {
        return customize;
    }

    @Override
    public boolean testConnection() {
        return userSelect.testConnection();
    }
}
