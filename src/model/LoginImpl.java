package model;

import java.util.Set;

import model.interfaces.Login;
import model.interfaces.User;

public class LoginImpl implements Login {
    
    private AuthenticationStatus status;
    private User user;
    
    public LoginImpl() {
       
    }
    
    
    @Override
    public AuthenticationStatus checkLogin(String name, String pass, Set<User> usersSet) {
        for(User user : usersSet) {
            if(user.getName().equals(name) && user.getPassword().equals(pass)) {
                this.user = user;
                return AuthenticationStatus.USER_FOUND;
            }
            else if(user.getName().equals(name) && !user.getPassword().equals(pass)) {
                return AuthenticationStatus.WRONG_PASSWORD;            
            }
        }
        return AuthenticationStatus.USER_NOT_FOUND;
    }


    @Override
    public User getUser() {
        return this.user;
    }
    
    
}
