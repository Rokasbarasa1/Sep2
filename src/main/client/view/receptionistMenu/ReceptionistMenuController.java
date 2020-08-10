package main.client.view.receptionistMenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.client.view.ViewHandler;
import main.client.viewModel.ReceptionistMenuViewModel;
import main.shared.Item;
import main.shared.Order;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class ReceptionistMenuController {
    @FXML
    private TableView<Item> menuTable;
    @FXML
    private TableColumn<Item, String> menuName;
    @FXML
    private TableColumn<Item, String> menuIngredients;
    @FXML
    private TableColumn<Item, Double> menuPrice;
    @FXML
    private TableColumn<Item, Boolean> menuCustomizable;
    @FXML
    private TableColumn<Item, String> menuGroupName;
    @FXML
    private Label menuResponse;
    @FXML
    private TableView<Order> incompleteOrderTable;
    @FXML
    private TableColumn<Order, String> tableIdOrder;
    @FXML
    private TableColumn<Order, String> tableItemsOrder;
    @FXML
    private Label orderResponse;


    private ViewHandler viewHandler;
    private ReceptionistMenuViewModel vm;
    private ObservableList<Item> menuItems = FXCollections.observableArrayList();
    private ObservableList<Order> orderItems = FXCollections.observableArrayList();

    public void init(ViewHandler viewHandler, ReceptionistMenuViewModel vm) {
        this.viewHandler = viewHandler;
        this.vm = vm;
        vm.loadReceptionist();
        vm.addPropertyChangeListener(evt -> updateTable());
        menuName.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        menuIngredients.setCellValueFactory(new PropertyValueFactory<Item, String>("ingredients"));
        menuPrice.setCellValueFactory(new PropertyValueFactory<Item, Double>("price"));
        menuCustomizable.setCellValueFactory(new PropertyValueFactory<Item, Boolean>("customizable"));
        menuGroupName.setCellValueFactory(new PropertyValueFactory<Item, String>("groupName"));
        orderResponse.textProperty().bindBidirectional(vm.orderResponseProperty());
        menuResponse.textProperty().bindBidirectional(vm.menuResponseProperty());
        menuItems.addAll(vm.getMenu());
        menuTable.setItems(menuItems);

        tableIdOrder.setCellValueFactory(new PropertyValueFactory<Order, String>("ID"));
        tableItemsOrder.setCellValueFactory(new PropertyValueFactory<Order, String>("items"));
        orderItems.addAll(vm.getIncompleteOrders());
        incompleteOrderTable.setItems(orderItems);
    }

    public void updateTable(){
        System.out.println("Scream if you got this from observer pattern");
        incompleteOrderTable.getItems().clear();
        orderItems.addAll(vm.getIncompleteOrders());
        incompleteOrderTable.setItems(orderItems);
    }

    @FXML
    void OnCompleteOrder(ActionEvent event) {
        Order selectedOrder = incompleteOrderTable.getSelectionModel().getSelectedItem();
        vm.completeOrder(selectedOrder.getID());
    }

    @FXML
    void OnCreateNewItem(ActionEvent event) {
        viewHandler.openCreateItem();
    }

    @FXML
    void OnPrintOrder(ActionEvent event) {
        Order selectedOrder = incompleteOrderTable.getSelectionModel().getSelectedItem();
        if(selectedOrder != null){
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(selectedOrder);
            boolean doPrint = job.printDialog();
            if (doPrint)
            {
                try
                {
                    job.print();
                }
                catch (PrinterException e)
                {
                    System.out.println("Something went wrong while printing");
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    void OnDeleteItem(ActionEvent event) {
        Item selectedItem = menuTable.getSelectionModel().getSelectedItem();
        if(selectedItem != null){
            vm.deleteItem(selectedItem.getID());
            if(menuResponse.getText().equals("Success")){
                menuTable.getItems().clear();
                menuItems.addAll(vm.getMenu());
                menuTable.setItems(menuItems);
            }
        }
    }
}
