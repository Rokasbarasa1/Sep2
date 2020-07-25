package main.client.viewModel;

import main.client.model.ModelFactory;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    private LoginViewModel login;
    private ReceptionistMenuViewModel receptionist;
    private CustomerMenuViewModel customerMenu;
    private CartViewModel cart;

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
}
