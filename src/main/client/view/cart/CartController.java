package main.client.view.cart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import main.client.view.ViewHandler;
import main.client.viewModel.CartViewModel;
import main.client.viewModel.CustomerMenuViewModel;
import main.shared.Item;
import main.shared.Order;

import java.util.ArrayList;
import java.util.Optional;

public class CartController {
    @FXML
    private GridPane cartGrid;
    @FXML
    private Label total;

    private CartViewModel vm;
    private ViewHandler viewHandler;

    public void init(CartViewModel cartViewModel, ViewHandler viewHandler) {
        vm = cartViewModel;
        this.viewHandler = viewHandler;
        populateCart(vm.getCart());
        setTotal(vm.getCart());
    }

    public void populateCart(ArrayList<Item> list) {
        cartGrid.getColumnConstraints().get(0).setPrefWidth(430);
        cartGrid.getColumnConstraints().get(0).setMaxWidth(430);

        cartGrid.getColumnConstraints().get(1).setPrefWidth(30);
        cartGrid.getColumnConstraints().get(1).setMaxWidth(30);

        cartGrid.getColumnConstraints().get(2).setPrefWidth(85);
        cartGrid.getColumnConstraints().get(2).setMaxWidth(85);

        for (int i = 0; i < list.size(); i++) {
            Label nameAndIngredients = new Label();
            nameAndIngredients.setText(list.get(i).toString());
            nameAndIngredients.setWrapText(true);
            cartGrid.add(nameAndIngredients, 0, i);

            Label price = new Label();
            price.setText("" + list.get(i).getPrice());
            cartGrid.add(price, 1, i);

            if(list.get(i).isCustomizable() == true){
                Button buttonCustomize = new Button("Customize");
                buttonCustomize.setId(i + "");
                buttonCustomize.setOnAction(actionEvent -> {
                    editItem(Integer.parseInt(buttonCustomize.getId()));
                });
                cartGrid.add(buttonCustomize, 2, i);
            }

            Button buttonRemove = new Button("Remove");
            buttonRemove.setId(i + "");
            buttonRemove.setOnAction(actionEvent -> {
                removeItem(Integer.parseInt(buttonRemove.getId()));
            });
            cartGrid.add(buttonRemove, 3, i);
        }
    }

    public void editItem(int id){
        vm.setCustomizeItem(id);
        viewHandler.openCustomize();
    }

    public void setTotal(ArrayList<Item> cart){
        double totalPrice = 0;
        for (int i = 0; i < cart.size(); i++) {
            totalPrice += cart.get(i).getPrice() + cart.get(i).getIngredientTotalPrice();
        }
        total.setText(total.getText() + String.format("%.2f", totalPrice));
    }

    private void removeItem(int id) {
        vm.removeItemFromCart(id);
        viewHandler.openCart();
    }

    @FXML
    void OnBackToMenu(ActionEvent event) {
        viewHandler.openCustomerMenu();
    }

    @FXML
    void OnMakeOrder(ActionEvent event) {
        if(vm.getCart().size() == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert");
            alert.setHeaderText("Your cart is empty!");
            alert.showAndWait();
        }else {
            viewHandler.openCard();
        }
    }
}
