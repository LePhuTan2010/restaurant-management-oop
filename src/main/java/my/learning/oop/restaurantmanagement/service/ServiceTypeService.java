package my.learning.oop.restaurantmanagement.service;

import my.learning.oop.restaurantmanagement.model.ServiceType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService {
    private final List<ServiceType> serviceTypeList;

    public ServiceTypeService(List<ServiceType> serviceTypeList) {
        this.serviceTypeList = serviceTypeList;
    }

    public List<ServiceType> getServiceTypeList() {
        return serviceTypeList;
    }

    public ServiceType getServiceTypeById(Long id) {
        return serviceTypeList.stream()
                .filter(serviceType -> serviceType.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public ServiceType getServiceTypeByName(String name) {
        return serviceTypeList.stream()
                .filter(serviceType -> serviceType.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void addServiceType(ServiceType serviceType) {
        serviceTypeList.add(serviceType);
    }

    public void removeServiceType(ServiceType serviceType) {
        serviceTypeList.remove(serviceType);
    }

    public void removeServiceTypeById(Long id) {
        serviceTypeList.removeIf(serviceType -> serviceType.getId() == id);
    }

    public void updateServiceType(ServiceType serviceType) {
        ServiceType serviceTypeToUpdate = getServiceTypeById(serviceType.getId());
        if (serviceTypeToUpdate != null) {
            serviceTypeToUpdate.setName(serviceType.getName());
        }
    }
}
