package main.client.clientNetworking.createItem;

import main.client.clientNetworking.rmi.ClientRMIHandler;
import main.shared.Item;

public class CreateItemClient implements ICreateItemClient{
    private ClientRMIHandler rmiHandler;

    public CreateItemClient(ClientRMIHandler rmiHandler) {
        this.rmiHandler = rmiHandler;
    }

    @Override
    public String createItem(Item createdItem) {
        return rmiHandler.createItem(createdItem);
    }

    @Override
    public boolean testConnection() {
        return rmiHandler.testConnection();
    }
}
