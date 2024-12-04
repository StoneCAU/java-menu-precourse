package menu.view;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();

    public static void printWelcomeMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    private static void printNewLine() {
        System.out.printf(NEW_LINE);
    }

    public static void printErrorMessage(String message) {
        printNewLine();
        System.out.println(message);
    }
}
