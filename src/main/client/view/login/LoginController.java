package main.client.view.login;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.client.view.ViewHandler;
import main.client.viewModel.LoginViewModel;

public class LoginController {
    private ViewHandler viewHandler;
    private LoginViewModel vm;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label response;

    public void init(LoginViewModel loginViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.vm = loginViewModel;
        username.textProperty().bindBidirectional(vm.usernameProperty());
        password.textProperty().bindBidirectional(vm.passwordProperty());
        response.textProperty().bindBidirectional(vm.loginResponseProperty());
    }

    @FXML
    void OnLogin() {
        vm.login();
        if(response.getText().equals("Login successful")){
            viewHandler.openReceptionistMenu();
        }
    }
}
