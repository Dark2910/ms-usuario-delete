package com.eespindola.ms.delete.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
public class HikariDataSourceConfig {

    private final String URL;
    private final String USERNAME;
    private final String PASSWORD;
    public static String DRIVER_CLASS_NAME;

    public HikariDataSourceConfig(
            @Value("${DB.CONNECTION.URL}") String url,
            @Value("${DB.CONNECTION.USERNAME}") String username,
            @Value("${DB.CONNECTION.PASSWORD}") String password,
            @Value("${DB.CONNECTION.DRIVER_CLASS_NAME}") String driverClassName
    ) {
        this.URL = url;
        this.USERNAME = username;
        this.PASSWORD = password;
        HikariDataSourceConfig.DRIVER_CLASS_NAME = driverClassName;
    }

    @Bean(name = "hikariDataSource")
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setJdbcUrl(URL);
        hikariConfig.setUsername(USERNAME);
        hikariConfig.setPassword(PASSWORD);
        hikariConfig.setDriverClassName(DRIVER_CLASS_NAME);

        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "hikariTemplate")
    public JdbcTemplate JdbcTemplate(@Qualifier("hikariDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
