package my.learning.oop.restaurantmanagement.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import my.learning.oop.restaurantmanagement.model.*;
import my.learning.oop.restaurantmanagement.util.FileLocation;
import org.modelmapper.ModelMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
@Slf4j
public class DataService {

    private final ModelMapper modelMapper;
    private final List<Hall> hallList;
    private final List<Bill> billList;
    private final List<Menu> menuList;
    private final List<MenuItem> menuItemList;
    private final List<Service> serviceList;
    private final List<ServicePerformer> servicePerformerList;
    private final List<ServiceType> serviceTypeList;
    private final List<Manufacturer> manufacturerList;
    private final List<HallPrice> hallPriceList;
    private final List<Product> productList;
    private final List<ProductType> productTypeList;

    public DataService(ModelMapper modelMapper, List<Hall> hallList, List<Bill> billList, List<Menu> menuList,
                       List<MenuItem> menuItemList, List<Service> serviceList,
                       List<ServicePerformer> servicePerformerList, List<ServiceType> serviceTypeList,
                       List<Manufacturer> manufacturerList, List<HallPrice> hallPriceList,
                       List<Product> productList, List<ProductType> productTypeList) {
        this.modelMapper = modelMapper;
        this.hallList = hallList;
        this.billList = billList;
        this.menuList = menuList;
        this.menuItemList = menuItemList;
        this.serviceList = serviceList;
        this.servicePerformerList = servicePerformerList;
        this.serviceTypeList = serviceTypeList;
        this.manufacturerList = manufacturerList;
        this.hallPriceList = hallPriceList;
        this.productList = productList;
        this.productTypeList = productTypeList;
    }

    public void loadDataFromFile(){
        for (FileLocation fileLocation : FileLocation.values()) {
            loadData(fileLocation);
        }
    }

    public List<?> getListByFileLocation(FileLocation fileLocation){
        return switch (fileLocation.getId()) {
            case 1 -> hallList;
            case 2 -> billList;
            case 3 -> menuList;
            case 4 -> menuItemList;
            case 5 -> serviceList;
            case 6 -> servicePerformerList;
            case 7 -> serviceTypeList;
            case 8 -> manufacturerList;
            case 9 -> hallPriceList;
            case 10 -> productList;
            case 11 -> productTypeList;
            default -> null;
        };
    }

    public void loadData(FileLocation fileLocation) {~
        try {
            URI uri = getClass().getClassLoader().getResource(fileLocation.getPath()).toURI();
            Path path = Paths.get(uri);
            ObjectMapper objectMapper = new ObjectMapper();
            List<?> list = getListByFileLocation(fileLocation);
            list.addAll(objectMapper.readValue(Files.newBufferedReader(path, StandardCharsets.UTF_8), ArrayList.class));
            log.info("{}: {}", fileLocation.name() ,getListByFileLocation(fileLocation));
        } catch (Exception e) {
            log.error("Error: Can't find file {}", fileLocation.getPath());
        }
    }

    public void writeToFile(FileLocation fileLocation) throws IOException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();
        URI uri = getClass().getClassLoader().getResource(fileLocation.getPath()).toURI();
        Path path = Paths.get(uri);
        log.info("Writing an Object to JSON file");
        mapper.writeValue(Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                StandardOpenOption.WRITE), getListByFileLocation(fileLocation));
    }
}
