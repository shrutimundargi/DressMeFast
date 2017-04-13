package model;

import model.interfaces.SignUp;
import model.interfaces.User;

public class SignUpImpl extends UserManagementImpl implements SignUp {
    
    private String signUpName;
    private String signUpPassword;
    private User user;
    private Status status;
    
    public SignUpImpl() {
        this.signUpName = "";
        this.signUpPassword = "";
        this.user = null;
    }
    
    public String getSignUpName() {
        return this.signUpName;
    }
    public String getSignUpPassword() {
        return this.signUpPassword;
    }
    
    @Override
    public Status addUser(String signUpName, String signUpPassword) {
    	if(this.usersList.isEmpty()){
    		this.user = new UserImpl(signUpName, signUpPassword);
            this.usersList.add(user);
    	}else{    	
	        for(User user : this.usersList) {
	            if(user.getName().equals(signUpName) && user.getPassword().equals(signUpPassword)) {
	                return Status.DUPLICATED_USER;
	            }
	            else if(user.getName().equals(signUpName)) {
	                return Status.USERNAME_ALREADY_TAKEN;
	            }
	            else {
	                this.user = new UserImpl(signUpName, signUpPassword);
	                this.usersList.add(user);
	            }
	            
	        }
    	}
        return Status.USER_REGISTERED;
    }
    
    @Override
    public User getUser() {
        return this.user;
    }
    
}
