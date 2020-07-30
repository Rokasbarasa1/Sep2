package main.server.rmi;

import main.server.model.ModelFactory;
import main.shared.Item;
import main.shared.Order;
import main.shared.Receptionist;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RmiHandler implements RemoteCommandList {
    private ModelFactory modelFactory;

    public RmiHandler(ModelFactory modelFactory) throws RemoteException{
        UnicastRemoteObject.exportObject(this, 0);
        this.modelFactory = modelFactory;
    }

    public String login(Receptionist loginCarrier) throws RemoteException {
        System.out.println(loginCarrier.getPassword()+" "+loginCarrier.getUsername());
        return modelFactory.getLoginModel().validateLogin(loginCarrier);
    }

    @Override
    public Receptionist getReceptionistById(int userId) throws RemoteException {
        return modelFactory.getLoginModel().getReceptionistById(userId);
    }

    @Override
    public ArrayList<Item> getMenu() throws RemoteException{
        return modelFactory.getMenuModel().getMenu();
    }

    @Override
    public ArrayList<Order> getOrders() throws RemoteException {
        return null; //modelFactory.getOrderModel().getOrders();
    }

    @Override
    public void completeOrder(int id) throws RemoteException {

    }

    @Override
    public int getIdForOrder() throws RemoteException {
        return -1;
    }

    @Override
    public void makeOrder(Order order) throws RemoteException {

    }
}
