package menu.domain;

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
}
