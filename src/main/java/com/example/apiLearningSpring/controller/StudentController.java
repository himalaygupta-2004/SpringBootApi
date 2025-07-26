package com.example.apiLearningSpring.controller;

import com.example.apiLearningSpring.dto.AddStudentRequestDto;
import com.example.apiLearningSpring.dto.StudentDto;
import com.example.apiLearningSpring.entity.StudentEntity;
import com.example.apiLearningSpring.repository.StudentRepository;
import com.example.apiLearningSpring.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("students")
public class StudentController {

    final StudentRepository studentRepository;
    final StudentService studentService;


//    public StudentController(StudentRepository studentRepository, StudentService studentService) {
//        this.studentRepository = studentRepository;
//        this.studentService = studentService;
//    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        return ResponseEntity.ok(studentService.getAllStudents());
//       This Object is converted into json format via http messaging service
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentByid(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

//    Used to make post methods
    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        StudentDto createdStudent = studentService.createNewStudent(addStudentRequestDto);
        return new ResponseEntity<>(createdStudent,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}") //used for complete change
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id,addStudentRequestDto));
    }

//    @PatchMapping //partial change



}
