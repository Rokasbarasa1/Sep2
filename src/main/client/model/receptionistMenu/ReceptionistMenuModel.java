package main.client.model.receptionistMenu;

import main.client.clientNetworking.receptionistMenu.IReceptionistMenuClient;
import main.client.model.login.ILoginModel;
import main.shared.Receptionist;

public class ReceptionistMenuModel implements IReceptionistMenuModel{
    private Receptionist currentUser;
    private IReceptionistMenuClient client;
    private ILoginModel loginModel;

    public ReceptionistMenuModel(IReceptionistMenuClient receptionistMenuClient, ILoginModel login) {
        client = receptionistMenuClient;
        loginModel = login;
    }

    @Override
    public void loadReceptionist() {
        currentUser = client.getReceptionist(loginModel.getCurrentUser().getID());
    }
}
