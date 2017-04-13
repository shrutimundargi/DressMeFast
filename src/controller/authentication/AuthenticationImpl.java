package controller.authentication;

import java.util.Optional;

import controller.ControllerImpl;
import model.SignUpImpl;
import model.Status;
import model.UserManagementImpl;
import model.interfaces.SignUp;
import model.interfaces.User;
import model.interfaces.UserManagement;

public class AuthenticationImpl implements Authentication {
	
	private Status status;
	private User user;
	
	public static final AuthenticationImpl SINGLETON = new AuthenticationImpl();
	
	private UserManagement userM;
	
	private AuthenticationImpl(){
	    userM=new UserManagementImpl();
	}
	
	public static AuthenticationImpl getInstance(){
		return SINGLETON;		
	}

	@Override
	public Status getSpecifiedUser(String user, String pass) {
		status = userM.getSpecifiedUser(user, pass);
		if(this.status == Status.USER_NOT_FOUND || this.status == Status.WRONG_PASSWORD){
		    return status;
		}else{
		    this.user = userM.getLoginUser();
		    return this.status;
		}		
	}

	@Override
	public Status addUser(String user, String pass) {		
		status = userM.addUser(user, pass);
		if(this.status == Status.USERNAME_ALREADY_TAKEN || this.status == Status.DUPLICATED_USER ){
			return status;
		}else{
			this.user = userM.getUser();
			return status;
		}		
	}

	@Override
	public Status checkAuthentication(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser() {		
		return this.user;
	}
}
