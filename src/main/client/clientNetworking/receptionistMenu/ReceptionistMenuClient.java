package main.client.clientNetworking.receptionistMenu;

import main.client.clientNetworking.ClientRMIHandler;
import main.shared.Receptionist;

public class ReceptionistMenuClient implements IReceptionistMenuClient {
    private ClientRMIHandler rmiHandler;

    public ReceptionistMenuClient(ClientRMIHandler rmiHandler) {
        this.rmiHandler = rmiHandler;
    }

    @Override
    public Receptionist getReceptionist(int userId) {
        return rmiHandler.getReceptionistById(userId);
    }
}
