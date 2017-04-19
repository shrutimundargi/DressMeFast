package model.interfaces;

import model.CategoriesStatus;

public interface Category {

    Dress getDress(Dress dressName);

    CategoriesStatus addDress(Dress dress);

}
