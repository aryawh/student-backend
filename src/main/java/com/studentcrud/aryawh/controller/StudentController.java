package com.studentcrud.aryawh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentcrud.aryawh.dto.StudentDto;
import com.studentcrud.aryawh.entity.Student;
import com.studentcrud.aryawh.service.StudentService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Build Add student REST API
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto student = studentService.createStudent(studentDto);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Get Student bu Id REST API
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentId(@PathVariable("id") Long id) {
        StudentDto studentById = studentService.getStudentById(id);
        return ResponseEntity.ok(studentById);
    }

    // Get All student
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> allStudent = studentService.getAllStudent();
        return ResponseEntity.ok(allStudent);
    }

    // Update Student REST API
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        Student updateStudent = studentService.updateStudent(student, id);
        return new ResponseEntity<>(updateStudent, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "Success Delete " + id;
    }
}
