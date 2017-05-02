package view.generalUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.ScreensGraphic;

public interface ProgramUI {
    public void setupButtonsBH();
    public void addScreenBack(final ScreensGraphic actualScreen);
    
    public void goHome(ActionEvent event);
    public void goBrand(ActionEvent event);
    public void goAddDress(ActionEvent event);
    public void goFavorite(ActionEvent event);
    public void goOutfits(ActionEvent event);
    public void goSize(ActionEvent event);
    public void goCategory(ActionEvent event);
    public void goUser(ActionEvent event);
    public void goBack(ActionEvent event);
    public void goAhead(ActionEvent event);
}
