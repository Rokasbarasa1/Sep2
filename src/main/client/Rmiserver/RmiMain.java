package main.client.Rmiserver;

import main.shared.RemoteCommandList;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiMain {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            RemoteCommandList server = new Rmihandler();
            registry.bind("point of sales", server);
            System.out.println("Server started...");
            System.out.println(registry.list().toString());
        } catch (RemoteException | AlreadyBoundException e){
            e.printStackTrace();
        }
    }
}
