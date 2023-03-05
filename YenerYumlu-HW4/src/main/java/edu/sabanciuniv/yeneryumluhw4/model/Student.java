package edu.sabanciuniv.yeneryumluhw4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private int studentNumber;
    public Student(String name, String surname, int studentNumber) {
        this.name = name;
        this.surname = surname;
        this.studentNumber = studentNumber;
    }
}
