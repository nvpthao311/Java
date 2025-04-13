package com.example.demo.Service;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.Model.Student;
import com.example.demo.Model.Teacher;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    //Teacher
    public void setStudentsForTeacher(Long id_teacher, List<Long> id_students){
        Teacher teacher = teacherRepository.findById(id_teacher)
                .orElseThrow(() -> new NotFoundException(id_teacher, "Teacher"));

        List<Student> validStudents = new ArrayList<>();
        List<Long> invalidIds = new ArrayList<>();

        for (Long id_s : id_students){
            studentRepository.findById(id_s).ifPresentOrElse(
                    student -> {
                student.setTeacher(teacher);
                studentRepository.save(student);
                validStudents.add(student);
            },
                    () -> invalidIds.add(id_s)
            );
        }

        //Báo lỗi những Id không hợp lệ
        if(!invalidIds.isEmpty()){
            System.out.println("Các ID học sinh không hợp lệ: " + invalidIds);
        }
    }


    //Student
    public void setTeacherForStudent(long id_student, Long id_teacher){
        Student student = studentRepository.findById(id_student).
                orElseThrow(() -> new NotFoundException(id_student, "Student"));

        Teacher teacher= teacherRepository.findById(id_teacher)
                .orElseThrow(() -> new NotFoundException(id_teacher, "Teacher"));

        student.setTeacher(teacher);
        studentRepository.save(student);
    }



}
