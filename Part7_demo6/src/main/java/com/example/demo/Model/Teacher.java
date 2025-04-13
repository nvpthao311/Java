package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private int phone;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> studentList = new ArrayList<>();

    public Teacher(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public Teacher(Long id, String name, int phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
