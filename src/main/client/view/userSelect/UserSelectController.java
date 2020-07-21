package main.client.view.userSelect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import main.client.view.ViewHandler;

public class UserSelectController {
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
    }

    @FXML
    void OnCustomer(ActionEvent event) {
        viewHandler.openCustomerMenu();
    }

    @FXML
    void OnOrderScreen(ActionEvent event) {
        viewHandler.openOrderScreen();
    }

    @FXML
    void OnWorker(ActionEvent event) {
        viewHandler.openLogin();
    }
}
