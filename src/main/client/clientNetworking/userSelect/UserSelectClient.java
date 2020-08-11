package main.client.clientNetworking.userSelect;

import main.client.clientNetworking.rmi.ClientRMIHandler;

public class UserSelectClient implements IUserSelectClient {
    private ClientRMIHandler rmiHandler;
    public UserSelectClient(ClientRMIHandler rmiHandler) {
        this.rmiHandler = rmiHandler;
    }

    @Override
    public boolean testConnection() {
        return rmiHandler.testConnection();
    }
}
