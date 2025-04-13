package com.example.demo.Repository;

import com.example.demo.Model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    private Student s1, s2, s3, s4, s5;

    @BeforeEach
    void setUp(){
        s1 = new Student( "my", 7878712);
        s2 = new Student("bich", 654454);
        s3 = new Student( "my", 878798);
        s4 = new Student( "ngoc", 1187623);
        s5 = new Student( "phuong", 7892544);

        studentRepository.saveAll(List.of( s1, s2, s3, s4));
    }

    @Test
    void findByName() {
        List<Student> result = studentRepository.findByName("my");

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(student -> student.getName().equals("my")));
    }

    @Test
    void findByIdBetween() {
        List<Student> result = studentRepository.findByIdBetween(2L,4L);

        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(student -> student.getId() >= 2 && student.getId() <= 4));
    }

    @Test
    void findById() {
        Student result = studentRepository.findById(3L).orElse(null);

        assertEquals(s3, result);
    }

    @Test
    void findAll(){
        List<Student> result = studentRepository.findAll();

        assertEquals(List.of(s1, s2, s3, s4), result);
    }

    @Test
    void save(){
        Student student = studentRepository.save(s5);
        List<Student> result = studentRepository.findAll();

        assertEquals(student, s5);
        assertEquals(List.of(s1, s2, s3, s4, s5), result);
    }

    @Test
    void update(){
        Student s = studentRepository.findById(4L).orElse(null);
        s.setName(s5.getName());
        s.setPhone(s5.getPhone());

        Student student = studentRepository.save(s);

        assertEquals(s5.getName(), student.getName());
        assertEquals(s5.getPhone(), student.getPhone());
    }

    @Test
    void deleteById(){
        studentRepository.deleteById(3L);
        List<Student> result = studentRepository.findAll();

        assertEquals(List.of(s1, s2, s4), result);
    }
}