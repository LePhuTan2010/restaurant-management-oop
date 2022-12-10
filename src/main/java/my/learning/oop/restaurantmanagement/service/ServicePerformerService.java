package my.learning.oop.restaurantmanagement.service;

import lombok.extern.slf4j.Slf4j;
import my.learning.oop.restaurantmanagement.model.ServicePerformer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ServicePerformerService {

    private final List<ServicePerformer> servicePerformerList;

    public ServicePerformerService(List<ServicePerformer> servicePerformerList) {
        this.servicePerformerList = servicePerformerList;
    }

    public List<ServicePerformer> getServicePerfomerList() {
        return servicePerformerList;
    }

    public void addServicePerfomer(ServicePerformer servicePerformer) {
        servicePerformerList.add(servicePerformer);
    }

    public void removeServicePerfomer(ServicePerformer servicePerformer) {
        servicePerformerList.remove(servicePerformer);
    }

    public void removeServicePerfomerById(int id) {
        servicePerformerList.removeIf(servicePerfomer -> servicePerfomer.getId() == id);
    }

    public ServicePerformer getServicePerfomerById(Long id) {
        return servicePerformerList.stream()
                .filter(servicePerfomer -> Objects.equals(servicePerfomer.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public void updateServicePerfomer(ServicePerformer servicePerformer) {
        ServicePerformer servicePerformerToUpdate = getServicePerfomerById(servicePerformer.getId());
        if (servicePerformerToUpdate != null) {
            servicePerformerToUpdate.setName(servicePerformer.getName());
        }
    }
}
