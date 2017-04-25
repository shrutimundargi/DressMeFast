package model.interfaces;

import java.util.Set;

import model.Status;

public interface Login { 
    
    Status checkLogin (String name, String pass, Set<User> usersSet);
    
    User getUser();
    
    
}
