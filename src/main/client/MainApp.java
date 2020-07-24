package main.client;

import com.sun.security.ntlm.Client;
import javafx.application.Application;
import javafx.stage.Stage;
import main.client.clientNetworking.ClientFactory;
import main.client.model.ModelFactory;
import main.client.view.ViewHandler;
import main.client.viewModel.ViewModelFactory;

public class MainApp extends Application {
    ClientFactory clientFactory;
    @Override
    public void start(Stage stage) {
        clientFactory = new ClientFactory();
        ModelFactory modelFactory = new ModelFactory(clientFactory);
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
        viewHandler.start();
    }

    @Override
    public void stop() throws Exception{
        super.stop();
        clientFactory.closeConnection();
    }
    //this is a comment
}
