package main.client.view.customerMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import main.client.view.ViewHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import main.client.viewModel.CustomerMenuViewModel;
import main.shared.Item;

import java.util.ArrayList;

public class CustomerMenuController {
    @FXML
    private GridPane menuGrid;
    private CustomerMenuViewModel vm;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, CustomerMenuViewModel customerMenuViewModel) {
        this.viewHandler = viewHandler;
        vm = customerMenuViewModel;
        populateMenu(vm.getMenu());
    }

    public void addToCart(String id){
        vm.addToCart(Integer.parseInt(id));
    }

    public void populateMenu(ArrayList<Item> list) {
        menuGrid.getColumnConstraints().get(0).setPrefWidth(430);
        menuGrid.getColumnConstraints().get(0).setMaxWidth(430);

        menuGrid.getColumnConstraints().get(1).setPrefWidth(30);
        menuGrid.getColumnConstraints().get(1).setMaxWidth(30);

        menuGrid.getColumnConstraints().get(2).setPrefWidth(85);
        menuGrid.getColumnConstraints().get(2).setMaxWidth(85);

        for (int i = 0; i < list.size(); i++) {
            Label label = new Label();
            label.setText(list.get(i).toString());
            menuGrid.add(label, 0, i);

            Label price = new Label();
            price.setText("" + list.get(i).getPrice());
            menuGrid.add(price, 1, i);

            Button button = new Button("Add to cart");
            button.setId(i + "");
            button.setOnAction(actionEvent -> {
                addToCart(button.getId());
            });
            menuGrid.add(button, 2, i);
        }
    }

    @FXML
    void OnCancelOrder(ActionEvent event) {

    }

    @FXML
    void OnViewCart(ActionEvent event) {
        viewHandler.openCart();
    }
}
