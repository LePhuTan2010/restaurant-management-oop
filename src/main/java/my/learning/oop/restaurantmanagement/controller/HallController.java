package my.learning.oop.restaurantmanagement.controller;

import my.learning.oop.restaurantmanagement.model.Hall;
import my.learning.oop.restaurantmanagement.service.DataService;
import my.learning.oop.restaurantmanagement.service.HallService;
import my.learning.oop.restaurantmanagement.util.FileLocation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class HallController {

    private final DataService dataService;
    private final HallService hallService;

    public HallController(DataService dataService, HallService hallService) {
        this.dataService = dataService;
        this.hallService = hallService;
    }

    @GetMapping("/halls")
    @ResponseBody
    public List<Hall> getAllHalls() {
        return hallService.getHallList();
    }

    @PostMapping("/halls")
    @ResponseBody
    public void addHall(@RequestBody Hall hall) throws IOException, URISyntaxException {
        hallService.addHall(hall);
        dataService.writeToFile(FileLocation.HALL);
    }

    @PutMapping("/halls")
    @ResponseBody
    public void updateHall(@RequestBody Hall hall) throws IOException, URISyntaxException {
        hallService.updateHall(hall);
        dataService.writeToFile(FileLocation.HALL);
    }

    @DeleteMapping("/halls/{id}")
    @ResponseBody
    public void deleteHall(@PathVariable String id) throws IOException, URISyntaxException {
        hallService.removeHallById(id);
        dataService.writeToFile(FileLocation.HALL);
    }
}
