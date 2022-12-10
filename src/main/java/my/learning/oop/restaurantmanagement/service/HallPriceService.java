package my.learning.oop.restaurantmanagement.service;

import my.learning.oop.restaurantmanagement.model.HallPrice;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class HallPriceService {
    private final List<HallPrice> hallPriceList;

    public HallPriceService(List<HallPrice> hallPriceList) {
        this.hallPriceList = hallPriceList;
    }

    public List<HallPrice> getHallPriceList() {
        return hallPriceList;
    }

    public void addHallPrice(HallPrice hallPrice) {
        hallPriceList.add(hallPrice);
    }

    public void removeHallPrice(HallPrice hallPrice) {
        hallPriceList.remove(hallPrice);
    }

    public void updateHallPrice(HallPrice hallPrice) {
        hallPriceList.set(hallPriceList.indexOf(hallPrice), hallPrice);
    }

    public HallPrice getHallPriceById(int id) {
        return hallPriceList.stream().filter(hallPrice -> hallPrice.getId() == id).findFirst().orElse(null);
    }

    public HallPrice getHallPriceByHallId(String hallId) {
        return hallPriceList.stream().filter(hallPrice -> hallPrice.getHall().getId().equals(hallId)).findFirst().orElse(null);
    }

    public HallPrice getHallPriceByHallCode(String hallCode) {
        return hallPriceList.stream().filter(hallPrice -> hallPrice.getHall().getCode().equals(hallCode)).findFirst().orElse(null);
    }

    public BigDecimal getHallPriceByDate(String hallId, Date date) {
        HallPrice hallPrice = getHallPriceByHallId(hallId);
        if (hallPrice != null) {
            if (date.after(hallPrice.getFromDate()) && date.before(hallPrice.getToDate())) {
                return hallPrice.getPrice();
            }
        }
        return null;
    }
}
