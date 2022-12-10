package my.learning.oop.restaurantmanagement;

import lombok.extern.slf4j.Slf4j;
import my.learning.oop.restaurantmanagement.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RestaurantManagementApplication implements ApplicationRunner {

	@Autowired
	private DataService dataService;

	public static void main(String[] args) {
		SpringApplication.run(RestaurantManagementApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		dataService.loadDataFromFile();
	}
}
