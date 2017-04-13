package model.interfaces;

import java.util.Set;

import model.Status;

public interface UserManagement {
	
    User getUser();
    Status addUser(String signUpName, String signUpPassword);
    Status getSpecifiedUser(String name, String password);
    User getLoginUser();
}
