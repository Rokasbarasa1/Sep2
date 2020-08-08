package main.shared;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private String name;
    private double price;

    public Ingredient(String name) {
        this.name = name;
    }

    public double getPrice(){return price; }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString(){
        return ", " + name;
    }
}
