package main.client.clientNetworking;

import main.client.clientNetworking.cart.CartClient;
import main.client.clientNetworking.cart.ICartClient;
import main.client.clientNetworking.customerMenu.CustomerMenuClient;
import main.client.clientNetworking.customerMenu.ICustomerMenuClient;
import main.client.clientNetworking.login.ILoginClient;
import main.client.clientNetworking.login.LoginClient;
import main.client.clientNetworking.receptionistMenu.IReceptionistMenuClient;
import main.client.clientNetworking.receptionistMenu.ReceptionistMenuClient;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientFactory {
    private ClientRMIHandler rmiHandler;
    private ILoginClient login;
    private IReceptionistMenuClient receptionistMenu;
    private ICustomerMenuClient customerMenu;
    private ICartClient cart;

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

    public ICartClient cartClient() {
        if(cart == null)
            cart = new CartClient(rmiHandler);
        return cart;
    }

    public void closeConnection() {
        //socketHandler.closeConnection();
    }
}
