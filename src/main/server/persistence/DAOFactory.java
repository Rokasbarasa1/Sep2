package main.server.persistence;


import main.server.persistence.database.IDBConnection;

public class DAOFactory {
    private IDBConnection connect;
    private ILoginDAO login;

    public DAOFactory(IDBConnection connect) {
        this.connect = connect;
    }

    public ILoginDAO getLoginDAO() {
        if(login == null)
            login = new LoginDAO(connect);
        return login;
    }
}
