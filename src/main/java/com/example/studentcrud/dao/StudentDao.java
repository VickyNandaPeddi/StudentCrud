package com.example.studentcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentcrud.entity.Student;

@Repository

public interface StudentDao extends JpaRepository<Student, Integer> {
    public boolean existsBySid(int sid);
}
