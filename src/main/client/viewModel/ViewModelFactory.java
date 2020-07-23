package main.client.viewModel;

import main.client.model.ModelFactory;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    private LoginViewModel loginViewModel;
    private ReceptionistMenuViewModel receptionistMenuViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginViewModel getLoginViewModel() {
        if(loginViewModel == null)
            loginViewModel = new LoginViewModel(modelFactory.loginModel());
        return loginViewModel;
    }

    public ReceptionistMenuViewModel getReceptionistMenuViewModel() {
        if(receptionistMenuViewModel == null)
            receptionistMenuViewModel = new ReceptionistMenuViewModel(modelFactory.receptionistMenuModel());
        return receptionistMenuViewModel;
    }
    /*
    public LoginViewModel getLoginViewModel() {
        if(loginViewModel == null)
            loginViewModel = new LoginViewModel(modelFactory.loginModel());
        return loginViewModel;
    }

     */
}
