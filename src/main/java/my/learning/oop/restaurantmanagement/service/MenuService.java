package my.learning.oop.restaurantmanagement.service;

import my.learning.oop.restaurantmanagement.model.Menu;
import my.learning.oop.restaurantmanagement.model.MenuItem;
import my.learning.oop.restaurantmanagement.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final List<Menu> menuList;

    private final MenuItemService menuItemService;

    public MenuService(List<Menu> menuList, MenuItemService menuItemService) {
        this.menuList = menuList;
        this.menuItemService = menuItemService;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void addMenu(Menu menu) {
        menuList.add(menu);
    }

    public void removeMenuById(Long id) {
        menuList.removeIf(menu -> menu.getId().equals(id));
    }

    public void updateMenu(Menu menu) {
        menuList.set(menuList.indexOf(menu), menu);
    }

    public Menu getMenuById(Long id) {
        return menuList.stream().filter(menu -> menu.getId() == id).findFirst().orElse(null);
    }

    public void addMenuItem(Menu menu, int menuItemId) {
        MenuItem menuItem = menuItemService.getMenuItemById(menuItemId);
        menu.getMenuItems().add(menuItem);
    }

    public List<Product> getProductsByMenuId(Long menuId) {
        return getMenuById(menuId).getMenuItems().stream().map(MenuItem::getProduct).toList();
    }

}
