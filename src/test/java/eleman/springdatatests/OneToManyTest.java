package eleman.springdatatests;

import eleman.springdatatests.dao.CategoryRepository;
import eleman.springdatatests.dao.ProductRepository;
import eleman.springdatatests.entity.Category;
import eleman.springdatatests.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OneToManyTest {

    private static final Logger logger = Logger.getLogger(OneToManyTest.class.getName());

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Transactional(readOnly=true)
    @Test
    public void findAllProduct() {


        Product[] expectedProducts = {
                new Product(1l, "USB", null),
                new Product(2l, "HDD", null),
                new Product(3l, "CPU", null),
                new Product(4l, "CPU", null),
                new Product(5l, "HDD", null),
                new Product(6l, "USB", null)
        };

        List<Product> actualProduct = productRepository.findAll();

//        MatcherAssert.assertThat(actualProduct,
//                Matchers.containsInAnyOrder(expectedProducts));

        //List<Product> products = productRepository.findAll();

        for(Product product: actualProduct) {
            Category category = product.getCategory();
            logger.info(() -> "Product: " + product.getName() + ": Category: " + category.getName());
        }
    }

}
