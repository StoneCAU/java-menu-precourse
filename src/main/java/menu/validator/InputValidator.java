package menu.validator;

import java.util.Arrays;
import java.util.List;
import menu.exception.ErrorMessage;
import menu.exception.MenuException;

public class InputValidator {

    public static List<String> validateCoaches(String input) {
        List<String> parsed = parseInput(input);
        validateCoachesName(parsed);
        validateCoachesNumber(parsed);
        validateDuplicate(parsed);

        return parsed;
    }

    private static List<String> parseInput(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    private static void validateDuplicate(List<String> input) {
        if (isDuplicate(input)) {
            throw new MenuException(ErrorMessage.IS_DUPLICATE);
        }
    }

    private static void validateCoachesNumber(List<String> input) {
        if (input.size() < 2) {
            throw new MenuException(ErrorMessage.COACH_NUM_IS_SMALL);
        }

        if (input.size() > 5) {
            throw new MenuException(ErrorMessage.COACH_NUM_IS_BIG);
        }
    }

    private static void validateCoachesName(List<String> input) {
        if(!input.stream().allMatch(InputValidator::isValidName)) {
            throw new MenuException(ErrorMessage.INVALID_COACH_NAME);
        }
    }

    private static boolean isDuplicate(List<String> input) {
        return input.stream()
                .distinct()
                .count() != input.size();
    }

    private static boolean isValidName(String input) {
        return input.length() >= 2 && input.length() <= 4;
    }


}
