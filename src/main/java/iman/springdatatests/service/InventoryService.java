package iman.springdatatests.service;

import java.util.List;
import java.util.logging.Logger;

import iman.springdatatests.dao.ProductRepository;
import iman.springdatatests.entity.Category;
import iman.springdatatests.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    private static final Logger logger =
            Logger.getLogger(InventoryService.class.getName());

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly=true)
    public void fetchProductsAndCategories() {

        List<Product> products = productRepository.findAll();

        for(Product product: products) {
            Category category = product.getCategory();
            logger.info(() -> "Product: " + product.getName() + ": Category: " + category.getName());
        }
    }
}