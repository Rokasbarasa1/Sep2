package main.shared;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private String name;
    private double price;

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public double getPrice(){return price; }

    @Override
    public String toString(){
        return ", " + name;
    }
}
