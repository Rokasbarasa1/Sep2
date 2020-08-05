package main.client.model.cart;

import main.client.clientNetworking.cart.ICartClient;
import main.client.model.customerMenu.ICustomerMenuModel;
import main.shared.Item;
import main.shared.Order;

import java.util.ArrayList;

public class CartModel implements ICartModel {
    private ICustomerMenuModel customerMenuModel;
    private ICartClient client;
    private int orderId;

    public CartModel(ICustomerMenuModel customerMenuModel, ICartClient cartClient) {
        this.customerMenuModel = customerMenuModel;
        client = cartClient;
    }

    @Override
    public ArrayList<Item> getCart() {
        return customerMenuModel.getCart();
    }

    @Override
    public int getIdForOrder() {
        orderId = client.getIdForOrder();
        return client.getIdForOrder();
    }

    @Override
    public void makeOrder(int id) {
        Order order = new Order(id, customerMenuModel.getCart());
        client.makeOrder(order);
    }

    @Override
    public void clearCart() {
        customerMenuModel.clear();
    }

    @Override
    public void removeItemFromCart(int id) {
        customerMenuModel.removeItemFromCart(id);
    }

    @Override
    public int getIdSaved() {
        return  orderId;
    }
}
