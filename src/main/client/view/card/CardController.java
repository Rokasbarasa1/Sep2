package main.client.view.card;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.client.view.ViewHandler;
import main.client.viewModel.CardViewModel;

public class CardController {
    @FXML
    private TextField cardNumber;

    @FXML
    private TextField expiration;

    @FXML
    private TextField securityNumber;

    @FXML
    private Label response;

    @FXML
    private ComboBox<String> payementMethod;

    private CardViewModel vm;
    private ViewHandler viewHandler;

    public void init(CardViewModel cartViewModel, ViewHandler viewHandler) {
        vm = cartViewModel;
        this.viewHandler = viewHandler;
        cardNumber.textProperty().bindBidirectional(vm.cardNumberProperty());
        expiration.textProperty().bindBidirectional(vm.expirationProperty());
        securityNumber.textProperty().bindBidirectional(vm.securityNumberProperty());
        response.textProperty().bindBidirectional(vm.responseProperty());

        payementMethod.getItems().add("MasterCard");
        payementMethod.getItems().add("Visa");
        payementMethod.getItems().add("PayPal");
    }

    @FXML
    void OnBack(ActionEvent event) {
        clearCardDetails();
        viewHandler.openCart();
    }

    @FXML
    void OnMakeOrder(ActionEvent event) {
        vm.makeOrder(payementMethod.getValue());
        if(response.getText().equals("OK")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Make order");
            alert.setHeaderText("Your order id is: " + vm.getId());
            alert.showAndWait();

            vm.clearCart();
            clearCardDetails();
            viewHandler.openCustomerMenu();
        }
    }

    private void clearCardDetails() {
        cardNumber.clear();
        expiration.clear();
        securityNumber.clear();
        response.setText("");
    }
}
