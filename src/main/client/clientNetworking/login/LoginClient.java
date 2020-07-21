package main.client.clientNetworking.login;

import com.google.gson.Gson;
import main.client.clientNetworking.ClientRMIHandler;
import main.client.model.login.ILoginModel;
import main.shared.Receptionist;

public class LoginClient implements ILoginClient {
    private ClientRMIHandler rmiHandler;
    private ILoginModel model;

    public LoginClient(ClientRMIHandler rmiHandler) {
        this.rmiHandler = rmiHandler;
    }

    @Override
    public String Login(Receptionist loginCarrier) {
        return rmiHandler.login(loginCarrier);
    }
}
