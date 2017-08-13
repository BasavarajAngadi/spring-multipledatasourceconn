package com.braj.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
* DerbyDbConfig class helps to configure the derby database.
* @author  Basavaraj Angadi
* @version 1.0 
*/

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "derbyEntityManagerFactory", basePackages = { "com.braj.derby.repo" })
public class DerbyDbConfig {

	@Bean(name = "derbyDataSource")
	@ConfigurationProperties(prefix = "derby.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "derbyEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean derbyEntityManagerFactory(
			EntityManagerFactoryBuilder builder,
			@Qualifier("derbyDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.braj.derby.entity")
				.build();
	}

	/*@Bean(name = "derbyTransactionManager")
	public PlatformTransactionManager derbyTransactionManager(
			@Qualifier("derbyEntityManagerFactory") EntityManagerFactory derbyEntityManagerFactory) {
		return new JpaTransactionManager(derbyEntityManagerFactory);
	}*/

}
