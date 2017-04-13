package model.interfaces;

import java.util.Set;

import model.Status;

public interface SignUp {
    
    Status adding(String signUpName, String signUpPassword,Set<User> usersSet);
    Set<User> getSet();
    User getUser();
}
