package quipux.co.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quipux.co.Bean.MyBeanWithProperties;
import quipux.co.Bean.MyBeanWithPropertiesImplements;
import quipux.co.pojo.User;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(User.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplements(name, apellido);
    }

//    @Bean
//    public DataSource dataSource(){
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.h2.Driver");
//        dataSourceBuilder.url("jdbc:h2:mem:prueba");
//        dataSourceBuilder.username("diana");
//        dataSourceBuilder.password("");
//        return dataSourceBuilder.build();
//    }
}
