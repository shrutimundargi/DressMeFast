package controller.authentication;

public interface Authentication {
	
	public User getSpecifiedUser(String user, String pass);
	
	public User addUser(String user,String pass);

}
