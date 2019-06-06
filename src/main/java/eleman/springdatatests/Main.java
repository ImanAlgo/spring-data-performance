package eleman.springdatatests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import eleman.springdatatests.service.InventoryService;

@SpringBootApplication
public class Main {

    @Autowired
    private InventoryService inventoryService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Bean
    public ApplicationRunner init() {
        return args -> {

            inventoryService.fetchProductsAndCategories();
        };
    }
}