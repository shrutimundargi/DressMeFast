package model.interfaces;

import model.Status;

public interface SignUp {
    
    Status addUser(String signUpName, String signUpPassword);
    
    User getUser();
}
