package main.server.model;

import main.server.model.login.ILoginModel;
import main.server.model.login.LoginModel;
import main.server.model.menu.IMenuModel;
import main.server.model.menu.MenuModel;
import main.server.persistence.DAOFactory;

public class ModelFactory {
    private DAOFactory daoFactory;
    private IMenuModel menu;
    private ILoginModel login;

    public ModelFactory(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public IMenuModel getMenuModel() {
        if(menu == null)
            menu = new MenuModel(daoFactory.getItemDAO(), daoFactory.getIngredientDAO());
        return menu;
    }

    public ILoginModel getLoginModel() {
        if(login == null)
            login = new LoginModel(daoFactory.getLoginDAO(), daoFactory.getReceptionistDAO());
        return login;
    }
}
