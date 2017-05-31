package controller;

import view.SetupView;

/**
 * 
 * This is the starter of the Application.
 *
 */
public final class Main {
    private Main() {
    }

    /**
     * Main class of the class.
     * 
     * @param args
     *            the standard args of the main, in this case are futile.
     */
    public static void main(final String[] args) {
        final Controller controller = ControllerImpl.getInstance();
        new SetupView(controller);
        controller.userController().signUp("a", "1");
        controller.userController().logout();

    }
}