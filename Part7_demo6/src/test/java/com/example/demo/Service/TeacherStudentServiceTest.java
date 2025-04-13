package com.example.demo.Service;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.Model.Student;
import com.example.demo.Model.Teacher;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherStudentServiceTest {

    @Autowired
    private TeacherStudentService teacherStudentService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    private Student s1, s2, s3, s4, s5;
    private Teacher t1, t2;

    @BeforeEach
    void setUp(){
        s1 = new Student( "my", 7878712);
        s2 = new Student( "bich", 654454);
        s3 = new Student( "minh", 878798);
        s4 = new Student( "ngoc", 1187623);
        s5 = new Student( "phuong", 7892544);

        studentRepository.saveAll(List.of(s1, s2, s3, s4, s5));

        t1 = new Teacher( "lily", 123);
        t2 = new Teacher( "Alex", 456);

        teacherRepository.saveAll(List.of(t1, t2));

    }

    @Test
    void testToSetStudentsForTeacher(){
        teacherStudentService.setStudentsForTeacher(1L, List.of(2L, 3L, 12L, 11L));

        Teacher teacher = teacherRepository.findById(1L).orElse(null);

        assertEquals(2, teacher.getStudentList().size());

        Student student = studentRepository.findById(2L).orElse(null);
        assertEquals(t1.getName(),student.getTeacher().getName());

        Student student2 = studentRepository.findById(3L).orElse(null);
        assertEquals(t1.getName(),student2.getTeacher().getName());
    }

    @Test
    void testToSetTeacherForStudent(){
        teacherStudentService.setTeacherForStudent(5L, 2L);

        Student student = studentRepository.findById(5L).orElse(null);
        assertEquals(t2.getName(), student.getTeacher().getName());
    }


}