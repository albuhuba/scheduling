package com.huba.scheduling.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(Constants.BASE_PACKAGES)
// TODO ORM will have @EntityScan
public class Bootstrapper {

    public static void main(String... args) {
        SpringApplication.run(Bootstrapper.class);
    }

}
