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
        model.setCustomizeItem(id);
    }

    public void removeItemFromCart(int id) {
        model.removeItemFromCart(id);
    }
}
