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
@EnableJpaRepositories(entityManagerFactoryRef = "certifiedEntityManagerFactory", transactionManagerRef = "certifiedTransactionManager",
    basePackages = {"com.example.jpa.mssqserver.mssqserver.dao.certified"})
public class SQLServerConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name = "certifiedDataSource")
	public DataSource certifiedDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("sqlserver.datasource.url"));
		dataSource.setUsername(env.getProperty("sqlserver.datasource.username"));
		dataSource.setPassword(env.getProperty("sqlserver.datasource.password"));
		dataSource.setDriverClassName(env.getProperty("sqlserver.datasource.driver-class-name"));
		
		return dataSource;
	}
	
	@Bean(name = "certifiedEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(certifiedDataSource());
		em.setPackagesToScan("com.example.jpa.mssqserver.mssqserver.entity.certified");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.show-sql", env.getProperty("sqlserver.jpa.show-sql"));
		properties.put("hibernate.dialect", env.getProperty("sqlserver.jpa.database-platform"));
		
		em.setJpaPropertyMap(properties);
		
		return em;
	}
	
	@Bean(name = "certifiedTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}

}
