package model.interfaces;


public interface UserManagement {
	
	SignUp getsignUp();
    
    User getSpecifiedUser(String name, String password);
}
