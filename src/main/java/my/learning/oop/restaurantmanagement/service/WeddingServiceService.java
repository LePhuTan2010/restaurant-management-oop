package my.learning.oop.restaurantmanagement.service;

import lombok.extern.slf4j.Slf4j;
import my.learning.oop.restaurantmanagement.model.Service;

import java.util.List;
import java.util.Objects;

@org.springframework.stereotype.Service
@Slf4j
public class WeddingServiceService {

    private final List<Service> serviceList;

    public WeddingServiceService(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void addService(Service service) {
        serviceList.add(service);
    }

    public void removeService(Service service) {
        serviceList.remove(service);
    }

    public void removeServiceById(Long id) {
        serviceList.removeIf(service -> Objects.equals(service.getId(), id));
    }

    public void updateService(Service service) {
        serviceList.stream()
                .filter(s -> s.getId().equals(service.getId()))
                .forEach(s -> {
                    s.setName(service.getName());
                    s.setPrice(service.getPrice());
                    s.setServiceType(service.getServiceType());
                    s.setServicePerfomer(service.getServicePerfomer());
                });
    }
}


