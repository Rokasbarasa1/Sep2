package main.server.persistence.receptionist;

import main.shared.Receptionist;

import java.util.List;

public interface IReceptionistDAO {
    Receptionist getReceptionist(int Id);
}
