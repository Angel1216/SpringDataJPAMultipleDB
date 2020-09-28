package com.example.jpa.mssqserver.mssqserver;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "clientsEntityManagerFactory", transactionManagerRef = "clientsTransactionManager",
    basePackages = {"com.example.jpa.mssqserver.mssqserver.dao.clients"})
public class OracleConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name = "clientsDataSource")
	public DataSource certifiedDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("oracle.datasource.url"));
		dataSource.setUsername(env.getProperty("oracle.datasource.username"));
		dataSource.setPassword(env.getProperty("oracle.datasource.password"));
		dataSource.setDriverClassName(env.getProperty("oracle.datasource.driver-class-name"));
		
		return dataSource;
	}
	
	@Bean(name = "clientsEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(certifiedDataSource());
		em.setPackagesToScan("com.example.jpa.mssqserver.mssqserver.entity.clients");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("oracle.jpa.hibernate.ddl-auto"));
		properties.put("hibernate.show-sql", env.getProperty("oracle.jpa.show-sql"));
		properties.put("hibernate.dialect", env.getProperty("oracle.jpa.database-platform"));
		
		em.setJpaPropertyMap(properties);
		
		return em;
	}
	
	@Bean(name = "clientsTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}

}
