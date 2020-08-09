package main.shared;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private String name;
    private double price;
    private int counter;

    public Ingredient(String name) {
        counter = 1;
        this.name = name;
        price = 0;
    }

    public Ingredient(String name, double price) {
        counter = 1;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        if(counter == 0){
            return "";
        }else if(counter == 1){
            return name + ", ";
        }else {
            return + counter + " " + name + ", ";
        }
    }
    
}
