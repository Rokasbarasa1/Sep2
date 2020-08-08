package main.client.model.orderScreen;

import main.client.clientNetworking.orderScreen.IOrderScreenClient;
import main.shared.Item;
import main.shared.Order;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class OrderScreenModel implements IOrderScreenModel{
    private IOrderScreenClient client;
    private PropertyChangeSupport orderUpdateSupport = new PropertyChangeSupport(this);

    public OrderScreenModel(IOrderScreenClient client) {
        this.client = client;
        client.addPropertyChangeListener(evt -> newOrderOrStatusUpdate());
    }

    public ArrayList<Order> getOrdersTemp(){
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<Item>();
        Ingredient tomato = new Ingredient("tomato");
        Ingredient cheese = new Ingredient("cheese");
        Ingredient lettuce = new Ingredient("lettuce");
        Ingredient potato = new Ingredient("potato");
        Ingredient almond = new Ingredient("almond");
        Ingredient mayo = new Ingredient("mayo");
        Ingredient basil = new Ingredient("basil");
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(tomato);
        ingredients.add(cheese);
        ingredients.add(lettuce);
        ingredients.add(potato);
        ingredients.add(almond);
        ingredients.add(mayo);
        ingredients.add(basil);
        Item item1 = new Item("Potato salad", true,ingredients,29.99,"Kaka");
        Item item2 = new Item("Pork salad", true,ingredients,44.99,"Kaka");
        Item item3 = new Item("Cessars salad", true,ingredients,10.99,"Kaka");
        Item item4 = new Item("Esternato salad", true,ingredients,9.99,"Kaka");
        Item item5 = new Item("Mushroom salad", true,ingredients,19.99,"Kaka");
        Item item6 = new Item("Beet salad", true,ingredients,0.99,"Kaka");
        Item item7 = new Item("Chicken salad", true,ingredients,99.99,"Kaka");
        Item item8 = new Item("Fish salad", true,ingredients,49.99,"Kaka");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);
        for (int i = 0; i < 35; i++) {
            Order order = new Order(i, items);
            orders.add(order);
        }
        orders.get(2).setFinished(true);
        orders.get(3).setFinished(true);
        return orders;
    }

    @Override
    public ArrayList<Order> getOrders() {
        //return client.getOrders();
        return getOrdersTemp();
    }

    public void newOrderOrStatusUpdate(){
        orderUpdateSupport.firePropertyChange("Updated order list", null, null);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        orderUpdateSupport.addPropertyChangeListener(listener);
    }
}
