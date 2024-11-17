package services;

import java.util.List;

import models.User;

public class UserManager {
    private static UserManager manager;
    private int counter;
    List<User> users;
    private UserManager() { counter = 0; };

    public static UserManager getManager() {
        if(manager == null) {
            synchronized(UserManager.class) {
                if (manager == null) {
                    manager = new UserManager();
                }
            } 
        }
        return manager;
    }

    public String createUser(String name, String email, String mobileNumber) {
        User newUser = new User(Integer.toString(counter++), name, email, mobileNumber);
        users.add(newUser);
        return newUser.getId();
    }

    public String toString() {
        return String.format("I am the best User Manager!!");
    }
}
