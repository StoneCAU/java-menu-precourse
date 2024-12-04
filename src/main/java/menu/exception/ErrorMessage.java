package menu.exception;

public enum ErrorMessage {
    IS_DUPLICATE("중복된 코치 이름이 존재합니다."),
    COACH_NUM_IS_SMALL("코치는 최소 2명 이상 입력해야 합니다."),
    COACH_NUM_IS_BIG("코치는 최대 5명 이하 입력해야 합니다."),
    INVALID_COACH_NAME("코치 이름은 2글자 ~ 4글자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
