package model;

import java.util.HashSet;
import java.util.Set;

import model.interfaces.SignUp;
import model.interfaces.User;

public class SignUpImpl implements SignUp {
    
    private String signUpName;
    private String signUpPassword;
    private User user;
    private Status status;
    private Set<User> usersSet ;
   
    
    public SignUpImpl() {
        usersSet = new HashSet<>();
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
    public Status adding(String signUpName, String signUpPassword,Set<User> usersSet) {
        this.usersSet = usersSet;
    	if(this.usersSet.isEmpty()){
    	    this.user = new UserImpl(signUpName, signUpPassword);
            this.usersSet.add(user);
    	}else{    	
	        for(User user : this.usersSet) {
	            if(user.getName().equals(signUpName) && user.getPassword().equals(signUpPassword)) {
	                return Status.DUPLICATED_USER;
	            }
	            else if(user.getName().equals(signUpName)) {
	                return Status.USERNAME_ALREADY_TAKEN;
	            }	            
	        }
	        this.user = new UserImpl(signUpName, signUpPassword);
                this.usersSet.add(user);
    	}
        return Status.USER_REGISTERED;
    }
    
    public Set<User> getSet(){
        return  this.usersSet;
    }
    
    @Override
    public User getUser() {
        return this.user;
    }
    
}
