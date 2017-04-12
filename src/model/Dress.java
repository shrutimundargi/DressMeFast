package model;

import java.awt.Image;

public interface Dress {
    
    String getBrand(String dressName);
    
    Image getImage(String dressName);
    
    int getSize(String dressName);
    
    String getPurchaseDate(String dressName);
    
    String getDescription(String dressName);
    
    
}
