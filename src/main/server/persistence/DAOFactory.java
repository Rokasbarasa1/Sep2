package main.server.persistence;


import main.server.persistence.database.IDBConnection;
import main.server.persistence.ingredient.IIngredientDAO;
import main.server.persistence.ingredient.IngredientDAO;
import main.server.persistence.item.IItemDAO;
import main.server.persistence.item.ItemDAO;
import main.server.persistence.login.ILoginDAO;
import main.server.persistence.login.LoginDAO;
import main.server.persistence.receptionist.IReceptionistDAO;
import main.server.persistence.receptionist.ReceptionistDAO;

public class DAOFactory {
    private IDBConnection connect;
    private ILoginDAO login;
    private IReceptionistDAO receptionist;
    private IItemDAO item;
    private IIngredientDAO ingredient;


    public DAOFactory(IDBConnection connect) {
        this.connect = connect;
    }

    public ILoginDAO getLoginDAO() {
        if(login == null)
            login = new LoginDAO(connect);
        return login;
    }

    public IReceptionistDAO getReceptionistDAO() {
        if(receptionist == null)
            receptionist = new ReceptionistDAO(connect);
        return receptionist;
    }

    public IItemDAO getItemDAO() {
        if(item == null)
            item = new ItemDAO(connect);
        return item;
    }

    public IIngredientDAO getIngredientDAO() {
        if(ingredient == null)
            ingredient = new IngredientDAO(connect);
        return ingredient;
    }
}
