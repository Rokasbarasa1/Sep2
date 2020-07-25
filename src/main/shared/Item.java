package main.shared;

import java.util.ArrayList;

public class Item {
    private String name;
    private boolean customizable;
    private ArrayList<Ingredient> ingredients;
    private double price;
    private String groupName;

    public Item(String name, boolean customizable, ArrayList<Ingredient> ingredients, double price, String groupName) {
        this.name = name;
        this.customizable = customizable;
        this.ingredients = ingredients;
        this.price = price;
        this.groupName = groupName;
    }

    public String getName() {
        return name;
    }

    public boolean isCustomizable() {
        return customizable;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public double getPrice() {
        return price;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getIngredientsString(){
        String ingredientString = "";
        for (int i = 0; i < ingredients.size(); i++) {
            ingredientString += " " + ingredients.get(i).getName();
        }
        return ingredientString;
    }

    @Override
    public String toString(){
        return name + ": " + getIngredientsString();
    }
}
