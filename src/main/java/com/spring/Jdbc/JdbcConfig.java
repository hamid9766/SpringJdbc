package com.spring.Jdbc;

import com.spring.Jdbc.dao.StudentDao;
import com.spring.Jdbc.dao.StudentDaoImpl;
import com.spring.Jdbc.entites.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.spring.Jdbc.dao")
public class JdbcConfig {

    @Bean("ds")
    public DriverManagerDataSource getDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://Localhost:3306/springjdbc");
        ds.setUsername("root");
        ds.setPassword("mysql@123");
        return ds;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }

    @Bean("studentDao")
    public StudentDao getStudentDao(){
        StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
        studentDaoImpl.setJdbcTemplate(getTemplate());
        return studentDaoImpl;
    }
}
