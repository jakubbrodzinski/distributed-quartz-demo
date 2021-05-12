package com.example.distributedquartzdemo.configurations;

import com.example.distributedquartzdemo.repositories.BookRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = BookRepository.class)
@Configuration
public class AppConfiguration {
}
