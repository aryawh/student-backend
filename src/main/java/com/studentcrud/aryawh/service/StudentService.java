package com.studentcrud.aryawh.service;

import java.util.List;

import com.studentcrud.aryawh.dto.StudentDto;
import com.studentcrud.aryawh.entity.Student;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long studentId);

    List<Student> getAllStudent();

    Student updateStudent(Student student, Long studentId);

    void deleteStudent(Long studentId);
}
