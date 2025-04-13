package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private int phone;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Student( String name, int phone) {
        this.name = name;
        this.phone = phone;
        this.teacher = null;
    }

    public Student(Long id, String name, int phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.teacher = null;
    }
}
