package com.Apurba.spring.learningRESTAPI.services.implement;

import com.Apurba.spring.learningRESTAPI.dto.AddNewStudentDto;
import com.Apurba.spring.learningRESTAPI.dto.StudentDto;
import com.Apurba.spring.learningRESTAPI.entity.Student;
import com.Apurba.spring.learningRESTAPI.repository.StudentRepository;
import com.Apurba.spring.learningRESTAPI.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students=repository.findAll();
        return students
                .stream().
                map(student->modelMapper.map(student,StudentDto.class))
                .toList();

    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student= repository.findById(id).orElseThrow(() ->new IllegalArgumentException("student not found with id "+id));

       return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddNewStudentDto addNewStudent) {

        Student newStudent=modelMapper.map(addNewStudent,Student.class);
        Student student=repository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("student does not exits "+id);
        }else{
            repository.deleteById(id);

        }
    }

    @Override
    public StudentDto updateStudent(Long id, AddNewStudentDto addNewStudentDto) {
        Student student= repository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("student not found with id "+id));

        modelMapper.map(addNewStudentDto,student);

        student=repository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> update) {
        Student student= repository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("student not found with id "+id));

        update.forEach((field,value)->{
            switch (field){
                case "name":
                    student.setName((String) value);
                    break;

                case "email":
                    student.setEmail((String) value);
                    break;

                case "age":
                    student.setAge(((Integer) value));
                    break;

                case "course":
                    student.setCourse((String) value);
                    break;

                default:
                    throw new IllegalArgumentException("field is not supported");

            }
        });
       Student saveStudent=repository.save(student);
        return modelMapper.map(saveStudent,StudentDto.class);


    }
}
