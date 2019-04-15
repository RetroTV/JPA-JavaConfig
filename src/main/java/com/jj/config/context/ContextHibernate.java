package com.jj.config.context;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class ContextHibernate {
		
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(new String[] {"com.jj.vo"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		
		return sessionFactory;
	}
	
	private Properties hibernateProperties() {
        
		Properties properties = new Properties();
		
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.connection.useSSL", "false");
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        
        return properties;
    }
}
