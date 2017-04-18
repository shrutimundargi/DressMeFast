package model;

public enum CategoriesStatus {
    
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
    
    private CategoriesStatus(String categoryName) {
        this.categoryName = categoryName;
    }
    
}
