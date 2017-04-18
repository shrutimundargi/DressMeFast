package model;

import model.interfaces.User;
import model.interfaces.Wardrobe;

public class UserImpl implements User {
    
    private String userName;
    private String userPassword;
    private Wardrobe wardrobe;
    
    
    public UserImpl(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.wardrobe = new WardobeImpl();
    }

    @Override
    public String getName() {
        return this.userName;
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public Wardrobe getWardobe() {
        return this.wardrobe;
    }
    
}
