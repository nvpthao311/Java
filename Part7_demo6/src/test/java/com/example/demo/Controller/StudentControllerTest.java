package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
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
    void getStudentById() throws Exception{
        when(studentService.findById(2L)).thenReturn(s2);

        mockMvc.perform(get("/students/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.name").value("bich"))
                .andExpect(jsonPath("$.phone").value(654454));
    }

    @Test
    void getAllStudent() throws Exception {
        List<Student> students = Arrays.asList(s1, s2, s3, s4, s5);

        when(studentService.findAll()).thenReturn(students);

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5));

    }

    @Test
    void createStudent() throws Exception{
        when(studentService.addStudent(s3)).thenReturn(s3);
        ObjectMapper objectMapper = new ObjectMapper();


        mockMvc.perform(post("/students")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(s3)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("minh"))
                .andExpect(jsonPath("$.phone").value(878798));
    }

    @Test
    void updateStudent() throws Exception{
        when(studentService.updateStudent(3L, s3)).thenReturn(s3);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(put("/students/3")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(s3)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("minh"))
                .andExpect(jsonPath("$.phone").value(878798));
    }

    @Test
    void deleteStudent() throws Exception{
        mockMvc.perform(delete("/students/5"));

        verify(studentService, times(1)).deleteStudent(5L);
    }
}