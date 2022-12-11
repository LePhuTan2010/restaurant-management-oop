package my.learning.oop.restaurantmanagement.controller;

import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import my.learning.oop.restaurantmanagement.model.Bill;
import my.learning.oop.restaurantmanagement.service.BillService;
import my.learning.oop.restaurantmanagement.service.DataService;
import my.learning.oop.restaurantmanagement.util.FileLocation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class BillController {
    private final DataService dataService;
    private final BillService billService;

    public BillController(DataService dataService, BillService billService) {
        this.dataService = dataService;
        this.billService = billService;
    }

    @GetMapping("/bills")
    @ResponseBody
    public List<Bill> getAllBills() {
        return billService.getBillList();
    }

    @GetMapping("/bills/{id}")
    @ResponseBody
    public Bill getBillById(@PathParam("id") Integer id) {
        return billService.getBillById(id);
    }

    @PostMapping("/bills")
    @ResponseBody
    public void createBill(@RequestBody Bill bill) throws Exception {
        billService.addBill(bill);
        dataService.writeToFile(FileLocation.BILL);
    }

}
