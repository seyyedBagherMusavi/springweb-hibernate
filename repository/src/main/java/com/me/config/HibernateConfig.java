package com.me.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/* com.me.config
@Author:Peyman
Date: 14/02/2019
Time: 10:41 AM
Year: 2019
*/
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.me" })
public class HibernateConfig {


  /**  @Bean
    @Autowired
    public DataSourceTransactionManager transactionManager(DataSource ds) {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(ds);
        return txManager;
    }**/


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
                org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
        hibernateProperties.put("hibernate.format_sql", "true");
        hibernateProperties.setProperty(
                org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");

        hibernateProperties.setProperty(
                "hibernate.show_sql", "true");



        return hibernateProperties;
    }
    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
