package model.interfaces;

import java.util.Set;

import model.Status;

public interface SignUp {
    
    Status storeUser(String signUpName, String signUpPassword,Set<User> usersSet);
    
    Set<User> getSet();
    
    User getUser();
}
