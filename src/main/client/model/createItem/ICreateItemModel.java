package main.client.model.createItem;

public interface ICreateItemModel {
    String createItem(String name, boolean customizable, String ingredients, String price, String groupName);
    boolean testConnection();
}
