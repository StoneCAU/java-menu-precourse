package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<Menu> unlikeMenus;
    private List<Menu> suggestedMenus = new ArrayList<>();

    public Coach(String name, List<Menu> unlikeMenus) {
        this.name = name;
        this.unlikeMenus = unlikeMenus;
    }

    public String getName() {
        return name;
    }

    public List<Menu> getSuggestedMenus() {
        return suggestedMenus;
    }

    public void suggestMenu(Category category) {
        suggestedMenus.add(suggestMenuByCategory(category));
    }

    private Menu suggestMenuByCategory(Category category) {
        List<String> menuNames = Menu.getMenuNamesByCategory(category);
        String menuName = Randoms.shuffle(menuNames).get(0);
        Menu menu = Menu.getMenu(menuName);

        if (unlikeMenus.contains(menu) || suggestedMenus.contains(menu)) return suggestMenuByCategory(category);
        return menu;
    }
}
