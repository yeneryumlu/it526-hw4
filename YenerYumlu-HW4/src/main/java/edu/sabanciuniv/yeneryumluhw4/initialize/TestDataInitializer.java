package edu.sabanciuniv.yeneryumluhw4.initialize;

import edu.sabanciuniv.yeneryumluhw4.model.Student;
import edu.sabanciuniv.yeneryumluhw4.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInitializer implements CommandLineRunner {
    private final StudentRepository studentRepository;

    public void run(String... args) {
        if (studentRepository.count() == 0) {
            Student student1 = new Student("Ali", "Öztürk", 202300001);
            Student student2 = new Student("Fatma", "Şahin", 202300002);
            Student student3 = new Student("Veli", "Yılmaz", 202300003);

            studentRepository.save(student1);
            studentRepository.save(student2);
            studentRepository.save(student3);
        }
    }
}
