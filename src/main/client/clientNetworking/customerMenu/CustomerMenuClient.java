package main.client.clientNetworking.customerMenu;

import main.client.clientNetworking.rmi.ClientRMIHandler;
import main.shared.Item;

import java.util.ArrayList;

public class CustomerMenuClient implements ICustomerMenuClient {
    private ClientRMIHandler rmiHandler;

    public CustomerMenuClient(ClientRMIHandler rmiHandler) {
        this.rmiHandler = rmiHandler;
    }

    @Override
    public ArrayList<Item> getMenu() {
        return rmiHandler.getMenu();
    }
}
