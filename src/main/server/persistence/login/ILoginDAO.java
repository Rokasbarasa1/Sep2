package main.server.persistence.login;

import main.shared.Receptionist;

public interface ILoginDAO {
    String validateLogin(Receptionist receptionist) ;
}
