package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import menu.exception.ErrorMessage;
import menu.exception.MenuException;

public enum Menu {
    // 일식
    KYUDONG(Category.JAPANESE_FOOD, "규동"),
    WOODONG(Category.JAPANESE_FOOD, "우동"),
    MISONARU(Category.JAPANESE_FOOD, "미소나루"),
    SUSI(Category.JAPANESE_FOOD, "스시"),
    KATZDONG(Category.JAPANESE_FOOD, "가츠동"),
    ONIKIRI(Category.JAPANESE_FOOD, "오니기리"),
    HIRICE(Category.JAPANESE_FOOD, "하이라이스"),
    RAMEN(Category.JAPANESE_FOOD, "라멘"),
    OKONOMIYAKI(Category.JAPANESE_FOOD, "오코노미야키"),

    // 한식
    KIMBAB(Category.KOREAN_FOOD, "김밥"),
    KIMCHI_SOUP(Category.KOREAN_FOOD, "김치찌개"),
    SSAMBAB(Category.KOREAN_FOOD, "쌈밥"),
    DENJANG_SOUP(Category.KOREAN_FOOD, "된장찌개"),
    BIBIMBAB(Category.KOREAN_FOOD, "비빔밥"),
    KALKUKSU(Category.KOREAN_FOOD, "칼국수"),
    BULGOGI(Category.KOREAN_FOOD, "불고기"),
    TUKBOKI(Category.KOREAN_FOOD, "떡볶이"),
    JAEYUK(Category.KOREAN_FOOD, "제육볶음"),

    // 중식
    KANPUNGI(Category.CHINESE_FOOD, "깐풍기"),
    BOKEUM_NOODLE(Category.CHINESE_FOOD, "볶음면"),
    DONGPAYUK(Category.CHINESE_FOOD, "동파육"),
    JAJANG_NOODLE(Category.CHINESE_FOOD, "짜장면"),
    JAMBONG(Category.CHINESE_FOOD, "짬뽕"),
    MAPATOFU(Category.CHINESE_FOOD, "마파두부"),
    TANGSUYUK(Category.CHINESE_FOOD, "탕수육"),
    TOMATO_EGG(Category.CHINESE_FOOD, "토마토 달걀볶음"),
    KOCHUJAPCHAE(Category.CHINESE_FOOD, "고추잡채"),

    // 아시안
    PATAI(Category.ASIAN_FOOD, "팟타이"),
    KAO_PAT(Category.ASIAN_FOOD, "카오 팟"),
    NASIGORANG(Category.ASIAN_FOOD, "나시고렝"),
    PINEAPPLE_RICE(Category.ASIAN_FOOD, "파인애플 볶음밥"),
    RICE_NOODLE(Category.ASIAN_FOOD, "쌀국수"),
    DDOMYANGGUNG(Category.ASIAN_FOOD, "똠양꿍"),
    BANMI(Category.ASIAN_FOOD, "반미"),
    WOLNAMSSAM(Category.ASIAN_FOOD, "월남쌈"),
    BUNJJA(Category.ASIAN_FOOD, "분짜"),

    // 양식
    RAJANYA(Category.WESTERN_FOOD, "라자냐"),
    GRATANG(Category.WESTERN_FOOD, "그라탕"),
    NYOKI(Category.WESTERN_FOOD, "뇨끼"),
    GGISHU(Category.WESTERN_FOOD, "끼슈"),
    FRENCH_TOAST(Category.WESTERN_FOOD, "프렌치 토스트"),
    BAGATTE(Category.WESTERN_FOOD, "바게트"),
    SPAGETTI(Category.WESTERN_FOOD, "스파게티"),
    PIZZA(Category.WESTERN_FOOD, "피자"),
    PANINI(Category.WESTERN_FOOD, "파니니");

    private final Category category;
    private final String name;

    Menu(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public static Menu getMenu(String input) {
        if (input.isEmpty()) return null;
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getName().equals(input))
                .findFirst().orElseThrow(() -> new MenuException(ErrorMessage.INVALID_MENU));
    }

    public static void validateMenu(List<String> menuNames) {
        if (menuNames.get(0).isEmpty() && menuNames.size() == 1) return;
        if (!isValidMenu(menuNames)) {
            throw new MenuException(ErrorMessage.INVALID_MENU);
        }
    }

    public static List<String> getMenuNamesByCategory(Category category) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getCategory().equals(category))
                .map(Menu::getName)
                .toList();
    }

    private static boolean isValidMenu(List<String> menuNames) {
        return menuNames.stream()
                .allMatch(menuName -> Arrays.stream(Menu.values())
                        .anyMatch(menu -> menu.getName().equals(menuName)));
    }
}
