package model.interfaces;

import java.util.Set;

import model.AuthenticationStatus;

public interface Login { 
    
    AuthenticationStatus checkLogin (String name, String pass, Set<User> usersSet);
    
    User getUser();
    
    
}
