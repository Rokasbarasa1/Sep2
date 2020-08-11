package main.client.model.userSelect;

import main.client.clientNetworking.userSelect.IUserSelectClient;

public class UserSelectModel implements IUserSelectModel{
    private IUserSelectClient userSelectClient;
    public UserSelectModel(IUserSelectClient userSelectClient) {
        this.userSelectClient = userSelectClient;
    }


    @Override
    public boolean testConnection() {
        return userSelectClient.testConnection();
    }
}
