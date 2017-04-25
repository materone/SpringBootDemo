package com.tony.spring.boot.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration implements EnvironmentAware {

	private RelaxedPropertyResolver propertyResolver;

	private static Logger log = LoggerFactory.getLogger(DataBaseConfiguration.class);

	private Environment env;

	@Override
	public void setEnvironment(Environment env) {
		this.env = env;
		this.propertyResolver = new RelaxedPropertyResolver(env, "jdbc.datasource.");
	}

	/**
	 * 配置数据源
	 * @Description TODO
	 * @return
	 */
	@Bean(name = "dataSource",destroyMethod = "close")
	public DataSource dataSource() {
		log.debug(env.getActiveProfiles().toString());  
         
         DruidDataSource dataSource = new DruidDataSource();  
         dataSource.setUrl(propertyResolver.getProperty("url"));  
         dataSource.setUsername(propertyResolver.getProperty("username"));//用户名  
         dataSource.setPassword(propertyResolver.getProperty("password"));//密码  
         dataSource.setDriverClassName(propertyResolver.getProperty("driver-class-name")); 
         dataSource.setInitialSize(Integer.parseInt(propertyResolver.getProperty("initialSize")));  
         dataSource.setMaxActive(Integer.parseInt(propertyResolver.getProperty("maxActive")));  
         dataSource.setMinIdle(Integer.parseInt(propertyResolver.getProperty("minIdle")));  
         dataSource.setMaxWait(Integer.parseInt(propertyResolver.getProperty("maxWait")));  
         dataSource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(propertyResolver.getProperty("timeBetweenEvictionRunsMillis")));  
         dataSource.setMinEvictableIdleTimeMillis(Integer.parseInt(propertyResolver.getProperty("minEvictableIdleTimeMillis")));  
         dataSource.setValidationQuery(propertyResolver.getProperty("validationQuery"));  
         dataSource.setTestOnBorrow(Boolean.getBoolean(propertyResolver.getProperty("testOnBorrow")));  
         dataSource.setTestWhileIdle(Boolean.getBoolean(propertyResolver.getProperty("testWhileIdle")));  
         dataSource.setTestOnReturn(Boolean.getBoolean(propertyResolver.getProperty("testOnReturn")));  
         dataSource.setPoolPreparedStatements(Boolean.getBoolean(propertyResolver.getProperty("poolPreparedStatements")));  
         dataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(propertyResolver.getProperty("maxOpenPreparedStatements")));  
         try {
			dataSource.init();
		} catch (SQLException e) {
			
		}
         return dataSource; 
	}

}
