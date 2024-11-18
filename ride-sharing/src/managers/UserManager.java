package managers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import models.User;

public class UserManager {
    private static UserManager manager;
    private Map<String, User> users;
    private Integer counter;
    private UserManager() {
        users = new ConcurrentHashMap<String, User>();
        counter = 0;
    } 

    public static UserManager getManager() {
        if(manager == null) {
            synchronized(UserManager.class) {
                if(manager == null) {
                    manager = new UserManager();
                }
            }
        }
        return manager;
    }

    public String createUser(String name, String email) {
        User newUser = new User(Integer.toString(counter++), name, email);
        users.put(newUser.getID(), newUser);
        return newUser.getID();
    }

    public void registerVehicle(String userId, String vehicleId) {
        users.get(userId).addVehicle(vehicleId);
    }

    public void deregisterVehicle(String userId, String vehicleId) {
        users.get(userId).removeVehicle(vehicleId);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }
}
