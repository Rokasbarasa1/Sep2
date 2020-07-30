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

public class ClientRMIHandler implements RemoteSender, PropertyChangeSubject {
    private RemoteCommandList rml;
    private boolean connected;
    private PropertyChangeSupport newOrderSupport = new PropertyChangeSupport(this);

    public ClientRMIHandler() throws RemoteException, NotBoundException {
        try{
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            UnicastRemoteObject.exportObject(this, 0);
            rml = (RemoteCommandList)reg.lookup("point of sales");
            connected = true;
        }catch (ConnectException e){
            connected = false;
            e.printStackTrace();
        }
    }

    @Override
    public void newOrder() throws RemoteException {
        newOrderSupport.firePropertyChange("New Order", null, null);
    }

    public void retryConnection(){
        try{
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            UnicastRemoteObject.exportObject(this, 0);
            rml = (RemoteCommandList)reg.lookup("point of sales");
            connected = true;
        }catch (RemoteException |NotBoundException e){
            connected = false;
            e.printStackTrace();
        }
    }

    public String login(Receptionist loginCarrier) {
        if(!connected){
            retryConnection();
            if(!connected){
                return "Failed to connect to server";
            }
        }

        try {
            return rml.login(loginCarrier);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }

    public Receptionist getReceptionistById(int userId) {
        try {
            return rml.getReceptionistById(userId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Item> getMenu() {
        if(!connected){
            retryConnection();
            if(!connected){
                //return "Failed to connect to server";
            }
        }
        try {
            return rml.getMenu();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Order> getOrders() {
        try {
            return rml.getOrders();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void completeOrder(int id) {
        try {
            rml.completeOrder(id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int getIdForOrder() {
        /*try {
            return rml.getIdForOrder();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

         */
        return 20;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        newOrderSupport.addPropertyChangeListener(listener);
    }

    public void makeOrder(Order order) {
        /*
        try {
            rml.makeOrder(order);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
         */
    }
}
