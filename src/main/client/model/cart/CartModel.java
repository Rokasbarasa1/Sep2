package main.client.model.cart;

import main.client.clientNetworking.cart.ICartClient;
import main.client.model.customerMenu.ICustomerMenuModel;
import main.shared.Item;

import java.util.ArrayList;

public class CartModel implements ICartModel {
    private ICustomerMenuModel customerMenuModel;
    private ICartClient client;

    public CartModel(ICustomerMenuModel customerMenuModel, ICartClient cartClient) {
        this.customerMenuModel = customerMenuModel;
        client = cartClient;
    }

    @Override
    public ArrayList<Item> getCart() {
        return customerMenuModel.getCart();
    }
}
