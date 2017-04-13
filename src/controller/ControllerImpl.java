package controller;

import java.util.Set;

import model.Dress;

public class ControllerImpl implements Controller {
	
	public static final ControllerImpl SINGLETON = new ControllerImpl();
	
	private ControllerImpl(){
		
		
	}
	
	public static ControllerImpl getInstance(){
		return SINGLETON;		
	}

	@Override
	public Status checkLogin(String user, String pass) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Status singUp(String user, String pass) {
		// TODO Auto-generated method stub
		return 0;
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
