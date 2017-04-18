package model;

import java.util.HashSet;
import java.util.Set;

import model.interfaces.Login;
import model.interfaces.SignUp;
import model.interfaces.User;
import model.interfaces.UserManagement;

public class UserManagementImpl implements UserManagement {
    
    private Set<User> usersSet;
    private SignUp signUp;
    private Login login;
    
    public UserManagementImpl() {
        this.usersSet = new HashSet<>(); 
        this.login = new LoginImpl();
        this.signUp = new SignUpImpl();
    }
    
    @Override
    public AuthenticationStatus getSpecifiedUser(String name, String password) {
        return login.checkLogin(name, password, usersSet);
    }
    
    public AuthenticationStatus addUser(String signUpName, String signUpPassword) {
        AuthenticationStatus status = signUp.storeUser(signUpName, signUpPassword, this.usersSet);
        usersSet = getUsersSet();
        return status;        
    }
    
    public Set<User> getUsersSet() {
        return signUp.getSet();
    }
    
    
    public User getSignUpUser() {
        return signUp.getUser();
    }
    
    public User getLoginUser() {
        return login.getUser();
    }
    
    
    
    

}
