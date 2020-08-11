package main.client.view.userSelect;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import main.client.view.ViewHandler;
import main.client.viewModel.UserSelectViewModel;

public class UserSelectController {
    @FXML
    private Label response;

    private ViewHandler viewHandler;
    private UserSelectViewModel vm;

    public void init(ViewHandler viewHandler, UserSelectViewModel userSelectViewModel) {
        vm = userSelectViewModel;
        this.viewHandler = viewHandler;
    }

    @FXML
    void OnCustomer() {
        if(vm.testConnection()){
            viewHandler.openCustomerMenu();
        }else{
            response.setText("Cannot open Customer. No connection.");
        }
    }

    @FXML
    void OnOrderScreen() {
        if(vm.testConnection()){
            viewHandler.openOrderScreen();
        }else{
            response.setText("Cannot open order screen. No connection.");
        }

    }

    @FXML
    void OnWorker() {
        viewHandler.openLogin();
    }
}
