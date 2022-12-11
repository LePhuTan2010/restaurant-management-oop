package my.learning.oop.restaurantmanagement.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.extern.slf4j.Slf4j;
import my.learning.oop.restaurantmanagement.model.*;
import my.learning.oop.restaurantmanagement.util.FileLocation;
import org.modelmapper.ModelMapper;

import java.io.IOException;
import java.io.Reader;
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
        setPropertiesNumber();
    }

    public List<?> getListByFileLocation(FileLocation fileLocation){
        return switch(fileLocation){
            case HALL -> hallList;
            case BILL -> billList;
            case MENU -> menuList;
            case MENU_ITEM -> menuItemList;
            case SERVICE -> serviceList;
            case SERVICE_PERFORMER -> servicePerformerList;
            case SERVICE_TYPE -> serviceTypeList;
            case MANUFACTURER -> manufacturerList;
            case HALL_PRICE -> hallPriceList;
            case PRODUCT -> productList;
            case PRODUCT_TYPE -> productTypeList;
            default -> throw new IllegalStateException("Unexpected value: " + fileLocation);
        };
    }

    public void loadData(FileLocation fileLocation) {
        try {
            URI uri = getClass().getClassLoader().getResource(fileLocation.getPath()).toURI();
            Path path = Paths.get(uri);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.findAndRegisterModules();
            Class clazz = getClassFromList(fileLocation);
            List<?> list = getListByFileLocation(fileLocation);
            list.addAll(objectMapper.readValue(Files.newBufferedReader(path, StandardCharsets.UTF_8), TypeFactory.defaultInstance().constructCollectionType(List.class, clazz)));
            log.info("{}: {}", fileLocation.name() ,getListByFileLocation(fileLocation));
        } catch (Exception e) {
            log.error("Error: Can't find file {}", fileLocation.getPath());
            log.error(e.getMessage());
        }
    }

    public Class getClassFromList(FileLocation fileLocation){
        return switch(fileLocation){
            case HALL -> Hall.class;
            case BILL -> Bill.class;
            case MENU -> Menu.class;
            case MENU_ITEM -> MenuItem.class;
            case SERVICE -> Service.class;
            case SERVICE_PERFORMER -> ServicePerformer.class;
            case SERVICE_TYPE -> ServiceType.class;
            case MANUFACTURER -> Manufacturer.class;
            case HALL_PRICE -> HallPrice.class;
            case PRODUCT -> Product.class;
            case PRODUCT_TYPE -> ProductType.class;
            default -> throw new IllegalStateException("Unexpected value: " + fileLocation);
        };
    }

    //set properties number of model
    public void setPropertiesNumber(){
        Hall.setNumber((long) hallList.size());
        Bill.setNumber((long) billList.size());
        Menu.setNumber((long) menuList.size());
        MenuItem.setNumber((long) menuItemList.size());
        Service.setNumber((long) serviceList.size());
        ServicePerformer.setNumber((long) servicePerformerList.size());
        ServiceType.setNumber((long) serviceTypeList.size());
        Manufacturer.setNumber((long) manufacturerList.size());
        HallPrice.setNumber((long) hallPriceList.size());
        Product.setNumber((long) productList.size());
        ProductType.setNumber((long) productTypeList.size());
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
