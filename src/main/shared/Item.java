package main.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Item implements Serializable {
    private int ID;
    private String name;
    private boolean customizable;
    private ArrayList<Ingredient> ingredients;
    private double price;
    private String groupName;

    public Item(int id, String name, boolean customizable, double price, String groupName) {
        this.ID = id;
        this.name = name;
        this.customizable = customizable;
        this.price = price;
        this.groupName = groupName;
    }

    public Item(String name, boolean customizable, ArrayList<Ingredient> ingredients, double price, String groupName) {
        this.name = name;
        this.customizable = customizable;
        this.ingredients = ingredients;
        this.price = price;
        this.groupName = groupName;
    }

    public Item(Item item) {
        this.ID = item.getID();
        this.name = item.getName();
        this.customizable = item.isCustomizable();
        this.ingredients = item.getIngredientsList();
        this.price = item.getPrice();
        this.groupName = item.getGroupName();
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public boolean isCustomizable() {
        return customizable;
    }

    public ArrayList<Ingredient> getIngredientsList() {

        return ingredients;
    }

    public double getPrice() {
        return price;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getIngredients(){
        String ingredientString = "";
        for (int i = 0; i < ingredients.size(); i++) {
            ingredientString += ingredients.get(i).toString();
        }
        return ingredientString;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString(){
        return name + ": " + getIngredients();
    }
}
