package my.learning.oop.restaurantmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Bill {
    private static Long number = 0L;
    private Long id;

    private String partyName;

    private Hall hall;

    private Menu menu;

    private List<Service> services = new ArrayList<>();

    private Date bookingDate;

    private Date organizationDate;

    private Integer numberOfTables;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;

    public Bill(){
        this.id = number++;
    }

    public Bill(String partyName, Hall hall, Menu menu, List<Service> services, Date organizationDate,
                Integer numberOfTables) {
        this.id = number++;
        this.partyName = partyName;
        this.hall = hall;
        this.menu = menu;
        this.services = services;
        this.bookingDate = new Date();
        this.organizationDate = organizationDate;
        this.numberOfTables = numberOfTables;
        this.price = getSum();
    }

    public static Long getNumber() {
        return number;
    }

    public static void setNumber(Long number) {
        Bill.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getOrganizationDate() {
        return organizationDate;
    }

    public void setOrganizationDate(Date organizationDate) {
        this.organizationDate = organizationDate;
    }

    public Integer getNumberOfTables() {
        return numberOfTables;
    }

    public void setNumberOfTables(Integer numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public BigDecimal getSum(){
        BigDecimal sum = BigDecimal.ZERO;
        if(services.isEmpty()){
            return sum;
        }
        for (Service service : services) {
            if(null != service && null != service.getPrice()){
                sum = sum.add(service.getPrice());
            }
        }
        if(null != menu && null != menu.getTotalPrice()){
            sum.add(menu.getTotalPrice());
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(id, bill.id) && Objects.equals(partyName, bill.partyName) && Objects.equals(hall, bill.hall) && Objects.equals(menu, bill.menu) && Objects.equals(services, bill.services) && Objects.equals(bookingDate, bill.bookingDate) && Objects.equals(organizationDate, bill.organizationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partyName, hall, menu, services, bookingDate, organizationDate);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", partyName='" + partyName + '\'' +
                ", hall=" + hall +
                ", menu=" + menu +
                ", services=" + services +
                ", bookingDate=" + bookingDate +
                ", organizationDate=" + organizationDate +
                '}';
    }
}
