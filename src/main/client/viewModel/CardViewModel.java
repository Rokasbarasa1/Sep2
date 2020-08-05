package main.client.viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import main.client.model.card.ICardModel;

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
            if(cardNumber.get().length() >= 16 && cardNumber.get().length() <= 20 && expiration.get().length() == 5 && securityNumber.get().length() == 3){
                try{
                    String[] expirationCheckArray = expiration.get().split("-");
                    String expirationCheck = expirationCheckArray[0] + expirationCheckArray[1];
                    int expirationCheckInt = Integer.parseInt(expirationCheck);
                    int securityCheck = Integer.parseInt(securityNumber.get());
                    String[] cardStringArray = cardNumber.get().split(" ");
                    for (int i = 0; i < cardStringArray.length; i++) {
                        int cardNumberCheck = Integer.parseInt(cardStringArray[i]);
                    }
                    response.setValue(cardModel.makeOrder(cardNumber.get(), expiration.get(), securityNumber.get()));
                }catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
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

    private boolean validateCard() {
        String cardString = cardNumber.get();
        String[] cardStringArray = cardString.split(" ");
        cardString = "";
        for (int i = 0; i < cardStringArray.length; i++) {
            cardString += cardStringArray[i];
        }
        System.out.println(cardString);
        int[] creditCardInt = new int[cardString.length()];
        try{
            for (int i = 0; i < cardString.length(); i++) {
                creditCardInt[i] = Integer.parseInt(cardString.substring(i, i+1));
            }

            for (int i = creditCardInt.length - 2; i >= 0; i = i-2) {
                int tempValue = creditCardInt[i];
                tempValue = tempValue * 2;
                if(tempValue > 9)
                    tempValue = tempValue % 10 + 1;
                creditCardInt[i] = tempValue;
            }

            int total = 0;
            for (int i = 0; i < creditCardInt.length; i++) {
                total += creditCardInt[i];
            }
            if(total % 10 == 0)
                return true;
            else
                return false;
        } catch (NumberFormatException e){
            return false;
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
