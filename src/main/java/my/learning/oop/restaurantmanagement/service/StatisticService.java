package my.learning.oop.restaurantmanagement.service;

import lombok.extern.slf4j.Slf4j;
import my.learning.oop.restaurantmanagement.model.Service;
import my.learning.oop.restaurantmanagement.model.ServicePerformer;
import my.learning.oop.restaurantmanagement.model.ServiceType;

import java.math.BigDecimal;


@org.springframework.stereotype.Service
@Slf4j
public class StatisticService {

    private final ServicePerformerService servicePerformerService;
    private final WeddingServiceService weddingServiceService;

    public StatisticService(ServicePerformerService servicePerformerService, WeddingServiceService weddingServiceService) {
        this.servicePerformerService = servicePerformerService;
        this.weddingServiceService = weddingServiceService;
    }

    public int getNumberOfServicePerfomers() {
        return servicePerformerService.getServicePerfomerList().size();
    }

    public int getNumberOfWeddingServices() {
        return weddingServiceService.getServiceList().size();
    }

    public BigDecimal getAveragePriceOfWeddingServices() {
        return weddingServiceService.getServiceList().stream()
                .map(Service::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(getNumberOfWeddingServices()));
    }

    public BigDecimal getAveragePriceOfWeddingServicesByType(ServiceType serviceType) {
        return weddingServiceService.getServiceList().stream()
                .filter(service -> service.getServiceType().equals(serviceType))
                .map(Service::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(getNumberOfWeddingServicesByType(serviceType)));
    }

    private long getNumberOfWeddingServicesByType(ServiceType serviceType) {
        return weddingServiceService.getServiceList().stream()
                .filter(service -> service.getServiceType().equals(serviceType))
                .count();
    }
}
