package my.learning.oop.restaurantmanagement.service;

import my.learning.oop.restaurantmanagement.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    private final List<Product> productList;

    public ProductService(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    public void removeProductById(Long id) {
        productList.removeIf(product -> Objects.equals(product.getId(), id));
    }

    public void updateProduct(Product product) {
        productList.set(productList.indexOf(product), product);
    }

    public Product getProductById(int id) {
        return productList.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

}
