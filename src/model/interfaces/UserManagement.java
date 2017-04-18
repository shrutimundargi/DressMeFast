package model.interfaces;

import model.AuthenticationStatus;

public interface UserManagement {
	 
    AuthenticationStatus addUser(String signUpName, String signUpPassword);
    
    AuthenticationStatus getSpecifiedUser(String name, String password);
    
    User getLoginUser();
    
    User getSignUpUser();
}
