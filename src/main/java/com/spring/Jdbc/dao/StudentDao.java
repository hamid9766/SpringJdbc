package com.spring.Jdbc.dao;

import com.spring.Jdbc.entites.Student;

import java.util.List;

public interface StudentDao {
    public int insert(Student student);
    public int change(Student student);
    public void delete(int studentID);
    public Student getStudent(int studentId);
    public List<Student> getALlStudents();
}
