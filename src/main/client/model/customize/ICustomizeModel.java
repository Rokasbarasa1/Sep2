package main.client.model.customize;

import main.shared.Ingredient;

import java.util.ArrayList;

public interface ICustomizeModel {
    ArrayList<Ingredient> getIngredients();

    String getItemName();
}
