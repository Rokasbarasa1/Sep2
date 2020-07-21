package main.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteCommandList extends Remote {
    String login(Receptionist loginCarrier) throws RemoteException; // I send you a receptionist class that only has username and password set. You check those and send me back a string like this if it is ok "Login successful;213". The number after the ";" is the id of the user, that is important to me.
}
