package main.client.view.createItem;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.client.view.ViewHandler;
import main.client.viewModel.CreateItemViewModel;

public class CreateItemController {
    @FXML
    private TextField name;

    @FXML
    private TextField groupName;

    @FXML
    private TextField price;

    @FXML
    private TextArea ingredients;

    @FXML
    private Label response;

    @FXML
    private RadioButton tureRadio;

    @FXML
    private RadioButton falseRadio;

    private ViewHandler viewHandler;
    private CreateItemViewModel vm;
    private ToggleGroup group = new ToggleGroup();

    public void init(CreateItemViewModel createItemViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        vm = createItemViewModel;
        falseRadio.setToggleGroup(group);
        tureRadio.setToggleGroup(group);
        falseRadio.setSelected(true);
        name.textProperty().bindBidirectional(vm.nameProperty());
        groupName.textProperty().bindBidirectional(vm.groupNameProperty());
        price.textProperty().bindBidirectional(vm.priceProperty());
        ingredients.textProperty().bindBidirectional(vm.ingredientsProperty());
        response.textProperty().bindBidirectional(vm.responseProperty());
    }

    @FXML
    void OnBack() {
        if(vm.testConnection()){
            viewHandler.openReceptionistMenu();
            clear();
        } else {
            response.setText("Failed to connect to server");
        }
    }

    @FXML
    void OnCreateItem() {
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        System.out.println(Boolean.parseBoolean(toogleGroupValue));
        vm.createItem(Boolean.parseBoolean(toogleGroupValue));
        if(response.getText().equals("OK")){
            clear();
            viewHandler.openReceptionistMenu();
        }
    }

    private void clear() {
        name.clear();
        groupName.clear();
        price.clear();
        ingredients.clear();
        response.setText("");
    }
}
