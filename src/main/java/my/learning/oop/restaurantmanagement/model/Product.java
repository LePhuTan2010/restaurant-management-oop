package my.learning.oop.restaurantmanagement.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private static Long number = 0L;
    private Long id;
    private String code;
    private String name;
    private BigDecimal price;

    private ProductType productType;

    public Product() {this.id = number++;}

    public Product(String code, String name, BigDecimal price, ProductType productType) {
        this.id = number++;
        this.code = code;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id){ this.id = id; }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(code, product.code) && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(productType, product.productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, price, productType);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type=" + productType +
                '}';
    }
}
