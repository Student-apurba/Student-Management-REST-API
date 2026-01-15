package com.Apurba.spring.learningRESTAPI.services;

import com.Apurba.spring.learningRESTAPI.dto.AddNewStudentDto;
import com.Apurba.spring.learningRESTAPI.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentDto> getAllStudent();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddNewStudentDto addNewStudent);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddNewStudentDto addNewStudentDto);


    StudentDto updatePartialStudent(Long id, Map<String, Object> update);
}
