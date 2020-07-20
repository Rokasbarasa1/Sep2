package main.client;

import javafx.application.Application;
import javafx.stage.Stage;
import main.client.clientNetworking.ClientFactory;
import main.client.clientNetworking.HTTPHandler;
import main.client.model.ModelFactory;
import main.client.view.ViewHandler;
import main.client.viewModel.ViewModelFactory;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        HTTPHandler httpHandler = new HTTPHandler();
        ClientFactory clientFactory = new ClientFactory(httpHandler);
        ModelFactory modelFactory = new ModelFactory(clientFactory);
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
        viewHandler.start();
    }

    //this is a comment to check if the branch is working
}
