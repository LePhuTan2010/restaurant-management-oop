package my.learning.oop.restaurantmanagement.model;


import java.math.BigDecimal;
import java.util.Objects;

public class Karaoke extends Service{
    private Integer rentTime;

    public Karaoke(){}

    public Karaoke(Integer rentTime) {
        this.rentTime = rentTime;
    }

    public Karaoke(String code, String name, BigDecimal price, ServiceType serviceType, Integer rentTime) {
        super(code, name, price, serviceType);
        this.rentTime = rentTime;
    }

    public Integer getRentTime() {
        return rentTime;
    }

    public void setRentTime(Integer rentTime) {
        this.rentTime = rentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Karaoke karaoke = (Karaoke) o;
        return Objects.equals(rentTime, karaoke.rentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rentTime);
    }

    @Override
    public String toString() {
        return "Karaoke{" +
                "rentTime=" + rentTime +
                '}';
    }
}
