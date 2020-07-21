package main.client.Rmiserver;
import main.shared.Receptionist;
import main.shared.RemoteCommandList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Rmihandler implements RemoteCommandList {

    public Rmihandler() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }


    @Override
    public String login(Receptionist loginCarrier) throws RemoteException {
        System.out.println(loginCarrier.getPassword()+ " " + loginCarrier.getUsername());
        return "Login successful;21";
    }
}
