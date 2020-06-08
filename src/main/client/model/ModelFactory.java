package main.client.model;

import main.client.clientNetworking.ClientFactory;

public class ModelFactory {
    private ClientFactory clientFactory;


    public ModelFactory(ClientFactory c) {
        clientFactory = c;
    }

    public ILoginModel loginModel() {
        if(loginModel == null)
            loginModel = new LoginModel(clientFactory.loginClient());
        return loginModel;
    }
}
