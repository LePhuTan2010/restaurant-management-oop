package my.learning.oop.restaurantmanagement.model;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class HallPrice {

    private static Long number = 0L;

    private Long id;
    private Date fromDate;
    private Date toDate;
    private BigDecimal price;

    public HallPrice(){
        this.id = number++;
    }

    public HallPrice(Date fromDate, Date toDate, BigDecimal price) {
        this.id = number++;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HallPrice hallPrice = (HallPrice) o;
        return Objects.equals(id, hallPrice.id) && Objects.equals(fromDate, hallPrice.fromDate) && Objects.equals(toDate, hallPrice.toDate) && Objects.equals(price, hallPrice.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromDate, toDate, price);
    }

    @Override
    public String toString() {
        return "HallPrice{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", price=" + price +
                '}';
    }
}
