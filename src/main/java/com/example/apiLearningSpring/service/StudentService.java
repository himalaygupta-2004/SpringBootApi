package com.example.apiLearningSpring.service;

import com.example.apiLearningSpring.dto.AddStudentRequestDto;
import com.example.apiLearningSpring.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudent(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);
}
