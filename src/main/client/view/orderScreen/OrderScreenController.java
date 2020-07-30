package main.client.view.orderScreen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
        int rowOfFinishedCollumn0 = 0;
        int rowOfFinishedCollumn1 = 0;
        int rowOfUnfinishedCollumn0 = 0;
        int rowOfUnfinishedCollumn1 = 0;
        for (int i = 0; i < orders.size(); i++) {
            if(orders.get(i).isFinished() == true){
                Label orderId = new Label(orders.get(i).getID()+ "");
                orderId.setFont(new Font("Arial", 30));
                orderId.setTextFill(Color.web("#008000", 0.8));
                if(rowOfFinishedCollumn0 > 12){
                    FinishedGrid.add(orderId, 1, rowOfFinishedCollumn1);
                    rowOfFinishedCollumn1++;
                }else {
                    FinishedGrid.add(orderId, 0, rowOfFinishedCollumn0);
                    rowOfFinishedCollumn0++;
                }
            }else {
                Label orderId = new Label(orders.get(i).getID()+ "");
                orderId.setFont(new Font("Arial", 30));
                orderId.setTextFill(Color.web("#808080", 0.8));
                if(rowOfUnfinishedCollumn0 > 12){
                    UnfinishedGrid.add(orderId, 1, rowOfUnfinishedCollumn1);
                    rowOfUnfinishedCollumn1++;
                }else {
                    UnfinishedGrid.add(orderId, 0, rowOfUnfinishedCollumn0);
                    rowOfUnfinishedCollumn0++;
                }
            }
        }
    }
}