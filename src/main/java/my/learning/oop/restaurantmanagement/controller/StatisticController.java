package my.learning.oop.restaurantmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import my.learning.oop.restaurantmanagement.model.ServiceType;
import my.learning.oop.restaurantmanagement.service.StatisticService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class StatisticController{
    private final StatisticService statisticService;
    private final List<ServiceType> serviceTypeList;

    public StatisticController(StatisticService statisticService, List<ServiceType> serviceTypeList) {
        this.statisticService = statisticService;
        this.serviceTypeList = serviceTypeList;
    }

    @GetMapping("/statistic/average-price-of-wedding-services")
    @ResponseBody
    public BigDecimal getStatistic() {
        return statisticService.getAveragePriceOfWeddingServices();
    }

    @GetMapping("/statistic/average-price-of-wedding-services/{id}")
    @ResponseBody
    public BigDecimal getStatisticByServiceType(@PathVariable("id") Long serviceTypeId) {
        ServiceType type = serviceTypeList.stream()
                .filter(serviceType -> serviceType.getId().equals(serviceTypeId))
                .findFirst()
                .orElse(null);
        if(null != type){
            return statisticService.getAveragePriceOfWeddingServicesByType(type);
        }
        return BigDecimal.ONE;
    }

    @GetMapping("/statistic/quarter/{quarter}")
    @ResponseBody
    public BigDecimal getStatisticByQuarter(Integer quarter) {
        return statisticService.getTotalPriceByQuarter(quarter);
    }
}
