package main.client.clientNetworking;


public class ClientFactory {
    private HTTPHandler httpHandler; // Replace

    public ClientFactory(HTTPHandler httpHandler){
        this.httpHandler = httpHandler;
    }

    public ILoginClient loginClient() {
        if(loginClient == null)
            loginClient = new LoginClient(httpHandler);
        return loginClient;
    }
}
