package main.client.model.login;

import main.client.clientNetworking.login.ILoginClient;
import main.shared.Receptionist;

public interface ILoginModel {
    void Login(String username, String password);
    String loginResponse();
    Receptionist getCurrentUser();

}
