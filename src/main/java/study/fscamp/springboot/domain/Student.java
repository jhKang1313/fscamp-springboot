package study.fscamp.springboot.domain;


import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Student {
  private String name;
  private Integer age;
  private Grade grade;

  public enum Grade {
    A, B, C, D, E, F
  }
}
