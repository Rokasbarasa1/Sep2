package main.client.viewModel;

import main.client.model.ModelFactory;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    private LoginViewModel login;
    private ReceptionistMenuViewModel receptionist;
    private CustomerMenuViewModel customerMenu;
    private CartViewModel cart;
    private OrderScreenViewModel orderScreen;
    private CardViewModel card;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginViewModel getLoginViewModel() {
        if(login == null)
            login = new LoginViewModel(modelFactory.loginModel());
        return login;
    }

    public ReceptionistMenuViewModel getReceptionistMenuViewModel() {
        if (receptionist == null)
            receptionist = new ReceptionistMenuViewModel(modelFactory.receptionistMenuModel());
        return receptionist;
    }

    public CustomerMenuViewModel getCustomerMenuViewModel() {
        if(customerMenu == null)
            customerMenu = new CustomerMenuViewModel(modelFactory.customerMenuModel());
        return customerMenu;
    }

    public CartViewModel getCartViewModel() {
        if(cart == null)
            cart = new CartViewModel(modelFactory.cartModel());
        return cart;
    }

    public OrderScreenViewModel getorderScreenViewModel() {
        if(orderScreen == null)
            orderScreen = new OrderScreenViewModel(modelFactory.orderScreenModel());
        return orderScreen;
    }

    public CardViewModel getCardViewModel() {
        if(card == null)
            card = new CardViewModel(modelFactory.cardModel());
        return card;
    }

}
