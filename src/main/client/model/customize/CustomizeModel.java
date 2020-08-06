package main.client.model.customize;

import main.client.model.cart.ICartModel;
import main.shared.Ingredient;

import java.util.ArrayList;

public class CustomizeModel implements ICustomizeModel{
    private ICartModel cartModel;
    public CustomizeModel(ICartModel cartModel) {
        this.cartModel = cartModel;
    }

    @Override
    public ArrayList<Ingredient> getIngredients() {
        return cartModel.getCustomizeItem().getIngredientsList();
    }

    @Override
    public String getItemName() {
        return cartModel.getCustomizeItem().getName();
    }
}
