package models;

public class User {
    private String id;
    private String name;
    private String email;
    private String mobileNumber;

    public User(String ID, String Name, String Email, String MobileNumber) {
        this.id = ID;
        this.name = Name;
        this.email = Email;
        this.mobileNumber = MobileNumber;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
    
    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String toString() {
        return String.format("%s with ID: %s", this.name, this.id);
    }
}
