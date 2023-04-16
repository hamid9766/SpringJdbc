package com.spring.Jdbc;

import com.spring.Jdbc.dao.StudentDao;
import com.spring.Jdbc.entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!......");
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcconfig.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        // Inserting the record
       /* Student student = new Student();
        student.setId(4);
        student.setName("John");
        student.setCity("Mumbai");
        int result = studentDao.insert(student);
        System.out.println("Number of record inserted..." + result);*/

        // Updating the query
       /* Student student1 = new Student();
        student1.setId(4);
        student1.setName("Sahil");
        student1.setCity("Chandigarh");
        int r = studentDao.change(student1);
        System.out.println("data changed " + r);*/

        // Delete the record
        //studentDao.delete(4);

        Student student = studentDao.getStudent(2);
        System.out.println(student);

    }
}