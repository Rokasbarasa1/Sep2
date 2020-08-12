package main.server.persistence.receptionist;

import main.shared.Receptionist;

public interface IReceptionistDAO {
    Receptionist getReceptionist(int Id);
}
