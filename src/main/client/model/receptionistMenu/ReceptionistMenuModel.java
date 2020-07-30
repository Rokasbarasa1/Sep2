package main.client.model.receptionistMenu;

import main.client.clientNetworking.receptionistMenu.IReceptionistMenuClient;
import main.client.model.login.ILoginModel;
import main.shared.Ingredient;
import main.shared.Item;
import main.shared.Order;
import main.shared.Receptionist;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ReceptionistMenuModel implements IReceptionistMenuModel{
    private Receptionist currentUser;
    private IReceptionistMenuClient client;
    private ILoginModel loginModel;
    private PropertyChangeSupport newOrderSupport = new PropertyChangeSupport(this);
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public ReceptionistMenuModel(IReceptionistMenuClient receptionistMenuClient, ILoginModel login) {
        client = receptionistMenuClient;
        loginModel = login;
        client.addPropertyChangeListener(evt -> newOrder());
    }

    @Override
    public void loadReceptionist() {
        currentUser = client.getReceptionist(loginModel.getCurrentUser().getID());
    }

    public ArrayList<Item> getMenuTemp(){
        ArrayList<Item> list = new ArrayList<Item>();
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
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);
        list.add(item6);
        list.add(item7);
        list.add(item8);
        menu = list;
        return list;
    }

    @Override
    public ArrayList<Item> getMenu() {
        //menu = client.getMenu();
        return getMenuTemp();
    }

    @Override
    public ArrayList<Order> getOrders() {
        orders = client.getOrders();
        return orders;
    }

    @Override
    public void completeOrder(int id) {
        client.completeOrder(id);
    }

    public void newOrder(){
        newOrderSupport.firePropertyChange("New Order", null, null);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        newOrderSupport.addPropertyChangeListener(listener);
    }
}
