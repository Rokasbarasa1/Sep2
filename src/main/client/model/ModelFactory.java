package main.client.model;

import com.sun.security.ntlm.Client;
import main.client.clientNetworking.ClientFactory;
import main.client.clientNetworking.card.ICardClient;
import main.client.clientNetworking.receptionistMenu.IReceptionistMenuClient;
import main.client.model.card.CardModel;
import main.client.model.card.ICardModel;
import main.client.model.cart.CartModel;
import main.client.model.cart.ICartModel;
import main.client.model.customerMenu.CustomerMenuModel;
import main.client.model.customerMenu.ICustomerMenuModel;
import main.client.model.login.ILoginModel;
import main.client.model.login.LoginModel;
import main.client.model.orderScreen.IOrderScreenModel;
import main.client.model.orderScreen.OrderScreenModel;
import main.client.model.receptionistMenu.IReceptionistMenuModel;
import main.client.model.receptionistMenu.ReceptionistMenuModel;

public class ModelFactory {
    private ClientFactory clientFactory;
    private ILoginModel login;
    private IReceptionistMenuModel receptionistMenu;
    private ICustomerMenuModel customerMenu;
    private ICartModel cart;
    private IOrderScreenModel orderScreen;
    private ICardModel card;

    public ModelFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public ILoginModel loginModel() {
        if(login == null)
            login = new LoginModel(clientFactory.loginClient());
        return login;
    }

    public IReceptionistMenuModel receptionistMenuModel() {
        if(receptionistMenu == null)
            receptionistMenu = new ReceptionistMenuModel(clientFactory.receptionistMenuClient(),loginModel());
        return receptionistMenu;
    }

    public ICustomerMenuModel customerMenuModel() {
        if(customerMenu == null)
            customerMenu = new CustomerMenuModel(clientFactory.customerMenuClient());
        return customerMenu;
    }

    public ICartModel cartModel() {
        if(cart == null)
            cart = new CartModel(customerMenuModel(), clientFactory.cartClient());
        return cart;
    }

    public IOrderScreenModel orderScreenModel() {
        if(orderScreen == null)
            orderScreen = new OrderScreenModel(clientFactory.orderScreenClient());
        return orderScreen;
    }

    public ICardModel cardModel() {
        if(card == null)
            card = new CardModel(clientFactory.cardClient(), customerMenuModel(), cartModel());
        return card;
    }
}
