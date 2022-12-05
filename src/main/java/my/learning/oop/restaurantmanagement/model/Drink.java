package my.learning.oop.restaurantmanagement.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Drink extends Product{
    private Manufacturer manufacturer;

    public Drink(){}

    public Drink(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Drink(String code, String name, BigDecimal price, ProductType productType, Manufacturer manufacturer) {
        super(code, name, price, productType);
        this.manufacturer = manufacturer;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Drink drink = (Drink) o;
        return Objects.equals(manufacturer, drink.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), manufacturer);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "manufacturer=" + manufacturer +
                '}';
    }
}
