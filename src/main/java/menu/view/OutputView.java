package menu.view;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();

    public static void printWelcomeMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printResult(List<Category> categories, List<Coach> coaches) {
        System.out.println("%n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.printf("[ 카테고리 | %s | %s | %s | %s | %s ]%n", categories.get(0).getName(),
                categories.get(1).getName(), categories.get(2).getName(), categories.get(3).getName(),
                categories.get(4).getName());
        coaches.forEach(OutputView::printMenu);
        printNewLine();
        System.out.println("추천을 완료했습니다.");
    }

    public static void printErrorMessage(String message) {
        printNewLine();
        System.out.println(message);
    }

    private static void printMenu(Coach coach) {
        List<Menu> menus = coach.getSuggestedMenus();
        System.out.printf("[ %s | %s | %s | %s | %s | %s ]%n", coach.getName(), menus.get(0).getName(),
                menus.get(1).getName(), menus.get(2).getName(), menus.get(3).getName(), menus.get(4).getName());
    }

    private static void printNewLine() {
        System.out.printf(NEW_LINE);
    }
}
