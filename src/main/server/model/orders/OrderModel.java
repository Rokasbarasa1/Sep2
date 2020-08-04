package main.server.model.orders;

import main.shared.Order;

import java.util.ArrayList;

public class OrderModel implements IOrderModel {
    private ArrayList<Order> orders;

    public OrderModel() {
        this.orders = new ArrayList<>();
    }


    @Override
    public ArrayList<Order> getOrders() {

        return orders;
    }

    @Override
    public ArrayList<Order> getUnfinishedOrders() {
        ArrayList<Order> unFinishedOrders = new ArrayList<>();
        for (int i = 0; i == orders.size(); i ++){
            if(orders.get(i).isFinished()==false){
                unFinishedOrders.add(orders.get(i));
            }

        }
        return unFinishedOrders;
    }

    @Override
    public int getIdForOrder(Order order) {

        int i = 0;
        while (i < 100) {
            i++;
            if (i == 100) {
                i = 0;
            }
        }
        return i;
    }

    @Override
    public void makeOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void completeID(int ID) {
        for (int i = 0; i < orders.size(); i++){
            if (orders.get(i).getID() == ID){
                orders.get(i).setFinished(true);
            }
        }
    }


}
