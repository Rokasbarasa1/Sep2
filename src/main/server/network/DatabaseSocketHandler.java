package main.server.network;


import main.server.persistence.DAOFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DatabaseSocketHandler implements Runnable {
    private Socket socket;
    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;
    private DAOFactory daoFactory;

    public DatabaseSocketHandler(Socket socket, DAOFactory daoFactory){
        this.socket = socket;
        this.daoFactory = daoFactory;
        try {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {

                String received = (String)inFromClient.readObject();
                String[] receivedPieces = received.split(";");

                if(receivedPieces[0].equals("Login")){
                    //User login = gson.fromJson(receivedPieces[1], User.class);
                    String confirmation = daoFactory.getLoginDAO().validateLogin(login);
                    outToClient.writeObject();//sendToClient(confirmation);
                }
                else if(receivedPieces[0].equals("CalendarMonth")) {

                }
                else if(receivedPieces[0].equals("GetUser")) {

                }
            }
        }catch (IOException| ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }

    public void sendToClient(String toSend){
        try {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
