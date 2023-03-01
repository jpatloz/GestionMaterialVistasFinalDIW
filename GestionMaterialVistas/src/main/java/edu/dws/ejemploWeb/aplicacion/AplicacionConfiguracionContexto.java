package edu.dws.ejemploWeb.aplicacion;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties") //Esta anotación indica el archivo donde se define las propiedades del contexto
@EnableJpaRepositories("edu.dws.ejemploWeb.aplicacion.dal") //esta anotación escanea el paquete para que se permita usar jpa
public class AplicacionConfiguracionContexto {
	
	@Autowired
	private Environment contextoPropiedades;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(contextoPropiedades.getProperty("db.driver"));
		dataSource.setUrl(contextoPropiedades.getProperty("db.url"));
		dataSource.setUsername(contextoPropiedades.getProperty("db.username"));
		dataSource.setPassword(contextoPropiedades.getProperty("db.password"));
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan(GestionAlumnos.class.getPackage().getName());

		HibernateJpaVendorAdapter hibernateJpa = new HibernateJpaVendorAdapter();
		hibernateJpa.setDatabase(Database.POSTGRESQL);
		hibernateJpa.setDatabasePlatform(contextoPropiedades.getProperty("hibernate.dialect"));
		hibernateJpa.setGenerateDdl(contextoPropiedades.getProperty("hibernate.generateDdl", Boolean.class));
		hibernateJpa.setShowSql(contextoPropiedades.getProperty("hibernate.show_sql", Boolean.class));
		emf.setJpaVendorAdapter(hibernateJpa);

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", contextoPropiedades.getProperty("hibernate.hbm2ddl.auto"));
		jpaProperties.put("hibernate.show_sql", contextoPropiedades.getProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.format_sql", contextoPropiedades.getProperty("hibernate.format_sql"));
		emf.setJpaProperties(jpaProperties);

		return emf;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
