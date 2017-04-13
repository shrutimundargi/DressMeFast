package model;

import java.util.HashSet;
import java.util.Set;

import model.interfaces.User;
import model.interfaces.UserManagement;

public class UserManagementImpl implements UserManagement {
    
    protected Set<User> usersList;
    
    public UserManagementImpl() {
        this.usersList = new HashSet<>();
    }
    
    @Override
    public User getSpecifiedUser(String name, String password) {
        for(User user : this.usersList) {
            if(user.getName().equals(name) && user.getPassword().equals(password)) {
                return user;
            }
           
        }
        return null;
    }

    

}
