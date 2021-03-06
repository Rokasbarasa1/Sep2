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
    private CreateItemViewModel createItem;
    private CustomizeViewModel customize;
    private UserSelectViewModel userSelect;

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

    public CreateItemViewModel getCreateItemViewModel() {
        if(createItem == null)
            createItem = new CreateItemViewModel(modelFactory.createItemModel());
        return createItem;
    }

    public CustomizeViewModel getCustomizeViewModel() {
        if(customize == null)
            customize = new CustomizeViewModel(modelFactory.customizeModel());
        return customize;
    }

    public UserSelectViewModel getUserSelectViewModel() {
        if(userSelect == null)
            userSelect = new UserSelectViewModel(modelFactory.userSelectModel());
        return userSelect;
    }
}
