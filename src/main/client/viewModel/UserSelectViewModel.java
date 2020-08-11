package main.client.viewModel;

import main.client.model.userSelect.IUserSelectModel;

public class UserSelectViewModel {
    private IUserSelectModel model;
    public UserSelectViewModel(IUserSelectModel userSelectModel) {
        model = userSelectModel;
    }

    public boolean testConnection() {
        return model.testConnection();
    }
}
