package eleman.springdatatests;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class TestConfiguration {

//    @Bean
//    public DataSource dataSource() {
//        EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
//        return dbBuilder.setType(EmbeddedDatabaseType.H2)
//                .addScript("classpath:/data.sql")
//                .build();
//    }
}