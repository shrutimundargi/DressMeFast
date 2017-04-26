package view;


public enum ScreensGraphic {

    /**
     * Login scene at the startup of application
     */
    LOGIN("/view/login/Login.fxml", "/view/login/Login.css"),
    
    /**
     * Sing up scene.
     */
    SINGUP("/view/singup/Singup.fxml", "/view/singup/Singup.css"),
    
    /**
     * Dialog scene after the sing in.
     */
    DIALOGSINGUP("/view/dialog/SingupDialog.fxml", "/view/dialog/SingupDialog.css"),
    
    /**
     * Home scene.
     */
    HOME("/view/home/Home.fxml", "/view/home/Home.css"),
    
    /**
     * Statistics scene.
     */
    STATISTICS("/view/statistics/Statistics.fxml", "/view/statistics/Statistics.css");
    

    private final String resourcePath;
    private final String cssPath;

    /**
     * @param path
     *            full qualified path of the .fxml
     * @param cssPath
     *            full qualified path of the .css
     */
    ScreensGraphic(final String path, final String styleSheetPath) {
        this.resourcePath = path;
        this.cssPath = styleSheetPath;
    }

    /**
     * @return full qualified path of the .fxml
     */
    public String getPath() {
        return resourcePath;
    }

    /**
     * @return full qualified path of the .css
     */
    public String getCssPath() {
        return cssPath;
    }
}
