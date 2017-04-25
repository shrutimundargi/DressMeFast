package model;

import java.util.HashSet;
import java.util.Set;

import model.interfaces.SignUp;
import model.interfaces.User;

public class SignUpImpl implements SignUp {
    
    private User user;
    private Status status;
    private Set<User> usersSet ;
   
    
    public SignUpImpl() {
        usersSet = new HashSet<>();
        this.user = null;
    }
    
    @Override
    public Status storeUser(String signUpName, String signUpPassword,Set<User> usersSet) {
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
    
    @Override
    public Set<User> getSet(){
        return this.usersSet;
    }
    
    @Override
    public User getUser() {
        return this.user;
    }
    
}
