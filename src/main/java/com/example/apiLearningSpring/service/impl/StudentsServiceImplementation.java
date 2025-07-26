package com.example.apiLearningSpring.service.impl;

import com.example.apiLearningSpring.dto.AddStudentRequestDto;
import com.example.apiLearningSpring.dto.StudentDto;
import com.example.apiLearningSpring.entity.StudentEntity;
import com.example.apiLearningSpring.repository.StudentRepository;
import com.example.apiLearningSpring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors; // Make sure to import this

import java.util.List;
@Service
@RequiredArgsConstructor //Does the Same task for constructor
public class StudentsServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

//    public StudentsServiceImplementation(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    public List<StudentDto> getAllStudents() {
        List<StudentEntity> students = studentRepository.findAll();
        return students.stream()
                .map(student -> new StudentDto(
                        student.getId(),
                        student.getName(),
                        student.getEmail()))
                .collect(Collectors.toList()); // Or .toList() in Java 16+
    }

    @Override
    public StudentDto getStudentById(Long id) {
        StudentEntity student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        StudentEntity newStudent = modelMapper.map(addStudentRequestDto,StudentEntity.class);
//        Adding into database using save method
        StudentEntity studentEntity = studentRepository.save(newStudent);
        return modelMapper.map(studentEntity,StudentDto.class);
    }

    @Override
    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not Exist"+ id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        StudentEntity student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
        modelMapper.map(addStudentRequestDto,student);

        /* modelMapper.map(add,student); */

        student = studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }
}
