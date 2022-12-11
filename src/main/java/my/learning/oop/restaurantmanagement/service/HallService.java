package my.learning.oop.restaurantmanagement.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import my.learning.oop.restaurantmanagement.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HallService {

    private final List<Hall> hallList;

    public HallService(List<Hall> hallList) {
        this.hallList = hallList;
    }

    public List<Hall> getHallList() {
        return hallList;
    }

    public Hall getHallById(String id){
        return hallList.stream()
                .filter(hall -> hall.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addHall(Hall hall){
        Hall newHall = new Hall();
        newHall.setName(hall.getName());
        newHall.setCapacity(hall.getCapacity());
        newHall.setStatus(hall.getStatus());
        newHall.setCode(hall.getCode());
        newHall.setLocation(hall.getLocation());
        hallList.add(newHall);
    }

    public void removeHall(Hall hall){
        hallList.remove(hall);
    }

    public void removeHallById(String id){
        hallList.removeIf(hall -> hall.getId() == id);
    }

    public void updateHall(Hall hall){
        hallList.stream()
                .filter(h -> h.getId().equals(hall.getId()))
                .forEach(h -> {
                    h.setName(hall.getName());
                    h.setCapacity(hall.getCapacity());
                    h.setLocation(hall.getLocation());
                    h.setStatus(hall.getStatus());
                });
    }
}
