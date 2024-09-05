package com.studentcrud.aryawh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentcrud.aryawh.dto.StudentDto;
import com.studentcrud.aryawh.entity.Student;
import com.studentcrud.aryawh.exception.ResourceNotFoundException;
import com.studentcrud.aryawh.mapper.StudentMapper;
import com.studentcrud.aryawh.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student saveStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(saveStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student byId = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student is not available by give Id : " + studentId));
        return StudentMapper.mapToStudentDto(byId);
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> allStudent = studentRepository.findAll();
        return allStudent;
    }

    @Override
    public Student updateStudent(Student student, Long studentId) {
        Student byId = studentRepository.findById(studentId)
                .map(tempo -> {
                    tempo.setFirstName(student.getFirstName());
                    tempo.setLastName(student.getLastName());
                    tempo.setMajor(student.getMajor());
                    return studentRepository.save(tempo);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Student is not available by give Id : " + studentId));

        return byId;
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student studentById = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student is not available by give Id : " + studentId));
        studentRepository.delete(studentById);
    }

}
