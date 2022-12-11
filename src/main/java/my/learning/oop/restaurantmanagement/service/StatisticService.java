package my.learning.oop.restaurantmanagement.service;

import lombok.extern.slf4j.Slf4j;
import my.learning.oop.restaurantmanagement.model.Service;
import my.learning.oop.restaurantmanagement.model.ServiceType;
import my.learning.oop.restaurantmanagement.util.QuarterUtil;

import java.math.BigDecimal;


@org.springframework.stereotype.Service
@Slf4j
public class StatisticService {

    private final ServicePerformerService servicePerformerService;
    private final WeddingServiceService weddingServiceService;

    private final BillService billService;

    public StatisticService(ServicePerformerService servicePerformerService, WeddingServiceService weddingServiceService, BillService billService) {
        this.servicePerformerService = servicePerformerService;
        this.weddingServiceService = weddingServiceService;
        this.billService = billService;
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

    //Get total price by quarter
    public BigDecimal getTotalPriceByQuarter(int quarter) {
        return switch (quarter) {
            case 1 -> billService.getSumByQuarters(QuarterUtil.FIRST);
            case 2 -> billService.getSumByQuarters(QuarterUtil.SECOND);
            case 3 -> billService.getSumByQuarters(QuarterUtil.THIRD);
            case 4 -> billService.getSumByQuarters(QuarterUtil.FOURTH);
            default -> BigDecimal.ZERO;
        };
    }
}
