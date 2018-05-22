package com.uralfoxes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {


    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new JtaTransactionManager();
    }

    @Bean
    EntityManager em() {
        return Persistence.createEntityManagerFactory("uf_pu").createEntityManager();
    }

}
