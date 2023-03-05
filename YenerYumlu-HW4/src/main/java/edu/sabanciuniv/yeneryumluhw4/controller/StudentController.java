package edu.sabanciuniv.yeneryumluhw4.controller;

import edu.sabanciuniv.yeneryumluhw4.model.Student;
import edu.sabanciuniv.yeneryumluhw4.model.dto.StudentRequest;
import edu.sabanciuniv.yeneryumluhw4.model.dto.StudentResponse;
import edu.sabanciuniv.yeneryumluhw4.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        log.info("list all students:");
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public ResponseEntity<StudentResponse> addNewStudent(@RequestBody StudentRequest student) {
        log.info("add new student:");
        return ResponseEntity.ok().body(studentService.addNewStudent(student));
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable int id){
        log.info("get student by id:");
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentResponse> updateExistingStudent(@PathVariable int id, @RequestBody StudentRequest studentRequest) {
        return ResponseEntity.ok().body(studentService.updateExistingStudent(id, studentRequest));
    }

    @DeleteMapping("/students/{id}")
    public void deleteExistingBook(@PathVariable int id) {
        studentService.deleteExistingstudent(id);
    }
}
