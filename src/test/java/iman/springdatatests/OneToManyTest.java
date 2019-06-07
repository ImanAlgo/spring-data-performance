package iman.springdatatests;

import iman.springdatatests.dao.CategoryRepository;
import iman.springdatatests.dao.ProductRepository;
import iman.springdatatests.entity.Category;
import iman.springdatatests.entity.Product;
import iman.springdatatests.specification.CategorySpecification;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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

        assertThat(actualProduct, containsInAnyOrder(expectedProducts));

        for(Product product: actualProduct) {
            Category category = product.getCategory();
            logger.info(() -> "Product: " + product.getName() + ": Category: " + category.getName());
        }
    }

    /**
     * A fetchAll test with specification and adding INNER JOIN, GROUP BY, HAVING to the query
     */
    @Transactional(readOnly=true)
    @Test
    public void findAllLargeCategoryTest() {

        /*
        Neither having EAGER nor LAZY fetch can have affect the number of generated queries which was as the follow:
        Hibernate: select category0_.id as id1_0_, category0_.name as name2_0_ from category category0_ inner join product products1_ on category0_.id=products1_.category_id group by category0_.id , category0_.name having count(1)>1
        */

        List<Category> actualCats = categoryRepository.findAll(CategorySpecification.categoryIsLarge());
        String expectedPropertyName = "name";
        String expectedPropertyValue = "Radio";

        assertThat(actualCats, contains(hasProperty(expectedPropertyName, equalTo(expectedPropertyValue))));

//        logger.info(actualCats.stream()
//                .map(c->String.format("[%s (%s)]",c.getName(), c.getProducts().size()))
//                .collect(Collectors.joining(" ")));

    }

}
