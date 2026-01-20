package com.example.step11.persistence;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.yml")
@Slf4j
class DataSourceConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.h2-embedded")
    public HikariConfig hikariConfig() {
        // @ConfigurationProperties 주해로 읽어온 정보로 HikariConfig 인스턴스 생성
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() {
        // return new HikariDataSource(hikariConfig());

        HikariConfig hikariConfig = hikariConfig();

        log.info("HikariConfig = {}", hikariConfig);
        log.info("HikariConfig.driverClassName = {}", hikariConfig.getDriverClassName());
        log.info("HikariConfig.jdbcUrl = {}", hikariConfig.getJdbcUrl());

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        log.info("dataSource = {}", dataSource);

        return dataSource;
    }
}