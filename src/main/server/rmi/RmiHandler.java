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
        System.out.println("Getting receptionist");
        return modelFactory.getLoginModel().getReceptionistById(userId);
    }

    @Override
    public ArrayList<Item> getMenu() throws RemoteException{
        System.out.println("Geting the menu");
        return modelFactory.getMenuModel().getMenu();
    }

    @Override
    public ArrayList<Order> getIncompleteOrders() throws RemoteException {
        System.out.println("Getting incomplete orders");
        return null;
    }

    @Override
    public ArrayList<Order> getOrders() throws RemoteException {
        System.out.println("Getting orders");
        return null; //modelFactory.getOrderModel().getOrders();
    }

    @Override
    public void completeOrder(int id) throws RemoteException {
        System.out.println("Setting order status to complete");

    }

    @Override
    public int getIdForOrder() throws RemoteException {
        System.out.println("Getting an id for order");
        return -1;
    }

    @Override
    public void makeOrder(Order order) throws RemoteException {

    }
}
