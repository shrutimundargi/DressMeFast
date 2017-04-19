package model.interfaces;


import model.CategoriesStatus;

public interface CategoryManagement {
    
    Category getCategory(CategoriesStatus category);
    
    CategoriesStatus addDressToCategory(CategoriesStatus category);
    
}