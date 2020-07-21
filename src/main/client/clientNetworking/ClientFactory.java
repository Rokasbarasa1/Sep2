package main.client.clientNetworking;

import main.client.clientNetworking.login.ILoginClient;
import main.client.clientNetworking.login.LoginClient;
import main.client.clientNetworking.receptionistMenu.IReceptionistMenuClient;
import main.client.clientNetworking.receptionistMenu.ReceptionistMenuClient;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientFactory {
    private ClientRMIHandler rmiHandler;
    private ILoginClient loginClient;
    private IReceptionistMenuClient receptionistMenuClient;

    public ClientFactory(){
        try {
            rmiHandler = new ClientRMIHandler();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    public ILoginClient loginClient() {
        if(loginClient == null)
            loginClient = new LoginClient(rmiHandler);
        return loginClient;
    }

    public IReceptionistMenuClient receptionistMenuClient() {
        if(receptionistMenuClient == null)
            receptionistMenuClient = new ReceptionistMenuClient(rmiHandler);
        return receptionistMenuClient;
    }

    public void closeConnection() {
        //socketHandler.closeConnection();
    }
}
