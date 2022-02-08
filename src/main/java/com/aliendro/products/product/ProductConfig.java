package com.aliendro.products.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository) {
        return args -> {
            Product product1 = new Product(
                    "Sony DX-8",
                    "Equipo de audio",
                    18000,
                    "https://via.placeholder.com/300.jpg?text=Sony+DX-8"
            );

            Product product2 = new Product(
                    "Sony Bravia 32s",
                    "TV LCD",
                    14000,
                    "https://via.placeholder.com/300.jpg?text=Sony+Bravia+32s"
            );

            repository.saveAll(List.of(product1, product2));
        };
    }
}
