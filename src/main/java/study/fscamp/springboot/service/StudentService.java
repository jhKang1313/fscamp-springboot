package study.fscamp.springboot.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.fscamp.springboot.domain.Student;
import study.fscamp.springboot.repository.StudentRepository;

@RequiredArgsConstructor
@Service
public class StudentService {
  private final StudentRepository studentRepository;

  public void printStudent(String name) {
    Student student = studentRepository.getStudent(name);
    System.out.println("찾는 학생 : " + student);
  }

  @PostConstruct
  public void init() {
    studentRepository.saveStudent("jack", 15, Student.Grade.C);
  }
}
