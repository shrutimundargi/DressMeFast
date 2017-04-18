package controller;

import java.util.Set;

import model.interfaces.Dress;
import model.Status;

public interface Controller {
	
	public Status checkLogin(String user, String pass);
	
	public Status signUp(String user, String pass);
	
	public Set<Dress> getThreeLastDresses();
	
	public Set<String> getAllBrand();
	
	public Set<Dress> getDressesOfBrand(String brandName);
	
	public Set<Dress> getFavoriteDresses(String brandName);
	
	public Set<Integer> getAllSize();
	
	public Set<Dress> getDressesOfSize(int size);
	
	public Set<String> getAllCategory();
	
	public Set<Dress> getDressesOfCategory();	
	
}
