package main.server;

import main.server.model.ModelFactory;
import main.server.persistence.DAOFactory;
import main.server.persistence.database.DBConnection;
import main.server.persistence.database.IDBConnection;
import main.server.rmi.RmiHandler;
import main.server.rmi.RemoteCommandList;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class JavaServer {

    public static void main(String[] args){
        IDBConnection connect = new DBConnection();
        DAOFactory DAOFactory = new DAOFactory(connect);
        ModelFactory modelFactory = new ModelFactory(DAOFactory);
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            RemoteCommandList server = new RmiHandler(modelFactory);
            registry.bind("point of sales", server);
            System.out.println("Server Started...");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
