package main.client.view.customize;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import main.client.view.ViewHandler;
import main.client.viewModel.CustomizeViewModel;
import main.shared.Ingredient;

import java.util.ArrayList;

public class CustomizeController {
    @FXML
    private Label itemName;
    @FXML
    private GridPane ingredientGrid;
    private CustomizeViewModel vm;
    private ViewHandler viewHandler;

    public void init(CustomizeViewModel customizeViewModel, ViewHandler viewHandler) {
        vm = customizeViewModel;
        this.viewHandler = viewHandler;
        populateGrid(vm.getIngredients());
        itemName.setText(itemName.getText() + " " + vm.getItemName());
    }

    private void populateGrid(ArrayList<Ingredient> ingredients) {
        ingredientGrid.getColumnConstraints().get(0).setPrefWidth(175);
        ingredientGrid.getColumnConstraints().get(0).setMaxWidth(175);

        ingredientGrid.getColumnConstraints().get(1).setPrefWidth(50);
        ingredientGrid.getColumnConstraints().get(1).setMaxWidth(50);

        ingredientGrid.getColumnConstraints().get(2).setPrefWidth(50);
        ingredientGrid.getColumnConstraints().get(2).setMaxWidth(50);

        ingredientGrid.getColumnConstraints().get(3).setPrefWidth(50);
        ingredientGrid.getColumnConstraints().get(3).setMaxWidth(50);

        ingredientGrid.getColumnConstraints().get(4).setPrefWidth(50);
        ingredientGrid.getColumnConstraints().get(4).setMaxWidth(50);

        for (int i = 0; i < ingredients.size(); i++) {
            Label name = new Label(ingredients.get(i).getName());

            Label counter = new Label(ingredients.get(i).getCounter()+ "");

            Label priceLabel = new Label();
            setPrice(priceLabel, ingredients, i);

            Button plus = new Button("+");
            plus.setId(i + "");
            plus.setOnAction(actionEvent -> {
                increment(Integer.parseInt(plus.getId()),counter, ingredients, priceLabel);
            });

            Button minus = new Button("-");
            minus.setId(i + "");
            minus.setOnAction(actionEvent -> {
                decrement(Integer.parseInt(minus.getId()), counter, ingredients, priceLabel);
            });

            ingredientGrid.add(name, 0, i);
            ingredientGrid.add(minus, 1, i);
            ingredientGrid.add(counter, 2, i);
            ingredientGrid.add(plus, 3, i);
            ingredientGrid.add(priceLabel, 4, i);
        }
    }

    private void decrement(int id, Label counter, ArrayList<Ingredient> ingredients, Label price) {
        if(ingredients.get(id).getCounter() != 0){
            int num = Integer.parseInt(counter.getText()) - 1;
            counter.setText(num + "");
            ingredients.get(id).setCounter(num);
            setPrice(price, ingredients, id);
        }
    }

    private void increment(int id, Label counter, ArrayList<Ingredient> ingredients, Label price) {
        if(ingredients.get(id).getCounter() != 5){
            int num = Integer.parseInt(counter.getText()) + 1;
            counter.setText(num + "");
            ingredients.get(id).setCounter(num);
            setPrice(price, ingredients, id);
        }
    }

    public void setPrice(Label priceLabel, ArrayList<Ingredient> ingredients, int index){
        if(ingredients.get(index).getCounter() > 1){
            double price = ingredients.get(index).getCounter() * ingredients.get(index).getPrice();
            priceLabel.setText(price + "");
        }else {
            priceLabel.setText("");
        }
    }

    @FXML
    void OnBack() {
        viewHandler.openCart();
    }
}
