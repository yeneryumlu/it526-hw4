package edu.sabanciuniv.yeneryumluhw4.service;

import edu.sabanciuniv.yeneryumluhw4.exception.NotFoundException;
import edu.sabanciuniv.yeneryumluhw4.model.Student;
import edu.sabanciuniv.yeneryumluhw4.model.dto.StudentRequest;
import edu.sabanciuniv.yeneryumluhw4.model.dto.StudentResponse;
import edu.sabanciuniv.yeneryumluhw4.repository.StudentRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public StudentResponse addNewStudent(@NonNull StudentRequest studentRequest) {
        Student studentEntity = Student.builder()
                .name(studentRequest.getName())
                .surname(studentRequest.getSurname())
                .studentNumber(studentRequest.getStudentNumber())
                .build();

        studentEntity = studentRepository.save(studentEntity);

        return StudentResponse.builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .surname(studentEntity.getSurname())
                .studentNumber(studentEntity.getStudentNumber())
                .build();
    }

    public StudentResponse getStudentById(int id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student not found with id: " + id));

        return StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .studentNumber(student.getStudentNumber())
                .build();
    }

    public StudentResponse updateExistingStudent(int id, @NonNull StudentRequest studentRequest) {
        studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student not found with id: " + id));
        Student studentEntity = Student.builder()
                .id(id)
                .name(studentRequest.getName())
                .surname(studentRequest.getSurname())
                .studentNumber(studentRequest.getStudentNumber())
                .build();

        studentEntity = studentRepository.save(studentEntity);

        return StudentResponse.builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .surname(studentEntity.getSurname())
                .studentNumber(studentEntity.getStudentNumber())
                .build();
    }

    public void deleteExistingstudent(int id) {
        Student studentEntity = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student not found with id: " + id));
        studentRepository.delete(studentEntity);
    }
}
