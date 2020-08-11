package main.client.view.customerMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
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
        ArrayList<String> groupNames = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(!groupNames.contains(list.get(i).getGroupName()))
                groupNames.add(list.get(i).getGroupName());
        }

        menuGrid.getColumnConstraints().get(0).setPrefWidth(430);
        menuGrid.getColumnConstraints().get(0).setMaxWidth(430);

        menuGrid.getColumnConstraints().get(1).setPrefWidth(40);
        menuGrid.getColumnConstraints().get(1).setMaxWidth(40);

        menuGrid.getColumnConstraints().get(2).setPrefWidth(85);
        menuGrid.getColumnConstraints().get(2).setMaxWidth(85);
        String lastGroupName = "";
        int listCounter = 0;
        for (int i = 0; i < list.size() + groupNames.size(); i++) {
            if(!lastGroupName.equals(list.get(listCounter).getGroupName())){
                lastGroupName = list.get(listCounter).getGroupName();
                Label group = new Label(lastGroupName);
                group.setStyle("-fx-font-weight: bold;-fx-text-fill:#000000;-fx-font-family:\"Arial\";-fx-font-size:30px;");
                menuGrid.add(group, 0, i);
            } else {
                Label label = new Label(list.get(listCounter).toString());
                menuGrid.add(label, 0, i);

                Label price = new Label("" + list.get(listCounter).getPrice());
                menuGrid.add(price, 1, i);

                Button button = new Button("Add to cart");
                button.setId(listCounter + "");
                button.setOnAction(actionEvent -> {
                    addToCart(button.getId());
                });
                menuGrid.add(button, 2, i);
                listCounter++;
            }
        }
    }

    @FXML
    void OnCancelOrder() {
        vm.clear();
    }

    @FXML
    void OnViewCart() {
        viewHandler.openCart();
    }
}
