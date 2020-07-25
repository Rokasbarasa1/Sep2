package main.client.clientNetworking.receptionistMenu;

import main.shared.Item;
import main.shared.Receptionist;

import java.util.ArrayList;

public interface IReceptionistMenuClient {
    Receptionist getReceptionist(int currentUser);
    ArrayList<Item> getMenu();
}
