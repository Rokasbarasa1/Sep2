package main.server.persistence.ingredient;

import main.shared.Ingredient;
import java.util.ArrayList;

public interface IIngredientDAO {
    ArrayList<Ingredient> getIngredientsByItemId(int id);
    boolean createIngredient(Ingredient ingredient);
    boolean checkIfIngredientExists(Ingredient ingredient);
    int getIngredientID(Ingredient ingredient);
}
