package com.spring.Jdbc.dao;
import com.spring.Jdbc.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        // insert query
        String query = "insert into student(id, name, city) values(?,?,?)";
        int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());

       return r;
    }

    @Override
    public int change(Student student){
        // Updating Data
        String query = "update student set name=?, city=? where id= ?";
        int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());

        return r;
    }

    @Override
    public void delete(int studentId) {
        // Deleting the record
        String query = "delete from student where id=?";
        this.jdbcTemplate.update(query,studentId);
        System.out.println(studentId + " Deleted from database");
    }

    @Override
    public Student getStudent(int studentId) {
        // Set single student data
        String query = "select * from student where id =?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query,rowMapper, studentId);
        return student;
    }

    @Override
    public List<Student> getALlStudents() {
        // Selecting multiple student
        String query = "select * from student";
        List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
        return students;
    }


}
