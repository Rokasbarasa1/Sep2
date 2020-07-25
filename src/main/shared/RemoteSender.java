package main.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteSender extends Remote {
    void newOrder() throws RemoteException;

}