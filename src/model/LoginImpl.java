package model;

import java.util.HashSet;
import java.util.Set;

import model.interfaces.Login;
import model.interfaces.User;

public class LoginImpl implements Login {
    
    private Status status;
    private User user;
    
    public LoginImpl() {
       
    }
    
    
    @Override
    public Status checkLogin(String name, String pass, Set<User> usersSet) {
        for(User user : usersSet) {
            if(user.getName().equals(name) && user.getPassword().equals(pass)) {
                this.user = user;
                return Status.USER_FOUND;
            }
            else if(user.getName().equals(name) && !user.getPassword().equals(pass)) {
                return Status.WRONG_PASSWORD;            
            }
        }
        return Status.USER_NOT_FOUND;
    }


    @Override
    public User getUser() {
        return this.user;
    }
    
    

  

}
