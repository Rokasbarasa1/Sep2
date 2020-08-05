package main.client.viewModel;

import main.client.model.customize.ICustomizeModel;
import main.shared.Ingredient;

import java.util.ArrayList;

public class CustomizeViewModel {
    private ICustomizeModel model;
    public CustomizeViewModel(ICustomizeModel customizeModel) {
        this.model = customizeModel;
    }

    public ArrayList<Ingredient> getIngredients() {
        return model.getIngredients();
    }
}
