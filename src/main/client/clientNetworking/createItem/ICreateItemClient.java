package main.client.clientNetworking.createItem;

import main.shared.Item;

public interface ICreateItemClient {
    String createItem(Item createdItem);
    boolean testConnection();
}
