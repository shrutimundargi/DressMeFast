package controller.starter;

import java.util.Date;

import controller.Controller;
import controller.ControllerImpl;
import model.CategoriesStatus;

public class Main {
    public static void main(String[] args) {
        Date data = new Date();
        Controller cont = ControllerImpl.getInstance();        
        System.out.println(cont.authentication().signUp("pop", "palla"));
        System.out.println(cont.authentication().checkLogin("pop", "palla"));
        // cont.authentication().logout();
        System.out.println(cont.authentication().checkLogin("pop", "palla"));
        System.out.println(cont.authentication().checkLogin("pop", "palla"));
        //cont.authentication().logout();
        cont.dress().addDress("name", "brand", 10, 10, data, "", CategoriesStatus.BODY);
    }
}
