package com.example.apiLearningSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor //creates a constructor with all the fields in the class without hardcoding
public class StudentDto {
    private long id;
    private String name;
    private String email;


// Conventional Java methods for constructor , getter and setter
//    public StudentDto(long id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

}
