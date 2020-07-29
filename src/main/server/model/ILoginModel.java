package main.server.model;

import main.shared.Receptionist;

public interface ILoginModel {
    String validateLogin(Receptionist loginCarrier);
    Receptionist getReceptionistById(int id);
}
