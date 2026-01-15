package com.Apurba.spring.learningRESTAPI.controller;
import com.Apurba.spring.learningRESTAPI.dto.AddNewStudentDto;
import com.Apurba.spring.learningRESTAPI.dto.StudentDto;
import com.Apurba.spring.learningRESTAPI.entity.Student;
import com.Apurba.spring.learningRESTAPI.repository.StudentRepository;
import com.Apurba.spring.learningRESTAPI.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")

public class studentController {

    private final StudentService studentService;

    public studentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudent() {
//        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudent());
        return ResponseEntity.ok(studentService.getAllStudent());

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentsById(@PathVariable long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddNewStudentDto addNewStudent){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addNewStudent));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,
                                                    @RequestBody @Valid AddNewStudentDto addNewStudentDto){
        return ResponseEntity.ok(studentService.updateStudent(id,addNewStudentDto));
    }

    @PatchMapping("/{id}")

    public ResponseEntity<StudentDto> updatepartialStudent (@PathVariable Long id,
                                                            @RequestBody Map<String,Object> update){
            return ResponseEntity.ok(studentService.updatePartialStudent(id, update));
        }

}
