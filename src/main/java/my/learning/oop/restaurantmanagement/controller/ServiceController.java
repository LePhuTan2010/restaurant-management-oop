package my.learning.oop.restaurantmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import my.learning.oop.restaurantmanagement.model.Service;
import my.learning.oop.restaurantmanagement.service.DataService;
import my.learning.oop.restaurantmanagement.service.WeddingServiceService;
import my.learning.oop.restaurantmanagement.util.FileLocation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class ServiceController {
    private final DataService dataService;
    private final WeddingServiceService weddingServiceService;

    public ServiceController(DataService dataService, WeddingServiceService weddingServiceService) {
        this.dataService = dataService;
        this.weddingServiceService = weddingServiceService;
    }

    @GetMapping("/services")
    @ResponseBody
    public List<Service> getAllServices() {
        return weddingServiceService.getServiceList();
    }

    @GetMapping("/services/{id}")
    @ResponseBody
    public Service getServiceById(@PathVariable Long id) {
        return weddingServiceService.getServiceById(id);
    }

    @PostMapping("/services")
    @ResponseBody
    public void addService(@RequestBody Service service) throws Exception {
        weddingServiceService.addService(service);
        dataService.writeToFile(FileLocation.SERVICE);
    }

    @PutMapping("/services")
    @ResponseBody
    public void updateService(@RequestBody Service service) throws Exception {
        weddingServiceService.updateService(service);
        dataService.writeToFile(FileLocation.SERVICE);
    }

    @DeleteMapping("/services/{id}")
    @ResponseBody
    public void deleteService(@PathVariable Long id) throws Exception {
        weddingServiceService.removeServiceById(id);
        dataService.writeToFile(FileLocation.SERVICE);
    }
}
