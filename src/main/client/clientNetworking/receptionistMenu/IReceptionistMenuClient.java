package main.client.clientNetworking.receptionistMenu;

import main.shared.Receptionist;

public interface IReceptionistMenuClient {
    Receptionist getReceptionist(int currentUser);
}
