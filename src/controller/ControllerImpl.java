package controller;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import controller.authentication.Authentication;
import controller.authentication.AuthenticationImpl;
import model.AuthenticationStatus;
import model.interfaces.Dress;
import model.interfaces.User;
import view.NameOfScreens;
import view.UI;

public class ControllerImpl implements Controller {
	
	public static final ControllerImpl SINGLETON = new ControllerImpl();
	private Authentication auth;
	private AuthenticationStatus status;
	private User user;
	private Map<NameOfScreens,UI> map;
	
	private ControllerImpl(){
	    auth = AuthenticationImpl.getInstance();
	    map = new HashMap<>();
	    
	}
	
	public static ControllerImpl getInstance(){
	    return SINGLETON;		
	}
	
	/**
	 * Questo metodo permette all'utente di loggarsi restituendo il risultato dell'operazione
	 */
	@Override
	public AuthenticationStatus checkLogin(String user, String pass) {
		status = auth.checkAuthentication(user, pass);
		if(this.status != AuthenticationStatus.USER_NOT_FOUND || this.status != AuthenticationStatus.WRONG_PASSWORD){
			this.user = auth.getUser();
        }
		return status;
	}
	
	/**
	 * Questo metodo permette all'utente di Registrarsi restituendo il risultato dell'operazione
	 */
	@Override
	public AuthenticationStatus signUp(String user, String pass) {
		status = auth.addUser(user, pass);
		if(this.status != AuthenticationStatus.USERNAME_ALREADY_TAKEN && this.status != AuthenticationStatus.DUPLICATED_USER ){
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

	@Override
	public void attachUI(NameOfScreens name,UI UI) {
		map.put(name, UI);
	}
	
	

}
