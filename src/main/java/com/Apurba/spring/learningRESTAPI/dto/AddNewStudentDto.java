package com.Apurba.spring.learningRESTAPI.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AddNewStudentDto {

    @NotBlank(message = "name is required")
    private String name;

    @Email
    @NotBlank(message = "email is required")
    private String email;


    private Integer age;

    @NotBlank(message = "Student must have a course")
    private String course;

    public AddNewStudentDto(String name, String email,Integer age,String course) {
        this.name = name;
        this.email = email;
        this.age=age;
        this.course=course;
    }

    public AddNewStudentDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public  String getCourse() {
        return course;
    }

    public void setCourse (String course) {
        this.course = course;
    }
}
