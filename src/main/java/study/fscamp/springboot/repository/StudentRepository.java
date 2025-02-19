package study.fscamp.springboot.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import study.fscamp.springboot.domain.Student;

import java.util.Map;


@RequiredArgsConstructor
@Component
public class StudentRepository {
  private final Map<String, Student> storage;
  @Cacheable("student")
  public Student getStudent(String name) {
    System.out.println("[repo] 나의 통행료는 무척 비싸다!");
    return storage.get(name);
  }
  public Student saveStudent(String name, Integer age, Student.Grade grade) {
    return storage.put(name, Student.of(name, age, grade));
  }
}
