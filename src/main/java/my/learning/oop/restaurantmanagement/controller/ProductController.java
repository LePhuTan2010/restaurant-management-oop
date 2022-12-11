package my.learning.oop.restaurantmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import my.learning.oop.restaurantmanagement.model.Product;
import my.learning.oop.restaurantmanagement.service.DataService;
import my.learning.oop.restaurantmanagement.service.ProductService;
import my.learning.oop.restaurantmanagement.util.FileLocation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class ProductController {
    private final ProductService productService;
    private final DataService dataService;

    public ProductController(ProductService productService, DataService dataService) {
        this.productService = productService;
        this.dataService = dataService;
    }

    @GetMapping("/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getProductList();
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    @ResponseBody
    public void addProduct(@RequestBody Product product) throws Exception {
        productService.addProduct(product);
        dataService.writeToFile(FileLocation.PRODUCT);
    }

    @PutMapping("/products")
    @ResponseBody
    public void updateProduct(@RequestBody Product product) throws Exception {
        productService.updateProduct(product);
        dataService.writeToFile(FileLocation.PRODUCT);
    }

    @DeleteMapping("/products/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable Long id) throws Exception {
        productService.removeProductById(id);
        dataService.writeToFile(FileLocation.PRODUCT);
    }
}
