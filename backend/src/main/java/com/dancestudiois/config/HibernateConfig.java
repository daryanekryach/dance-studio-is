package com.dancestudiois.config;

import com.dancestudiois.model.Authority;
import com.dancestudiois.model.User;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

import static org.hibernate.cfg.Environment.*;

/*@Configuration
@PropertySource("classpath:hibernate.properties")
@EnableTransactionManagement
@ComponentScan("com.dancestudiois")
@EnableJpaRepositories("com.dancestudiois.dao")*/
public class HibernateConfig {
    @Autowired
    private Environment env;

/*    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.dancestudiois.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }*/

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan("com.dancestudiois.model");
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());

        return entityManagerFactoryBean;
    }


    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.jdbcUrl"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }


    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();

        hibernateProperties.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        hibernateProperties.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.put(DIALECT, env.getProperty("hibernate.dialect"));

        hibernateProperties.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
        hibernateProperties.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
        hibernateProperties.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
        hibernateProperties.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
        hibernateProperties.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));

        return hibernateProperties;
    }
}
