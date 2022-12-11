package my.learning.oop.restaurantmanagement.model;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class HallPrice {

    private static Long number = 0L;
    private Long id;
    private Date fromDate;

    private Hall hall;
    private Date toDate;
    private BigDecimal price;

    public HallPrice(){
        this.id = number++;
    }

    public HallPrice(Date fromDate, Date toDate, BigDecimal price, Hall hall) {
        this.id = number++;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.price = price;
        this.hall = hall;
    }

    public static Long getNumber() {
        return number;
    }

    public static void setNumber(Long number) {
        HallPrice.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HallPrice hallPrice = (HallPrice) o;
        return Objects.equals(id, hallPrice.id) && Objects.equals(fromDate, hallPrice.fromDate) && Objects.equals(hall, hallPrice.hall) && Objects.equals(toDate, hallPrice.toDate) && Objects.equals(price, hallPrice.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromDate, hall, toDate, price);
    }

    @Override
    public String toString() {
        return "HallPrice{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", hall=" + hall +
                ", toDate=" + toDate +
                ", price=" + price +
                '}';
    }
}
