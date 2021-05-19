package com.springboot.crud.repository;

import com.springboot.crud.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Book(
                    "Hunter x Hunter",
                    "Togashi",
                    "Gon procurando o pai que é um Hunter",
                    "Japonês",
                    "Shounen Jump",
                    29.99,
                    "01/01/1998"
            )));
            log.info("Preloading " + repository.save(new Book(
                    "Yu Yu Hakusho",
                    "Togashi",
                    "Tirinhos pelo dedo",
                    "Japonês",
                    "Shounen Jump",
                    29.99,
                    "01/01/1989"
            )));
        };
    }

}
