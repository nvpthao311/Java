package com.example.demo.Service;

import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Student s1, s2, s3, s4, s5;

    @BeforeEach
    void setUp(){
        s1 = new Student(1L, "my", 7878712);
        s2 = new Student(2L, "bich", 654454);
        s3 = new Student(3L, "minh", 878798);
        s4 = new Student(4L, "ngoc", 1187623);
        s5 = new Student(5L, "phuong", 7892544);
    }

    @Test
    void testAddStudent() {
        when(studentRepository.save(any(Student.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Student actual = studentService.addStudent(s1);
        assertEquals(s1, actual);
    }

    @Test
    void testFindById() {
        when(studentRepository.findById(2L)).thenReturn(Optional.of(s2));

        Student actual = studentService.findById(2L);
        assertEquals(s2, actual);
    }

    @Test
    void testFindAll(){
        List<Student> students = Arrays.asList(s1, s2, s3, s4, s5);
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> actual = studentService.findAll();
        assertEquals(students, actual);
    }

    @Test
    void testUpdateStudent(){
        Student s = new Student(2L, "manh", 44444444);

        when(studentRepository.findById(2L)).thenReturn(Optional.of(s2));
        when(studentRepository.save(any(Student.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));


        Student actual = studentService.updateStudent(2L, s);
        assertEquals(s, actual);
    }

    @Test
    void testDeleteStudent(){
        studentService.deleteStudent(4L);

        verify(studentRepository, times(1)).deleteById(4L);
    }




}