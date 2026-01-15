package com.Apurba.spring.learningRESTAPI.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String course;

    // constructor
    public StudentDto(Long id, String name, String email,Integer age,String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age=age;
        this.course=course;
    }


    public Long getId() {
        return id;
    }

    public StudentDto() {
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}

