package my.learning.oop.restaurantmanagement.service;

import my.learning.oop.restaurantmanagement.model.Bill;
import my.learning.oop.restaurantmanagement.model.Hall;
import my.learning.oop.restaurantmanagement.model.HallStatus;
import my.learning.oop.restaurantmanagement.util.QuarterUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BillService {

    private final List<Bill> billList;

    private final List<Hall> hallList;

    private final HallPriceService hallPriceService;

    public BillService(List<Bill> billList, List<Hall> hallList, HallPriceService hallPriceService) {
        this.billList = billList;
        this.hallList = hallList;
        this.hallPriceService = hallPriceService;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void addBill(Bill bill) {
        hallList.stream().filter(hall -> hall.getId().equals(bill.getHall().getId())).findFirst().ifPresent(hall -> {
            if(hall.getStatus().equals(HallStatus.AVAILABLE)){
                hall.setStatus(HallStatus.RESERVED);
            }else{
                throw new RuntimeException("Hall is not available");
            }
        });
        
        if(bill.getHall().getStatus().equals(HallStatus.RESERVED)){
            throw new RuntimeException("Hall is not available");
        }
        billList.add(bill);
    }

    public void removeBill(Bill bill) {
        billList.remove(bill);
    }

    public void updateBill(Bill bill) {
        billList.set(billList.indexOf(bill), bill);
    }

    public Bill getBillById(int id) {
        return billList.stream().filter(bill -> bill.getId() == id).findFirst().orElse(null);
    }

    public BigDecimal getSumBill(Date fromDate, Date toDate) {
        BigDecimal totalSum = BigDecimal.ZERO;
        for (Bill bill : billList) {
            if (bill.getOrganizationDate().after(fromDate) && bill.getOrganizationDate().before(toDate)) {
                totalSum = totalSum.add(bill.getSum());
            }
        }

        return totalSum;
    }

    public BigDecimal getSumByQuarters(QuarterUtil quarter){
        BigDecimal totalSum = BigDecimal.ZERO;
        Calendar calendar = Calendar.getInstance();
        for (Bill bill : billList) {
            calendar.setTime(bill.getOrganizationDate());
            int month = calendar.get(Calendar.MONTH);
            if(month >= quarter.getStartMonth() && month <= quarter.getEndMonth()){
                totalSum = totalSum.add(bill.getSum());
            }
            totalSum.add(hallPriceService.getHallPriceByDate(bill.getHall().getId(),bill.getOrganizationDate()));
        }

        return totalSum;
    }
}
