package main.server.persistence.login;

import main.shared.Receptionist;
import shared.User;

public interface ILoginDAO {
    String validateLogin(Receptionist receptionist) ;
}
