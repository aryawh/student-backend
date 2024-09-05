package com.studentcrud.aryawh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentcrud.aryawh.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
