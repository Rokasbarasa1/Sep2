package main.client.clientNetworking;

import main.shared.Receptionist;
import main.shared.RemoteCommandList;
import main.shared.RemoteSender;

import java.rmi.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ClientRMIHandler implements RemoteSender {
    private RemoteCommandList rml;
    private boolean connected;
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
    public void replyMessage(String message) throws RemoteException {

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
}
