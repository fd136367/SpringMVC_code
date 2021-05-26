package com.lenovo.service;

import com.lenovo.domain.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);
    List<Student> findStudents();
}
