package com.me.config;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/* com.me.config
@Author:Peyman
Date: 14/02/2019
Time: 10:41 AM
Year: 2019
*/
@Configuration
@EnableTransactionManagement
public class HibernateConfig {


    @Bean
    @Autowired
    public DataSourceTransactionManager transactionManager(DataSource ds) {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(ds);
        return txManager;
    }


    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.me.entities"});
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        return dataSource;
    }
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                Environment.HBM2DDL_AUTO, "update");
        hibernateProperties.setProperty(
                Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

        hibernateProperties.setProperty(
                "hibernate.show_sql", "true");



        return hibernateProperties;
    }

}
