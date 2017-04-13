package model;

public enum Status {
    
    USER_NOT_FOUND ("User not found"),
    USER_FOUND("User found."),
    DUPLICATED_USER ("User already registered"),
    WRONG_PASSWORD("The insert password is wrong"),
    USERNAME_ALREADY_TAKEN("Your username is already taken"),
    USER_REGISTERED("The user has been registered succesfully");
    
    
    private String text;
    
    public String getText() {
        return this.text;
    }
    
    private Status(String text) {
        this.text = text;
    }
    
}
