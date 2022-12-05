package my.learning.oop.restaurantmanagement.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Service {

    private static Long number = 0L;
    private Long id;
    private String code;
    private String name;
    private BigDecimal price;
    private ServiceType serviceType;

    private ServicePerfomer servicePerfomer;

    public Service(){this.id = number++;}

    public Service(String code, String name, BigDecimal price, ServiceType serviceType) {
        this.id = number++;
        this.code = code;
        this.name = name;
        this.price = price;
        this.serviceType = serviceType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public ServicePerfomer getServicePerfomer() {
        return servicePerfomer;
    }

    public void setServicePerfomer(ServicePerfomer servicePerfomer) {
        this.servicePerfomer = servicePerfomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(id, service.id) && Objects.equals(code, service.code) && Objects.equals(name, service.name) && Objects.equals(price, service.price) && Objects.equals(serviceType, service.serviceType) && Objects.equals(servicePerfomer, service.servicePerfomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, price, serviceType, servicePerfomer);
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", serviceType=" + serviceType +
                ", servicePerfomer=" + servicePerfomer +
                '}';
    }
}
