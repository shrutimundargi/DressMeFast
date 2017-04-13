package controller;

import java.util.Set;

import controller.authentication.Authentication;
import controller.authentication.AuthenticationImpl;
import model.Status;
import model.interfaces.Dress;
import model.interfaces.User;

public class ControllerImpl implements Controller {
	
	public static final ControllerImpl SINGLETON = new ControllerImpl();
	private Authentication auth;
	private Status status;
	private User user;
	
	private ControllerImpl(){
		 auth = AuthenticationImpl.getInstance();
		
	}
	
	public static ControllerImpl getInstance(){
		return SINGLETON;		
	}

	@Override
	public Status checkLogin(String user, String pass) {
		// TODO Auto-generated method stub
		return Status.DUPLICATED_USER;
	}

	@Override
	public Status singUp(String user, String pass) {
		status = auth.addUser(user, pass);
		if(this.status != Status.USERNAME_ALREADY_TAKEN && this.status == Status.DUPLICATED_USER ){
			this.user = auth.getUser();
		}
		return status;
	}

	@Override
	public Set<String> getAllBrand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Integer> getAllSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Dress> getThreeLastDresses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Dress> getDressesOfBrand(String brandName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Dress> getFavoriteDresses(String brandName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Dress> getDressesOfSize(int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Dress> getDressesOfCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
