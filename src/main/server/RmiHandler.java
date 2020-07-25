package main.server;

import main.server.persistence.DAOFactory;
import main.shared.Item;
import main.shared.Receptionist;
import main.shared.RemoteCommandList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RmiHandler implements RemoteCommandList {
    private DAOFactory daoFactory;

    public RmiHandler(DAOFactory DAOFactory) throws RemoteException{
        UnicastRemoteObject.exportObject(this, 0);
        daoFactory = DAOFactory;
    }

    public String login(Receptionist loginCarrier) throws RemoteException {
        System.out.println(loginCarrier.getPassword()+""+loginCarrier.getUsername());
        return daoFactory.getLoginDAO().validateLogin(loginCarrier);
    }

    @Override
    public Receptionist getReceptionistById(int userId) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<Item> getMenu() {
        return null;
    }
}
