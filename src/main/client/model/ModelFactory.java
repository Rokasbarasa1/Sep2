package main.client.model;

import com.sun.security.ntlm.Client;
import main.client.clientNetworking.ClientFactory;
import main.client.model.login.ILoginModel;
import main.client.model.login.LoginModel;
import main.client.model.receptionistMenu.IReceptionistMenuModel;
import main.client.model.receptionistMenu.ReceptionistMenuModel;

public class ModelFactory {
    private ClientFactory clientFactory;
    private ILoginModel loginModel;
    private IReceptionistMenuModel receptionistMenuModel;

    public ModelFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public ILoginModel loginModel() {
        if(loginModel == null)
            loginModel = new LoginModel(clientFactory.loginClient());
        return loginModel;
    }

    public IReceptionistMenuModel receptionistMenuModel() {
        if(receptionistMenuModel == null)
            receptionistMenuModel = new ReceptionistMenuModel(clientFactory.receptionistMenuClient(),loginModel());
        return receptionistMenuModel;
    }
}
