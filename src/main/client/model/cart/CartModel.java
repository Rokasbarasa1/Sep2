package main.client.model.cart;

import main.client.model.customerMenu.ICustomerMenuModel;
import main.shared.Item;

import java.util.ArrayList;

public class CartModel implements ICartModel {
    private ICustomerMenuModel customerMenuModel;
    private Item customize;

    public CartModel(ICustomerMenuModel customerMenuModel) {
        this.customerMenuModel = customerMenuModel;
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
}
