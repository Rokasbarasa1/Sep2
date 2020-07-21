package main.client.model.login;

import main.client.clientNetworking.login.ILoginClient;
import main.shared.Receptionist;

public class LoginModel implements ILoginModel{
    private ILoginClient loginClient;
    private Receptionist currentUser;
    private String response;

    public LoginModel(ILoginClient loginClient) {
        this.loginClient = loginClient;
    }

    @Override
    public void Login(String username, String password) {
        Receptionist loginCarrier = new Receptionist(username,password);
        String answer = loginClient.Login(loginCarrier);
        String[] splitAnswer = answer.split(";");
        if(splitAnswer[0].equals("Login successful")){
            loginCarrier.setID(Integer.parseInt(splitAnswer[1]));
            currentUser = loginCarrier;
            response = splitAnswer[0];
        }else{
            response = answer;
        }
    }

    @Override
    public String loginResponse() {
        return response;
    }
    @Override
    public Receptionist getCurrentUser() {
        return currentUser;
    }
}
