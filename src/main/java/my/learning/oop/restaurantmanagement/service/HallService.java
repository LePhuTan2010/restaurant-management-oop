package my.learning.oop.restaurantmanagement.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import my.learning.oop.restaurantmanagement.model.*;
import my.learning.oop.restaurantmanagement.util.FileLocation;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

    public void addHall(Hall hall){
        hallList.add(hall);
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
