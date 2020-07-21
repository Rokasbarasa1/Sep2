package main.client.model;

import com.sun.security.ntlm.Client;
import main.client.clientNetworking.ClientFactory;
import main.client.model.login.ILoginModel;
import main.client.model.login.LoginModel;

public class ModelFactory {
    private ILoginModel loginModel;
    private ClientFactory clientFactory;
    public ModelFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public ILoginModel loginModel() {
        if(loginModel == null)
            loginModel = new LoginModel(clientFactory.loginClient());
        return loginModel;
    }
}
