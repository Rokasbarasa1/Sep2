package main.client.viewModel;

import main.client.model.login.ILoginModel;
import main.client.model.receptionistMenu.IReceptionistMenuModel;

public class ReceptionistMenuViewModel {
    private IReceptionistMenuModel model;

    public ReceptionistMenuViewModel(IReceptionistMenuModel receptionistMenuModel) {
        this.model = receptionistMenuModel;
    }

    public void loadReceptionist() {
        model.loadReceptionist();
    }
}
