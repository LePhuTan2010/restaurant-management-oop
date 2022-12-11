package my.learning.oop.restaurantmanagement.model;

import java.math.BigDecimal;
import java.util.*;
public class Menu {

    private static Long number = 0L;

    private Long id;

    private List<MenuItem> menuItems = new ArrayList<>();

    private BigDecimal totalPrice;

    private Date timeStamp;

    private Date payDate;

    public Menu(){this.id = number++;}

    public Menu(List<MenuItem> menuItems, BigDecimal totalPrice, Date timeStamp, Date payDate) {
        this.id = number++;
        this.menuItems = menuItems;
        this.totalPrice = getPrice();
        this.timeStamp = timeStamp;
        this.payDate = payDate;
    }

    public static Long getNumber() {
        return number;
    }

    public static void setNumber(Long number) {
        Menu.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public BigDecimal getPrice(){
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (MenuItem menuItem : menuItems) {
            totalPrice = totalPrice.add(menuItem.getPrice());
        }
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) && Objects.equals(menuItems, menu.menuItems) && Objects.equals(totalPrice, menu.totalPrice) && Objects.equals(timeStamp, menu.timeStamp) && Objects.equals(payDate, menu.payDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuItems, totalPrice, timeStamp, payDate);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuItems=" + menuItems +
                ", totalPrice=" + totalPrice +
                ", timeStamp=" + timeStamp +
                ", payDate=" + payDate +
                '}';
    }
}
