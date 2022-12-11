package my.learning.oop.restaurantmanagement.model;

import java.util.Objects;

public class Hall {

    private static final String PREFIX = "S";
    private static Long number = 0L;

    private String id;
    private String code;
    private String name;
    private String location;
    private Integer capacity;
    private HallStatus status;

    public Hall(){
        this.id = String.format("%s%03d",PREFIX,number++);
    }

    public Hall(String code, String name, String location, Integer capacity, HallStatus status) {
        this.id = String.format("%s%03d",PREFIX,number++);
        this.code = code;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.status = status;
    }

    public static Long getNumber() {
        return number;
    }

    public static void setNumber(Long number) {
        Hall.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id;}

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public HallStatus getStatus() {
        return status;
    }

    public void setStatus(HallStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hall hall = (Hall) o;
        return Objects.equals(id, hall.id) && Objects.equals(code, hall.code) && Objects.equals(name, hall.name) && Objects.equals(location, hall.location) && Objects.equals(capacity, hall.capacity) && status == hall.status;
    }

    /*
        Object 1  | Object 2
        Object 1 == Object 2 ? -> Sử dụng method equals
        Object1.equals(Object2)
        Object 1 == Object 2 ? hashcode 1 == hashcode 2
        hashcode1 == hashcode 2 -> Object 1 != Object 2 || Object 1 == Object 2
     */

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, location, capacity, status);
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", status=" + status +
                '}';
    }
}
