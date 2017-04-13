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
        signUp = new SignUpImpl();
        this.usersSet = new HashSet<>(); 
        login = new LoginImpl();
    }
    
    @Override
    public Status getSpecifiedUser(String name, String password) {
        return login.checkLogin(name, password, usersSet);
    }
    
    public Status addUser(String signUpName, String signUpPassword) {
        Status status = signUp.adding(signUpName, signUpPassword, this.usersSet);
        usersSet = getUsersSet();
        return status;        
    }
    
    public Set<User> getUsersSet() {
        return signUp.getSet();
    }
    
    
    public User getUser() {
        return signUp.getUser();
    }
    
    public User getLoginUser() {
        return login.getUser();
    }
    
    
    
    

}
