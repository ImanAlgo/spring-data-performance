package iman.springdatatests.specification;

import iman.springdatatests.entity.Category;
import iman.springdatatests.entity.Category_;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.JoinType;
import java.util.Arrays;

public class CategorySpecification {

        public static Specification<Category> categoryIsLarge() {
            return (root, query, cb) ->{

                // Force the query join with product
                root.join(Category_.products, JoinType.INNER);

                // Here is how to add GROUPBY and HAVING to the query, notice that
                // the GROUPBY needs to list all the fields used in the select clause
                return query
                        .groupBy(Arrays.asList(
                                root.get(Category_.id),
                                root.get(Category_.name)
                        ))
                        .having(cb.gt(cb.count(cb.literal(1)), 1))
                        .getRestriction();
            };
        }
}
