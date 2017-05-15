package view;

/**
 * 
 * Enumeration to keep the information of every screen (.fxml, .css). 
 *
 */
public enum ScreensGraphic {

    /**
     * Login scene at the startup of application.
     */
    LOGIN("/view/login/Login.fxml", "/view/login/Login.css"),

    /**
     * Sing up scene.
     */
    SINGUP("/view/singup/Signup.fxml", "/view/singup/Signup.css"),

    /**
     * Dialog scene after the sing in.
     */
    DIALOGSINGUP("/view/dialog/SignupDialog.fxml", "/view/dialog/SignupDialog.css"),

    /**
     * Home scene.
     */
    HOME("/view/home/Home.fxml", "/view/home/Home.css"),

    /**
     * User and statistics scene.
     */
    USER("/view/user/User.fxml", "/view/user/User.css"),

    /**
     * Add item scene.
     */
    BRAND("/view/brand/Brand.fxml", "/view/brand/Brnad.css"),
    /**
     * Add item scene.
     */
    ADD("/view/add/Add.fxml", "/view/add/Add.css"),
    /**
     * Add item scene.
     */
    FAVORITE("/view/favorite/Favorite.fxml", "/view/favorite/Favorite.css"),
    /**
     * Add item scene.
     */
    OUTFITS("/view/outfits/Outfits.fxml", "/view/outfits/Outfits.css"),
    /**
     * Add item scene.
     */
    SIZE("/view/size/Size.fxml", "/view/size/Size.css"),
    /**
     * Category scene.
     */
    CATEGORY("/view/category/Category.fxml", "/view/category/Category.css");

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
