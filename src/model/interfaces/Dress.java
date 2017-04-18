package model.interfaces;

import java.util.Optional;

public interface Dress {
    
    String getName();
    
    Optional<String> getBrand();
    
    int getSize();
    
    Optional<Integer> getPrice();
    
    Optional<String> getPurchaseDate();
    
    Optional<String> getDescription();
    
    
}
