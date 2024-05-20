package study.fscamp.springboot.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminplaceMap {
  private Long id;
  private Long adminId;
  private Long placeId;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
}
