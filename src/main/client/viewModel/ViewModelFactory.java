package main.client.viewModel;


import main.client.model.ModelFactory;

public class ViewModelFactory {
    private ModelFactory modelFactory;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginViewModel getLoginViewModel() {
        if(loginViewModel == null)
            loginViewModel = new LoginViewModel(modelFactory.loginModel());
        return loginViewModel;
    }
}
