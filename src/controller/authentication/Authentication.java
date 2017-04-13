package controller.authentication;

import model.User;

public interface Authentication {
	
	public User getSpecifiedUser(String user, String pass);
	
	public Status addUser(String user,String pass);
	
	public Status checkAuthentication(String user, String pass);
	
	public User getUser();

}
