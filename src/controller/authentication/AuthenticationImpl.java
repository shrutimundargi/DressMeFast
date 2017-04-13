package controller.authentication;

import controller.ControllerImpl;
import model.User;

public class AuthenticationImpl implements Authentication {
	
	public static final AuthenticationImpl SINGLETON = new AuthenticationImpl();
	
	private AuthenticationImpl(){
		
	}
	
	public static AuthenticationImpl getInstance(){
		return SINGLETON;		
	}

	@Override
	public User getSpecifiedUser(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status addUser(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status checkAuthentication(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}
}
