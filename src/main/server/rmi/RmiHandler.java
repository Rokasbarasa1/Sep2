package main.server.rmi;

import main.client.clientNetworking.rmi.RemoteSender;
import main.server.model.ModelFactory;
import main.shared.Item;
import main.shared.Order;
import main.shared.Receptionist;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RmiHandler implements RemoteCommandList {
    private ModelFactory modelFactory;
    private ArrayList<RemoteSender> orderScreens;
    private ArrayList<RemoteSender> receptionists;

    public RmiHandler(ModelFactory modelFactory) throws RemoteException{
        UnicastRemoteObject.exportObject(this, 0);
        this.modelFactory = modelFactory;
        modelFactory.getOrderModel().setRmiHandler(this);
        orderScreens = new ArrayList<>();
        receptionists = new ArrayList<>();
    }

    @Override
    public String login(Receptionist loginCarrier, RemoteSender sender) throws RemoteException {
        System.out.println("Loging int" + loginCarrier.getPassword()+" "+loginCarrier.getUsername());
        if(!receptionists.contains(sender))
            receptionists.add(sender);
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
        return modelFactory.getOrderModel().getUnfinishedOrders();
    }

    @Override
    public ArrayList<Order> getOrders(RemoteSender sender) throws RemoteException {
        System.out.println("Getting orders");
        if(!orderScreens.contains(sender))
            orderScreens.add(sender);
        return modelFactory.getOrderModel().getOrders();
    }

    @Override
    public String completeOrder(int id) throws RemoteException {
        System.out.println("Setting order status to complete");
        return modelFactory.getOrderModel().completeID(id);
    }

    @Override
    public int getIdForOrder() throws RemoteException {
        System.out.println("Getting an id for order");
        return modelFactory.getOrderModel().getIdForOrder();
    }

    @Override
    public String makeOrder(Order order) throws RemoteException {
        System.out.println("Making order");
        return modelFactory.getOrderModel().makeOrder(order);
    }

    @Override
    public void closeConnection(RemoteSender clientRMIHandler) throws RemoteException {
        System.out.println("Removing user form update list");
        if(receptionists.contains(clientRMIHandler)){
            receptionists.remove(clientRMIHandler);
        }
        else if(orderScreens.contains(clientRMIHandler)){
            orderScreens.remove(clientRMIHandler);
        }
    }

    @Override
    public String createItem(Item createdItem) throws RemoteException {
        System.out.println("Creating item");
        return modelFactory.getMenuModel().addItemToMenu(createdItem);
    }

    @Override
    public String deleteItem(int id) throws RemoteException {
        System.out.println("Deleting item " + id);
        return modelFactory.getMenuModel().deleteItemFromMenu(id);
    }

    @Override
    public void testConnection() throws RemoteException {
    }

    public void sendUpdateToReceptionists(){
        for (int i = 0; i < receptionists.size(); i++) {
            try {
                receptionists.get(i).newOrder();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendUpdateToOrderScreens(){
        for (int i = 0; i < orderScreens.size(); i++) {
            try {
                orderScreens.get(i).newOrderOrStatusUpdate();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
