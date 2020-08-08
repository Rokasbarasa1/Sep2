package main.client.viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import main.client.model.card.ICardModel;

import java.math.BigInteger;

public class CardViewModel {
    private ICardModel cardModel;
    private StringProperty cardNumber;
    private StringProperty expiration;
    private StringProperty securityNumber;
    private StringProperty response;

    public CardViewModel(ICardModel cardModel) {
        this.cardModel = cardModel;
        cardNumber = new SimpleStringProperty();
        expiration = new SimpleStringProperty();
        securityNumber = new SimpleStringProperty();
        response = new SimpleStringProperty();
    }

    public void makeOrder(String method) {
        if(cardNumber.get() != null && !cardNumber.get().isEmpty() && expiration.get() != null && !expiration.get().isEmpty() && securityNumber.get() != null && !securityNumber.get().isEmpty() && method != null && !method.isEmpty()) {
            if(cardNumber.get().length() > 14 && cardNumber.get().length() <= 20 && expiration.get().length() == 5 && securityNumber.get().length() == 3){
                try{
                    String[] expirationCheckArray = expiration.get().split("-");
                    String expirationCheck = expirationCheckArray[0] + expirationCheckArray[1];
                    int expirationCheckInt = Integer.parseInt(expirationCheck);
                    int securityCheck = Integer.parseInt(securityNumber.get());
                    String[] cardStringArray = cardNumber.get().split(" ");
                    for (int i = 0; i < cardStringArray.length; i++) {
                        BigInteger bigInteger = new BigInteger(cardStringArray[i]);
                    }
                    response.setValue(cardModel.makeOrder(cardNumber.get(), expiration.get(), securityNumber.get()));
                }catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
                    e.printStackTrace();
                    response.setValue("Must enter valid values in all fields");
                    cardNumber.setValue(null);
                    expiration.setValue(null);
                    securityNumber.setValue(null);
                }
            } else {
                response.setValue("Must enter valid values in all fields");
                cardNumber.setValue(null);
                expiration.setValue(null);
                securityNumber.setValue(null);
            }
        }
        else{
            response.setValue("Must enter values in all fields");
            cardNumber.setValue(null);
            expiration.setValue(null);
            securityNumber.setValue(null);
        }
    }

    public StringProperty cardNumberProperty() {
        return cardNumber;
    }

    public StringProperty expirationProperty() {
        return expiration;
    }

    public StringProperty securityNumberProperty() {
        return securityNumber;
    }

    public StringProperty responseProperty() {
        return response;
    }

    public void clearCart() {
        cardModel.clearCart();
    }

    public int getId() {
        return cardModel.getId();
    }
}
