package main.client.viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.model.createItem.ICreateItemModel;

public class CreateItemViewModel {
    private ICreateItemModel model;
    private StringProperty name;
    private StringProperty groupName;
    private StringProperty price;
    private StringProperty ingredients;
    private StringProperty response;

    public CreateItemViewModel(ICreateItemModel itemModel) {
        model = itemModel;
        name = new SimpleStringProperty();
        groupName = new SimpleStringProperty();
        price = new SimpleStringProperty();
        ingredients = new SimpleStringProperty();
        response = new SimpleStringProperty();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty groupNameProperty() {
        return groupName;
    }

    public StringProperty priceProperty() {
        return price;
    }

    public StringProperty ingredientsProperty() {
        return ingredients;
    }

    public StringProperty responseProperty() {
        return response;
    }

    public void createItem(boolean customizable) {
        if(name.get() != null && !name.get().isEmpty() &&
                groupName.get() != null && !groupName.get().isEmpty() &&
                price.get() != null && !price.get().isEmpty() &&
                ingredients.get() != null && !ingredients.get().isEmpty() &&
                groupName.get() != null && !groupName.get().isEmpty())
        {
            response.setValue(model.createItem(name.get(), customizable, ingredients.get(), price.get(), groupName.get() ));
        }
        else{
            response.setValue("Must enter all values");
        }
    }

    public boolean testConnection() {
        return model.testConnection();
    }
}
