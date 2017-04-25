package model.interfaces;


import model.Categories;

public interface CategoryManagement {
    
    Category getCategory(Categories category);
    
    Categories addDressToCategory(Dress dress, Categories category);
    
}
