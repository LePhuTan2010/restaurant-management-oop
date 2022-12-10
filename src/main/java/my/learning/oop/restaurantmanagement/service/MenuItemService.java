package my.learning.oop.restaurantmanagement.service;

import my.learning.oop.restaurantmanagement.model.MenuItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    private final List<MenuItem> menuItemList;

    public MenuItemService(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItemList.add(menuItem);
    }

    public void removeMenuItem(MenuItem menuItem) {
        menuItemList.remove(menuItem);
    }

    public void updateMenuItem(MenuItem menuItem) {
        menuItemList.set(menuItemList.indexOf(menuItem), menuItem);
    }

    public MenuItem getMenuItemById(int id) {
        return menuItemList.stream().filter(menuItem -> menuItem.getId() == id).findFirst().orElse(null);
    }

}
