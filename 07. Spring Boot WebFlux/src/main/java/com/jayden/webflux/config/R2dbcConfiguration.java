package com.jayden.webflux.config;

import com.jayden.webflux.customer.Customer;
import com.jayden.webflux.customer.CustomerRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import java.time.Duration;
import java.util.Arrays;

@Configuration
@EnableR2dbcRepositories(basePackages = "com.jayden.webflux")
public class R2dbcConfiguration {

    private static final Logger log = LoggerFactory.getLogger(R2dbcConfiguration.class);

    @Bean
    public ConnectionFactoryInitializer connectionFactoryInitializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        return initializer;
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> repository.saveAll(Arrays.asList(
            Customer.builder()
                .firstName("Jack")
                .lastName("Bauer")
                .build(),
            Customer.builder()
                .firstName("Chloe")
                .lastName("O'Brian")
                .build(),
            Customer.builder()
                .firstName("Kim")
                .lastName("Bauer")
                .build(),
            Customer.builder()
                .firstName("David")
                .lastName("Palmer")
                .build(),
            Customer.builder()
                .firstName("Michelle")
                .lastName("Dessler")
                .build(),
            Customer.builder()
                .firstName("Lee")
                .lastName("Bauer")
                .build())
        ).blockLast(Duration.ofSeconds(10));
    }
}
