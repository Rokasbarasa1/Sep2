package main.server.network;


import main.server.persistence.DAOFactory;

import java.io.IOException;
import java.net.Socket;

public class DatabaseSocketHandler implements Runnable {
    private Socket socket;
    private OutputStream outToClient;
    private InputStream inFromClient;
    private DAOFactory daoFactory;

    public DatabaseSocketHandler(Socket socket, DAOFactory daoFactory){
        this.socket = socket;
        this.daoFactory = daoFactory;
        try {
            inFromClient = socket.getInputStream();
            outToClient = socket.getOutputStream();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {
                byte[] lenBytes = new byte[4];
                inFromClient.read(lenBytes, 0, 4);
                int len = (((lenBytes[3] & 0xff) << 24) | ((lenBytes[2] & 0xff) << 16) |
                        ((lenBytes[1] & 0xff) << 8) | (lenBytes[0] & 0xff));
                byte[] receivedBytes = new byte[len];

                inFromClient.read(receivedBytes, 0, len);
                String received = new String(receivedBytes, 0, len);
                String[] receivedPieces = received.split(";");

                if(receivedPieces[0].equals("Check")){
                    sendToClient("Check");
                }else if(receivedPieces[0].equals("Login")){
                    User login = gson.fromJson(receivedPieces[1], User.class);
                    String confirmation = daoFactory.getLoginDAO().validateLogin(login);
                    sendToClient(confirmation);
                }
                else if(receivedPieces[0].equals("CalendarMonth")) {

                }
                else if(receivedPieces[0].equals("GetUser")) {

                }
                else if(receivedPieces[0].equals("PostUser")) {

                }
                else if (receivedPieces[0].equals("PostShift")) {

                }
                else if(receivedPieces[0].equals("GetManagedUsers")){

                }else if(receivedPieces[0].equals("DeleteShift")){

                }else if(receivedPieces[0].equals("DeleteUser")){

                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendToClient(String toSend){
        try {
            byte[] toSendBytes = toSend.getBytes();
            int toSendLen = toSendBytes.length;
            byte[] toSendLenBytes = new byte[4];
            toSendLenBytes[0] = (byte)(toSendLen & 0xff);
            toSendLenBytes[1] = (byte)((toSendLen >> 8) & 0xff);
            toSendLenBytes[2] = (byte)((toSendLen >> 16) & 0xff);
            toSendLenBytes[3] = (byte)((toSendLen >> 24) & 0xff);
            outToClient.write(toSendLenBytes);
            outToClient.write(toSendBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
