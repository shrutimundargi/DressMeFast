package model.interfaces;

import java.util.Set;

import model.AuthenticationStatus;

public interface SignUp {
    
    AuthenticationStatus storeUser(String signUpName, String signUpPassword,Set<User> usersSet);
    
    Set<User> getSet();
    
    User getUser();
}
