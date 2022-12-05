package my.learning.oop.restaurantmanagement.model;


import java.math.BigDecimal;
import java.util.Objects;
public class Food extends Product{
    private Boolean isVegan;

    public Food(){}

    public Food(Boolean isVegan) {
        this.isVegan = isVegan;
    }

    public Food(String code, String name, BigDecimal price, ProductType type, Boolean isVegan) {
        super(code, name, price, type);
        this.isVegan = isVegan;
    }

    public Boolean getVegan() {
        return isVegan;
    }

    public void setVegan(Boolean vegan) {
        isVegan = vegan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Food drink = (Food) o;
        return Objects.equals(isVegan, drink.isVegan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isVegan);
    }

    @Override
    public String toString() {
        return "Food{" +
                "isVegan=" + isVegan +
                '}';
    }
}
