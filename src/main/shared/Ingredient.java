package main.shared;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private String name;
    private int counter;

    public Ingredient(String name) {
        counter = 1;
        this.name = name;
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
