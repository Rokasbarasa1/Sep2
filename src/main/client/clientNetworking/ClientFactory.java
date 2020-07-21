package main.client.clientNetworking;
import main.client.clientNetworking.login.ILoginClient;
import main.client.clientNetworking.login.LoginClient;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientFactory {
    private ClientRMIHandler rmiHandler;
    private ILoginClient loginClient;

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

    public void closeConnection() {
        //socketHandler.closeConnection();
    }
}
