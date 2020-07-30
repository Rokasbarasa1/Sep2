package main.client.view.orderScreen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import main.client.view.ViewHandler;
import main.client.viewModel.OrderScreenViewModel;
import main.shared.Order;


import java.util.ArrayList;

public class OrderScreenController {
    @FXML
    private GridPane UnfinishedGrid;
    @FXML
    private GridPane FinishedGrid;
    private OrderScreenViewModel vm;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, OrderScreenViewModel orderScreenViewModel) {
        this.viewHandler = viewHandler;
        vm = orderScreenViewModel;
        populateLists(vm.getOrders());
    }

    private void populateLists(ArrayList<Order> orders) {
        int rowOfFinished = 0;
        int rowOfUnfinished = 0;
        for (int i = 0; i < orders.size(); i++) {
            if(orders.get(i).isFinished() == true){
                Label orderId = new Label(orders.get(i).getID()+ "");
                FinishedGrid.add(orderId, 0, rowOfFinished);
                rowOfFinished++;
            }else {
                Label orderId = new Label(orders.get(i).getID()+ "");
                UnfinishedGrid.add(orderId, 0, rowOfUnfinished);
                rowOfUnfinished++;
            }
        }
    }
}
