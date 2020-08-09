package main.client.clientNetworking;

import main.client.clientNetworking.card.CardClient;
import main.client.clientNetworking.card.ICardClient;
import main.client.clientNetworking.createItem.CreateItemClient;
import main.client.clientNetworking.createItem.ICreateItemClient;
import main.client.clientNetworking.customerMenu.CustomerMenuClient;
import main.client.clientNetworking.customerMenu.ICustomerMenuClient;
import main.client.clientNetworking.login.ILoginClient;
import main.client.clientNetworking.login.LoginClient;
import main.client.clientNetworking.orderScreen.IOrderScreenClient;
import main.client.clientNetworking.orderScreen.OrderScreenClient;
import main.client.clientNetworking.receptionistMenu.IReceptionistMenuClient;
import main.client.clientNetworking.receptionistMenu.ReceptionistMenuClient;
import main.client.clientNetworking.rmi.ClientRMIHandler;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientFactory {
    private ClientRMIHandler rmiHandler;
    private ILoginClient login;
    private IReceptionistMenuClient receptionistMenu;
    private ICustomerMenuClient customerMenu;
    private IOrderScreenClient orderScreen;
    private ICardClient card;
    private ICreateItemClient createItem;

    public ClientFactory(){
        try {
            rmiHandler = new ClientRMIHandler();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    public ILoginClient loginClient() {
        if(login == null)
            login = new LoginClient(rmiHandler);
        return login;
    }

    public IReceptionistMenuClient receptionistMenuClient() {
        if(receptionistMenu == null)
            receptionistMenu = new ReceptionistMenuClient(rmiHandler);
        return receptionistMenu;
    }

    public ICustomerMenuClient customerMenuClient() {
        if(customerMenu == null)
            customerMenu = new CustomerMenuClient(rmiHandler);
        return customerMenu;
    }

    public IOrderScreenClient orderScreenClient() {
        if(orderScreen == null)
            orderScreen = new OrderScreenClient(rmiHandler);
        return orderScreen;
    }

    public ICardClient cardClient() {
        if(card == null)
            card = new CardClient(rmiHandler);
        return card;
    }

    public ICreateItemClient createItemClient() {
        if(createItem == null)
            createItem = new CreateItemClient(rmiHandler);
        return createItem;
    }

    public void closeConnection() {
        rmiHandler.closeConnection();
    }
}
