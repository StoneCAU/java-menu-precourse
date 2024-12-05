package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public enum Category {
    JAPANESE_FOOD("일식"),
    KOREAN_FOOD("한식"),
    CHINESE_FOOD("중식"),
    ASIAN_FOOD("아시안"),
    WESTERN_FOOD("양식");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Category suggest() {
        int number = Randoms.pickNumberInRange(1,5);
        return Category.values()[number - 1];
    }

    public static  List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Category category = suggestCategory(categories);
            categories.add(category);
        }
        return categories;
    }

    private static Category suggestCategory(List<Category> categories) {
        Category category = suggest();
        if (isInValidCategory(categories, category)) {
            return suggestCategory(categories);
        }
        return category;
    }

    private static boolean isInValidCategory(List<Category> categories, Category category) {
        return categories.stream()
                .filter(ct -> ct == category)
                .count() == 2;
    }
}
