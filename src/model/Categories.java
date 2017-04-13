package model;

public enum Categories {
    
    HEAD ("Head"),
    NECK ("Neck"),
    HANDS ("Hands"),
    BODY ("Body"),
    LEGS ("Legs"),
    FOOT ("Foot");
    
    private String categoryName;
    
    public String getCategoryName() {
        return this.categoryName;
    }
    
    private Categories(String categoryName) {
        this.categoryName = categoryName;
    }
    
}
