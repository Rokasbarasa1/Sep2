package main.client.viewModel;

import main.client.model.cart.ICartModel;
import main.shared.Item;

import java.util.ArrayList;

public class CartViewModel {
    private ICartModel model;
    public CartViewModel(ICartModel cartModel) {
        model = cartModel;
    }

    public ArrayList<Item> getCart() {
        return model.getCart();
    }

    public void setCustomizeItem(int id) {
    }

    public int getIdForOrder() {
        return model.getIdForOrder();
    }

    public void makeOrder(int id) {
        model.makeOrder(id);
    }

    public void clearCart() {
        model.clearCart();
    }

    public void removeItemFromCart(int id) {
        model.removeItemFromCart(id);
    }
}
