package main.client.model.createItem;

import main.client.clientNetworking.createItem.ICreateItemClient;
import main.shared.Ingredient;
import main.shared.Item;

import java.util.ArrayList;

public class CreateItemModel implements ICreateItemModel{
    private ICreateItemClient client;

    public CreateItemModel(ICreateItemClient itemClient) {
        client = itemClient;
    }

    @Override
    public String createItem(String name, boolean customizable, String ingredients, String price, String groupName) {
        if(!customizable){
            String[] ingredientsSplit = ingredients.split(", ");
            ArrayList<Ingredient> ingredientsArray = new ArrayList<>();
            for (int i = 0; i < ingredientsSplit.length; i++) {
                Ingredient ingredient = new Ingredient(ingredientsSplit[i]);
                ingredientsArray.add(ingredient);
            }
            double priceToDouble = Double.parseDouble(price);
            Item createdItem = new Item(name, customizable, ingredientsArray, priceToDouble, groupName);
            return client.createItem(createdItem);
        }else {
            String[] ingredientsSplit = ingredients.split(", ");
            ArrayList<Ingredient> ingredientsArray = new ArrayList<>();
            for (int i = 0; i < ingredientsSplit.length; i++) {
                String[] nameAndPrice = ingredientsSplit[i].split(" $");
                if(nameAndPrice.length == 2){
                    Ingredient ingredient = new Ingredient(nameAndPrice[0], Double.parseDouble(nameAndPrice[1]));
                    ingredientsArray.add(ingredient);
                }else {
                    Ingredient ingredient = new Ingredient(ingredientsSplit[0]);
                    ingredientsArray.add(ingredient);
                }
            }
            double priceToDouble = Double.parseDouble(price);
            Item createdItem = new Item(name, customizable, ingredientsArray, priceToDouble, groupName);
            return client.createItem(createdItem);
        }
    }
}
