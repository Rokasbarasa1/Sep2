package main.client.viewModel;


import main.client.model.receptionistMenu.IReceptionistMenuModel;
import main.shared.Item;

import java.util.ArrayList;

public class ReceptionistMenuViewModel {
    private IReceptionistMenuModel model;

    public ReceptionistMenuViewModel(IReceptionistMenuModel receptionistMenuModel) {
        this.model = receptionistMenuModel;
    }

    public void loadReceptionist() {
        model.loadReceptionist();
    }

    public ArrayList<Item> getMenu() {
        return model.getMenu();
    }
}
