package model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import model.interfaces.Category;
import model.interfaces.CategoryManagement;
import model.interfaces.Dress;

public class CategoryManagementImpl implements CategoryManagement {

    private Map<Categories, Category> categoryMap = new EnumMap<>(Categories.class);
    

    @Override
    public Category getCategory(Categories category) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Categories addDressToCategory(Dress dress, Categories category) {
        // TODO Auto-generated method stub
        return null;
    }

}