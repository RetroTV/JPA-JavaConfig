package com.jj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.jj.config.context.ContextDataSource;
import com.jj.config.context.ContextHibernateTransaction;
import com.jj.config.context.ContextHibernate;

@Configuration
@Import({ContextHibernateTransaction.class,
		 ContextDataSource.class,
		 ContextHibernate.class})
@ComponentScan(basePackages = {"com.jj.controller",
							   "com.jj.service",
							   "com.jj.dao"})
public class RootConfig {
	
}