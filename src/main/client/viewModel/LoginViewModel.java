package main.client.viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.model.login.ILoginModel;

public class LoginViewModel {
    private StringProperty username, password, loginResponse;
    private ILoginModel model;

    public LoginViewModel(ILoginModel loginModel) {
        this.model = loginModel;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        loginResponse = new SimpleStringProperty();
    }

    public void login() {
        if(username.get() != null && !username.get().isEmpty() && password.get() != null && !password.get().isEmpty()) {
            model.Login(username.get(), password.get());
            loginResponse.set(model.loginResponse());
        }
        else{
            loginResponse.setValue("Must enter both, username and password");
            username.setValue(null);
            password.setValue(null);
        }
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty loginResponseProperty() {
        return loginResponse;
    }
}
