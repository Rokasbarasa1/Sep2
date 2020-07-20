package main.client.clientNetworking;


public class ClientFactory {
    private ClientSocketHandler socketHandler; // Replace

    public ClientFactory(ClientSocketHandler socketHandler){
        this.socketHandler = socketHandler;
    }

    public ILoginClient loginClient() {
        if(loginClient == null)
            loginClient = new LoginClient(httpHandler);
        return loginClient;
    }
}
