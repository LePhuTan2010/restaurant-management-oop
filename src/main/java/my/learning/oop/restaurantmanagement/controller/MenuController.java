package my.learning.oop.restaurantmanagement.controller;

import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import my.learning.oop.restaurantmanagement.model.Menu;
import my.learning.oop.restaurantmanagement.model.MenuItem;
import my.learning.oop.restaurantmanagement.model.Product;
import my.learning.oop.restaurantmanagement.service.DataService;
import my.learning.oop.restaurantmanagement.service.MenuService;
import my.learning.oop.restaurantmanagement.util.FileLocation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class MenuController {
    private final DataService dataService;
    private final MenuService menuService;

    public MenuController(DataService dataService, MenuService menuService) {
        this.dataService = dataService;
        this.menuService = menuService;
    }

    @GetMapping("/menus")
    @ResponseBody
    public List<Menu> getAllMenus() {
        return menuService.getMenuList();
    }

    @GetMapping("/menus/{id}")
    @ResponseBody
    public Menu getMenuById(@PathParam("id") Long id) {
        return menuService.getMenuById(id);
    }

    @GetMapping("/menus/{id}/product")
    @ResponseBody
    public List<Product> getFoodsByMenuId(@PathParam("id") Long id) {
        return menuService.getProductsByMenuId(id);
    }

    @PostMapping("/menus")
    @ResponseBody
    public void createMenu(@RequestBody Menu menu) throws Exception {
        menuService.addMenu(menu);
        dataService.writeToFile(FileLocation.MENU);
    }

    @PutMapping("/menus")
    @ResponseBody
    public void updateMenu(@RequestBody Menu menu) throws Exception {
        menuService.updateMenu(menu);
        dataService.writeToFile(FileLocation.MENU);
    }

    @DeleteMapping("/menus/{id}")
    @ResponseBody
    public void deleteMenu(@PathParam("id") Long id) throws Exception {
        menuService.removeMenuById(id);
        dataService.writeToFile(FileLocation.MENU);
    }

}
