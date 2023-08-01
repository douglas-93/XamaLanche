package com.dmm.xamalanche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.dmm.xamalanche.repository")
@SpringBootApplication
public class XamaLancheApplication {

    public static void main(String[] args) {
        SpringApplication.run(XamaLancheApplication.class, args);
    }

}
