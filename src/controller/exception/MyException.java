package controller.exception;

/**
 *  This is my Exception class.
 */
public class MyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * @param s
     *            is for text error
     * 
     */
    public MyException(final String s) {
        super(s);
    }
}
