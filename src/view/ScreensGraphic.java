package view;


public enum ScreensGraphic {

    /**
     * Primary screen at the startup of application
     */
    LOGIN("/view/login/Login.fxml", "/view/login/Login.css"),
    
    /**
     * Main view of the Editor.
     */
    SINGUP("/view/singup/Singup.fxml", "/view/singup/Singup.css"),
    
    /**
     * Main view of the Editor.
     */
    DIALOGSINGUP("/view/dialog/singupDialog.fxml", "/view/dialog/style.css");

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
