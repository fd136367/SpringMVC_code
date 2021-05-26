package com.lenovo.dao;

import com.lenovo.domain.Student;

import java.util.List;

public interface StudentDao {

    int insertStudent(Student student);
    List<Student> selectStudents();
}
