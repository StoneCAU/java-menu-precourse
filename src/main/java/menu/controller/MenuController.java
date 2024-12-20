package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.exception.MenuException;
import menu.validator.InputValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    public void run() {
        OutputView.printWelcomeMessage();
        List<Coach> coaches = getCoaches();
        List<Category> categories = Category.getCategories();
        categories.forEach(category -> coaches.forEach(coach -> suggestToCoach(coach, category)));
        OutputView.printResult(categories, coaches);
    }

    private List<String> getCoachNames() {
        while (true) {
            try {
                String input = InputView.inputCoaches();
                return InputValidator.validateCoaches(input);
            } catch (MenuException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Coach> getCoaches() {
        List<String> coachNames = getCoachNames();
        return coachNames.stream()
                .map(coachName -> {
                    List<Menu> unlikeMenus = getUnlikeMenus(coachName);
                    return new Coach(coachName, unlikeMenus);
                })
                .toList();
    }

    private List<Menu> getUnlikeMenus(String coachName) {
        List<String> menuNames = getMenuNames(coachName);
        return menuNames.stream()
                .map(Menu::getMenu)
                .toList();
    }

    private List<String> getMenuNames(String coachName) {
        while (true) {
            try {
                String input = InputView.inputMenus(coachName);
                List<String> menuNames = InputValidator.validateMenus(input);
                if (menuNames.isEmpty()) {
                    return menuNames;
                }
                Menu.validateMenu(menuNames);
                return menuNames;
            } catch (MenuException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private static void suggestToCoach(Coach coach, Category category) {
        coach.suggestMenu(category);
    }
}
