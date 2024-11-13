package com.example.cores.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.example.cores.repository")
@ComponentScan("com.example.cores")
public class AppConfig {

    @Bean
    public String someConfiguration() {
        return "Some custom configuration";
    }
}

/* 7654321	`QW
 * If you have any configuration like enabling JPA repositories or other
 * settings, you can add them in AppConfig.java.
 * 
 */