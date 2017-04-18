package controller.authentication;

import model.AuthenticationStatus;
import model.interfaces.User;

public interface Authentication {
	
	public AuthenticationStatus addUser(String user,String pass);
	
	public AuthenticationStatus checkAuthentication(String user, String pass);
	
	public User getUser();

}
