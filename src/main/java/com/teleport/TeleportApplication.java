package com.teleport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.teleport")
@EntityScan(basePackages = "com.teleport.entity")
@EnableJpaRepositories(basePackages = "com.teleport.repository")
public class TeleportApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeleportApplication.class, args);
    }
}
