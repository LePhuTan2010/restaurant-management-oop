package my.learning.oop.restaurantmanagement.model;

import java.math.BigDecimal;
import java.util.Objects;
public class MenuItem {

    private static Long number = 0L;
    private Long id;

    private Product product;

    private Integer quantity;

    private BigDecimal price;

    public MenuItem(){this.id = number++;}

    public MenuItem(Product product, Integer quantity, BigDecimal price) {
        this.id = number++;
        this.product = product;
        this.quantity = quantity;
        this.price = BigDecimal.ZERO;
    }

    public static Long getNumber() {
        return number;
    }

    public static void setNumber(Long number) {
        MenuItem.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(id, menuItem.id) && Objects.equals(product, menuItem.product) && Objects.equals(quantity, menuItem.quantity) && Objects.equals(price, menuItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, quantity, price);
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
