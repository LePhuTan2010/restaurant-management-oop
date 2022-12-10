package my.learning.oop.restaurantmanagement.model;

import java.util.Objects;
public class ServicePerformer {
    private static Long number = 0L;
    private Long id;
    private String name;

    public ServicePerformer(){this.id = number++;}

    public ServicePerformer(String name) {
        this.id = number++;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicePerformer that = (ServicePerformer) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ServicePerfomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
