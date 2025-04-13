package com.example.demo.Service;

import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id,Student student){
        Student student1 = studentRepository.findById(id).orElse(null);

        if(student1 != null){
            student1.setName(student.getName());
            student1.setPhone(student.getPhone());

            return studentRepository.save(student1);
        }
        return null;
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }


}
