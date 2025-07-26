package com.example.apiLearningSpring.repository;


import com.example.apiLearningSpring.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//We can access all the methods in jparepository by extending our class
//Contains Crud Operation

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

}
