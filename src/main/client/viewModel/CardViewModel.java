package main.client.viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
        if(cardNumber.get() != null && !cardNumber.get().isEmpty() &&
                expiration.get() != null && !expiration.get().isEmpty() &&
                securityNumber.get() != null && !securityNumber.get().isEmpty()
                && method != null && !method.isEmpty()) {
            if(cardNumber.get().length() > 14 && cardNumber.get().length() <= 20
                    && expiration.get().length() == 5 && securityNumber.get().length() == 3){
                try{
                    //Check if the entered values are all numbers in expiration date
                    String[] expirationCheckArray = expiration.get().split("-");
                    String expirationCheck = expirationCheckArray[0] + expirationCheckArray[1];
                    int expirationCheckInt = Integer.parseInt(expirationCheck);
                    //Check if numbers in security
                    int securityCheck = Integer.parseInt(securityNumber.get());
                    //Check if numbers in card number
                    String[] cardStringArray = cardNumber.get().split(" ");
                    for (int i = 0; i < cardStringArray.length; i++) {
                        BigInteger bigInteger = new BigInteger(cardStringArray[i]);
                    }

                    response.setValue(cardModel.makeOrder(cardNumber.get(), expiration.get(), securityNumber.get(), method));
                }catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
                    e.printStackTrace();
                    response.setValue("Must enter valid values in all fields");
                    resetParameters();
                }
            } else {
                response.setValue("Must enter valid values in all fields");
                resetParameters();
            }
        }
        else{
            response.setValue("Must enter values in all fields");
            resetParameters();
        }
    }

    public void resetParameters(){
        cardNumber.setValue(null);
        expiration.setValue(null);
        securityNumber.setValue(null);
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
