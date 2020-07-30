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
        vm.addPropertyChangeListener(evt -> updateTable());
        populateLists(vm.getOrders());
    }

    private void updateTable() {
        viewHandler.openOrderScreen();
    }

    private void populateLists(ArrayList<Order> orders) {
        int rowOfFinished= 0;
        int collumnOfFinished = 0;
        int rowOfUnfinished = 0;
        int collumnOfUnfinished = 0;
        for (int i = 0; i < orders.size(); i++) {
            if(orders.get(i).isFinished() == true){
                Label orderId = new Label(orders.get(i).getID()+ "");
                orderId.setFont(new Font("Arial", 30));
                orderId.setTextFill(Color.web("#008000", 0.8));
                if(rowOfFinished > 12){
                    collumnOfFinished++;
                    rowOfFinished = 0;
                }
                FinishedGrid.add(orderId, collumnOfFinished, rowOfFinished);
                rowOfFinished++;


            }else {
                Label orderId = new Label(orders.get(i).getID()+ "");
                orderId.setFont(new Font("Arial", 30));
                orderId.setTextFill(Color.web("#808080", 0.8));
                if(rowOfUnfinished > 12){
                    collumnOfUnfinished++;
                    rowOfUnfinished = 0;
                }
                UnfinishedGrid.add(orderId, collumnOfUnfinished, rowOfUnfinished);
                rowOfUnfinished++;
            }
        }
    }
}