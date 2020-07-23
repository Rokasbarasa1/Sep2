package main.server.persistence;


import main.server.persistence.database.IDBConnection;
import main.server.persistence.login.ILoginDAO;
import main.server.persistence.login.LoginDAO;
import main.server.persistence.receptionist.IReceptionistDAO;
import main.server.persistence.receptionist.ReceptionistDAO;

public class DAOFactory {
    private IDBConnection connect;
    private ILoginDAO login;
    private IReceptionistDAO receptionistDAO;


    public DAOFactory(IDBConnection connect) {
        this.connect = connect;
    }

    public ILoginDAO getLoginDAO() {
        if(login == null)
            login = new LoginDAO(connect);
        return login;
    }

    public IReceptionistDAO getReceptionistDAO() {
        if(receptionistDAO == null)
            receptionistDAO = new ReceptionistDAO(connect);
        return receptionistDAO;
    }
}
