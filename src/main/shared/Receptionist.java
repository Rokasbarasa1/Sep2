package main.shared;

import java.io.Serializable;

public class Receptionist implements Serializable {
    private int ID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String workRole;

    public Receptionist(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Receptionist(int ID, String username, String password, String firstName, String lastName, String email, String phoneNumber, String workRole) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.workRole = workRole;
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWorkRole() {
        return workRole;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
