package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

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
}
