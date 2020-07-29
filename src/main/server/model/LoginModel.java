package main.server.model;

import main.server.persistence.ingredient.IIngredientDAO;
import main.server.persistence.item.IItemDAO;
import main.server.persistence.login.ILoginDAO;
import main.server.persistence.receptionist.IReceptionistDAO;
import main.shared.Receptionist;

public class LoginModel implements ILoginModel {
    private ILoginDAO loginDAO;
    private IReceptionistDAO receptionistDAO;

    public LoginModel(ILoginDAO loginDAO, IReceptionistDAO receptionistDAO) {
        this.loginDAO = loginDAO;
        this.receptionistDAO = receptionistDAO;
    }

    @Override
    public String validateLogin(Receptionist loginCarrier) {
        return loginDAO.validateLogin(loginCarrier);
    }

    @Override
    public Receptionist getReceptionistById(int id) {
        return receptionistDAO.getReceptionist(id);
    }

}
