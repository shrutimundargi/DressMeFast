package model;

public enum CategoriesStatus {
    
    HEAD ("Head"),
    NECK ("Neck"),
    HANDS ("Hands"),
    BODY ("Body"),
    LEGS ("Legs"),
    FOOT ("Foot"),
    NAME_ALREADY_EXISTS("Dress name already exists");
    
    private String categoryName;
    
    public String getCategoryName() {
        return this.categoryName;
    }
    
    private CategoriesStatus(String categoryName) {
        this.categoryName = categoryName;
    }
    
}
