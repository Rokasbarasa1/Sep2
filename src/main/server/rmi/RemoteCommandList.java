package main.server.rmi;

import main.client.clientNetworking.rmi.RemoteSender;
import main.shared.Item;
import main.shared.Order;
import main.shared.Receptionist;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteCommandList extends Remote {
    String login(Receptionist loginCarrier, RemoteSender sender) throws RemoteException;    // I send you a receptionist class that only has username and password set. You check those and send me back a string like this if it is ok "Login successful;213". The number after the ";" is the id of the user, that is important to me.
    Receptionist getReceptionistById(int userId) throws RemoteException;                    // Give me the receptionist with all the values in it that has this id.
    ArrayList<Item> getMenu() throws RemoteException;                                       // Give me all the items that are in the database... the menu
    ArrayList<Order> getIncompleteOrders() throws RemoteException;                          // Give all the unfinished orders
    ArrayList<Order> getOrders(RemoteSender sender) throws RemoteException;                 // Give me all the orders, finished or unfinished
    void completeOrder(int id) throws RemoteException;                                      // Set the complete status of this order to true
    int getIdForOrder() throws RemoteException;                                             // I dont know which id is taken or not. I need you to give my order an id.
    String makeOrder(Order order) throws RemoteException;                                     // Put the order into the orderModel order list. Basicaly new order
    void closeConnection(RemoteSender clientRMIHandler) throws RemoteException;             // Removes Remote senders from list
    String createItem(Item createdItem) throws RemoteException;                             // Create the item,  and if it was created give me "OK" as string back
    void deleteItem(int id) throws RemoteException;                                         // Delete the item by specified id and the delete the ItemIngredient things for it.
}
