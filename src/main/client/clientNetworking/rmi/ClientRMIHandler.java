package main.client.clientNetworking.rmi;

import main.server.rmi.RemoteCommandList;
import main.shared.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ClientRMIHandler implements RemoteSender{
    private RemoteCommandList rml;
    private PropertyChangeSupport newOrderSupport = new PropertyChangeSupport(this);
    private PropertyChangeSupport orderUpdateSupport = new PropertyChangeSupport(this);

    public ClientRMIHandler() throws RemoteException, NotBoundException {
        try{
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            UnicastRemoteObject.exportObject(this, 0);
            rml = (RemoteCommandList)reg.lookup("point of sales");
        }catch (ConnectException e){
            System.out.println("Connection failed");
        }
    }

    @Override
    public void newOrder(){
        newOrderSupport.firePropertyChange("New Order", null, null);
    }

    @Override
    public void newOrderOrStatusUpdate(){
        orderUpdateSupport.firePropertyChange("Updated order list", null, null);
    }

    public void retryConnection() throws RemoteException, NotBoundException, ConnectException{
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            //UnicastRemoteObject.exportObject(this, 0);
            try {
                rml = (RemoteCommandList)reg.lookup("point of sales");
            } catch (ConnectException e){
                throw new ConnectException("Not working connection");
            }
    }

    public String login(Receptionist loginCarrier) {
        try {
            return rml.login(loginCarrier, this);
        } catch (RemoteException | NullPointerException e) {
            System.out.println("Retry connection");
            try {
                retryConnection();
                return rml.login(loginCarrier, this);
            }catch (RemoteException | NotBoundException i){
                i.printStackTrace();
                return "Failed to connect to server";
            }
        }
    }

    public Receptionist getReceptionistById(int userId) {
        try {
            return rml.getReceptionistById(userId);
        } catch (RemoteException e) {
            System.out.println("Retry connection");
            try {
                retryConnection();
                return rml.getReceptionistById(userId);
            }catch (RemoteException | NotBoundException i){
                i.printStackTrace();
                return null;
            }
        }
    }

    public ArrayList<Item> getMenu() {
        try {
            return rml.getMenu();
        } catch (RemoteException | NullPointerException e) {
            System.out.println("Retry connection");
            try {
                retryConnection();
                return rml.getMenu();
            }catch (RemoteException | NotBoundException i){
                i.printStackTrace();
                return null;
            }
        }
    }

    public ArrayList<Order> getOrders() {
        try {
            return rml.getOrders(this);
        } catch (RemoteException e) {
            System.out.println("Retry connection");
            try {
                retryConnection();
                return rml.getOrders(this);
            }catch (RemoteException | NotBoundException i){
                i.printStackTrace();
                return null;
            }
        }
    }

    public String completeOrder(int id) {
        try {
            return rml.completeOrder(id);
        } catch (RemoteException e) {
            System.out.println("Retry connection");
            try {
                retryConnection();
                return rml.completeOrder(id);
            }catch (RemoteException | NotBoundException i){
                i.printStackTrace();
                return "Failed to connect to server";
            }
        }
    }

    public int getIdForOrder() {
        try {
            return rml.getIdForOrder();
        } catch (RemoteException e) {
            System.out.println("Retry connection");
            try {
                retryConnection();
                return rml.getIdForOrder();
            }catch (RemoteException | NotBoundException i){
                i.printStackTrace();
                return -1;
            }
        }
    }

    public String makeOrder(Order order) {
        try {
            return rml.makeOrder(order);
        } catch (RemoteException e) {
            System.out.println("Retry connection");
            try {
                retryConnection();
                return rml.makeOrder(order);
            }catch (Exception i){
                i.printStackTrace();
                return "No connection to server";
            }
        }
    }

    public ArrayList<Order> getIncompleteOrders() {
        try {
            return rml.getIncompleteOrders();
        } catch (RemoteException e) {
            System.out.println("Retry connection");
            try {
                retryConnection();
                return rml.getIncompleteOrders();
            }catch (RemoteException | NotBoundException i){
                i.printStackTrace();
                return null;
            }
        }
    }

    public String createItem(Item createdItem) {
        try {
            return rml.createItem(createdItem);
        } catch (RemoteException e) {
            try {
                retryConnection();
                return rml.createItem(createdItem);
            }catch (Exception i){
                i.printStackTrace();
                return "Failed to connect";
            }
        }
    }

    public String deleteItem(int id) {
        try {
            return rml.deleteItem(id);
        } catch (RemoteException e) {
            System.out.println("Retry connection");
            try {
                retryConnection();
                return rml.deleteItem(id);
            }catch (RemoteException | NotBoundException i){
                i.printStackTrace();
                return "Failed to connect to server";
            }
        }
    }

    public void closeConnection() {
        try {
            rml.closeConnection(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void addPropertyChangeListenerNewOrder(PropertyChangeListener listener) {
        newOrderSupport.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListenerOrderListUpdate(PropertyChangeListener listener) {
        orderUpdateSupport.addPropertyChangeListener(listener);
    }
}
