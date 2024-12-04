package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String NEW_LINE = System.lineSeparator();

    public static String inputCoaches() {
        printNewLine();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return input();
    }

    private static String input() {
        return Console.readLine();
    }

    private static void printNewLine() {
        System.out.printf(NEW_LINE);
    }
}
