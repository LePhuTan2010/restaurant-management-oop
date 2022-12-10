package my.learning.oop.restaurantmanagement.config;

import my.learning.oop.restaurantmanagement.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanConfiguration {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public List<Hall> hallList() { return new ArrayList<>(); }

    @Bean
    public List<Bill> billList() { return new ArrayList<>(); }

    @Bean
    public List<Menu> menuList() { return new ArrayList<>(); }

    @Bean
    public List<MenuItem> menuItemList() { return new ArrayList<>(); }

    @Bean
    public List<Service> serviceList() { return new ArrayList<>(); }

    @Bean
    public List<ServicePerformer> servicePerfomerList() { return new ArrayList<>(); }

    @Bean
    public List<ServiceType> serviceTypeList() { return new ArrayList<>(); }

    @Bean
    public List<Manufacturer> manufacturerList() { return new ArrayList<>(); }

    @Bean
    public List<HallPrice> hallPriceList() { return new ArrayList<>(); }

    @Bean
    public List<Product> productList() { return new ArrayList<>(); }

    @Bean
    public List<ProductType> productTypeList() { return new ArrayList<>(); }
}
