package main.server;

import main.server.network.DatabaseSocketHandler;
import main.server.persistence.DAOFactory;
import main.server.persistence.database.DBConnection;
import main.server.persistence.database.IDBConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServer {

    public static void main(String[] args){
        IDBConnection connect = new DBConnection();
        DAOFactory DAOFactory = new DAOFactory(connect);
        System.out.println("Server started");
        try {
            connect.getConnection();
            ServerSocket serverSocket = new ServerSocket(4343, 10);
            int i = 0;
            while(true){
                Socket connectionSocket = serverSocket.accept();
                DatabaseSocketHandler c = new DatabaseSocketHandler(connectionSocket, DAOFactory);
                new Thread(c, "Business Server " + i).start();
                System.out.println("Connected to Business server " + i);
                i++;
            }
        }catch (IOException e) {
            System.out.println("Error occurred during connection to database");
            e.printStackTrace();
        }
    }
}
