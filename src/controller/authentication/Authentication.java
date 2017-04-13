package controller.authentication;

import model.Status;
import model.interfaces.User;

public interface Authentication {
	
	public Status getSpecifiedUser(String user, String pass);
	
	public Status addUser(String user,String pass);
	
	public Status checkAuthentication(String user, String pass);
	
	public User getUser();

}
