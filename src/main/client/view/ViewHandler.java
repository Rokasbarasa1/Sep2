package main.client.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.client.view.cart.CartController;
import main.client.view.customerMenu.CustomerMenuController;
import main.client.view.login.LoginController;
import main.client.view.orderScreen.OrderScreenController;
import main.client.view.receptionistMenu.ReceptionistMenuController;
import main.client.view.userSelect.UserSelectController;
import main.client.viewModel.ViewModelFactory;
import java.io.IOException;


public class ViewHandler {
    private ViewModelFactory viewModelFactory;
    private Stage mainStage;
    private Scene loginScene;
    private Scene userSelectScene;
    private Scene customerMenuScene;
    private Scene orderScreenScene;
    private Scene receptionistMenuScene;
    private Scene cart;


    public ViewHandler(Stage stage, ViewModelFactory vmf) {
        viewModelFactory = vmf;
        mainStage = stage;
    }

    public void start() {
        openUserSelect();
        mainStage.show();
    }

    public void openUserSelect() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = getRootByPath("UserSelect/UserSelect.fxml", loader);
        UserSelectController controller = loader.getController();
        controller.init(this);
        userSelectScene = new Scene(root);
        mainStage.setTitle("User select");
        mainStage.setScene(userSelectScene);
    }

    public void openCustomerMenu() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = getRootByPath("CustomerMenu/CustomerMenu.fxml", loader);
        CustomerMenuController controller = loader.getController();
        controller.init(this, viewModelFactory.getCustomerMenuViewModel());
        customerMenuScene = new Scene(root);
        mainStage.setTitle("Menu");
        mainStage.setScene(customerMenuScene);
    }

    public void openOrderScreen() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = getRootByPath("OrderScreen/OrderScreen.fxml", loader);
        OrderScreenController controller = loader.getController();
        controller.init(this, viewModelFactory.getorderScreenViewModel());
        orderScreenScene = new Scene(root);
        mainStage.setTitle("Order screen");
        mainStage.setScene(orderScreenScene);
    }

    public void openReceptionistMenu() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = getRootByPath("ReceptionistMenu/ReceptionistMenu.fxml", loader);
        ReceptionistMenuController controller = loader.getController();
        controller.init(this, viewModelFactory.getReceptionistMenuViewModel());
        receptionistMenuScene = new Scene(root);
        mainStage.setTitle("Receptionist");
        mainStage.setScene(receptionistMenuScene);
    }

    public void openLogin() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = getRootByPath("Login/Login.fxml", loader);
        LoginController controller = loader.getController();
        controller.init(viewModelFactory.getLoginViewModel(), this);
        loginScene = new Scene(root);
        mainStage.setTitle("Login");
        mainStage.setScene(loginScene);
    }

    public void openCart() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = getRootByPath("Cart/Cart.fxml", loader);
        CartController controller = loader.getController();
        controller.init(viewModelFactory.getCartViewModel(), this);
        cart = new Scene(root);
        mainStage.setTitle("Cart");
        mainStage.setScene(cart);
    }

    private Parent getRootByPath(String path, FXMLLoader loader) {
        loader.setLocation(getClass().getResource(path));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
