/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jumia.test.phonevalidation.conf;

import java.nio.file.Paths;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author ahmad
 */
@Configuration
@Slf4j
public class DBconfguration {


    @Bean
    DataSource createSqliteDataSource() {
        log.info("datasource created");
        return DataSourceBuilder.create().driverClassName("org.sqlite.JDBC")
                .url("jdbc:sqlite:" + this.getClass().getClassLoader().getResource("db/sample.db").getPath())
                .build();
    }
}
