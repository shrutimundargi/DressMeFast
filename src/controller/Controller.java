package controller;

import java.util.Set;

public interface Controller {
	
	public int checkLogin(String user, String pass);
	
	public int singUp(String user, String pass);
	
	public Set<Dress> getThreeLastDresses();
	
	public Set<String> getAllBrand();
	
	public Set<Dress> getDressesOfBrand(String brandName);
	
	public Set<Dress> getFavoriteDresses(String brandName);
	
	public Set<Integer> getAllSize();
	
	public Set<Dress> getDressesOfSize(int size);
	
	public Set<String> getAllCategory();
	
	public Set<Dress> getDressesOfCategory();	
	
	
}
