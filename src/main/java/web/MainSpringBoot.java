package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
public class MainSpringBoot {
//    @Autowired
//    private Environment env;
//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
//        return dataSource;
//    }
//    @Bean
//    public LocalContainerEntityManagerFactoryBean getEntityFactory() {
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
//        Properties props = new Properties();
//        props.put("hibernate.show_sql", env.getProperty("spring.jpa.properties.hibernate.show_sql"));
//        props.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
//        props.put("hibernate.current_session_context_class", "thread");
//        bean.setDataSource(getDataSource());
//        bean.setPackagesToScan("web.models");
//        bean.setJpaVendorAdapter(vendorAdapter);
//        bean.setJpaProperties(props);
//        return bean;
//    }
//    @Bean
//    public JpaTransactionManager getTransactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager manager = new JpaTransactionManager();
//        manager.setEntityManagerFactory(getEntityFactory().getObject());
//        return manager;
//    }

    public static void main(String[] args) {
        SpringApplication.run(MainSpringBoot.class, args);
    }
}
