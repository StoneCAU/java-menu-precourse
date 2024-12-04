package menu.controller;

import java.util.List;
import menu.validator.InputValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    public void run() {
        OutputView.printWelcomeMessage();
        List<String> coachesStr = InputValidator.validateCoaches(InputView.inputCoaches());
    }
}
