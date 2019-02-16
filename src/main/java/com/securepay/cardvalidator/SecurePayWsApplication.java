package com.securepay.cardvalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan
@EntityScan(basePackages="com.securepay")
@PropertySource("classpath:application.properties")
public class SecurePayWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurePayWsApplication.class, args);
	}
	
	
	
	
	/*@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSourceConfig = new DriverManagerDataSource();
	    dataSourceConfig.setDriverClassName("org.postgresql.Driver");

	    dataSourceConfig.setUrl("jdbc:postgresql://localhost:5432/carddtls");
	    dataSourceConfig.setUsername("postgres");
	   // dataSourceConfig.setValidationQuery("SELECT 1");
	    dataSourceConfig.setPassword("admin");

	    return dataSourceConfig;
	}*/
	/*@Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }*/

	 /* @Bean
	  public EntityManagerFactory entityManagerFactory() {

	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("com.securepay");
	    factory.setDataSource(dataSource());
	    factory.afterPropertiesSet();
	    return factory.getObject();
	  }*/
	
	/*@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(this.dataSource());
        entityManager.setPackagesToScan(new String[] {"com.securepay"});
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(vendorAdapter);
        entityManager.setJpaProperties(this.properties());
        return entityManager;
    }
	
	  private Properties properties() {
	        Properties properties = new Properties();
	        properties.setProperty("hibernate.jdbc.lob.non_contextual_creation", this.env.getProperty("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation"));
	       // properties.setProperty("hibernate.dialect", this.env.getProperty("spring.jpa.hibernate.dialect"));
	       // properties.setProperty("hibernate.show_sql", this.env.getProperty("spring.jpa.show-sql"));
	        return properties;

	    }
	  
	  @Bean
	  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	        return new PersistenceExceptionTranslationPostProcessor();
	  }
	  
	  @Bean
	    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(emf);
	        return transactionManager;
	    }*/
}

