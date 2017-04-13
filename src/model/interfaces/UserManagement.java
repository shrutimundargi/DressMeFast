package model.interfaces;

import model.Status;

public interface UserManagement {
	 
    Status addUser(String signUpName, String signUpPassword);
    
    Status getSpecifiedUser(String name, String password);
    
    User getLoginUser();
    
    User getSignUpUser();
}
