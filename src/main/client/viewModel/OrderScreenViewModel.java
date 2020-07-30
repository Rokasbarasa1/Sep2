package main.client.viewModel;

import main.client.model.orderScreen.IOrderScreenModel;
import main.shared.Order;

import java.util.ArrayList;

public class OrderScreenViewModel {
    private IOrderScreenModel model;

    public OrderScreenViewModel(IOrderScreenModel model) {
        this.model = model;
    }

    public ArrayList<Order> getOrders() {
        return model.getOrders();
    }
}
