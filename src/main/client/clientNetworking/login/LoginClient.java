package main.client.clientNetworking.login;
import main.client.clientNetworking.ClientRMIHandler;
import main.shared.Receptionist;

public class LoginClient implements ILoginClient {
    private ClientRMIHandler rmiHandler;

    public LoginClient(ClientRMIHandler rmiHandler) {
        this.rmiHandler = rmiHandler;
    }

    @Override
    public String Login(Receptionist loginCarrier) {
        return rmiHandler.login(loginCarrier);
    }
}
