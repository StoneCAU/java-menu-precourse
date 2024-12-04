package menu.exception;

public class MenuException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR] ";

    public MenuException(ErrorMessage errorMessage) {
        super(PREFIX + errorMessage.getMessage());
    }
}
