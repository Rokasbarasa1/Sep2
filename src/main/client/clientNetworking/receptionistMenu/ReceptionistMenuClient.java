package main.client.clientNetworking.receptionistMenu;

import main.client.clientNetworking.ClientRMIHandler;
import main.shared.Item;
import main.shared.Receptionist;

import java.util.ArrayList;

public class ReceptionistMenuClient implements IReceptionistMenuClient {
    private ClientRMIHandler rmiHandler;

    public ReceptionistMenuClient(ClientRMIHandler rmiHandler) {
        this.rmiHandler = rmiHandler;
    }

    @Override
    public Receptionist getReceptionist(int userId) {
        return rmiHandler.getReceptionistById(userId);
    }

    @Override
    public ArrayList<Item> getMenu() {
        return rmiHandler.getMenu();
    }
}
