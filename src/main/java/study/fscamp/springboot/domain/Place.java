package study.fscamp.springboot.domain;

import lombok.Data;
import study.fscamp.springboot.constant.PlaceType;

import java.time.LocalDateTime;

@Data
public class Place {
  private Long id;
  private PlaceType placeType;
  private String placeName;
  private String address;
  private String phoneNumber;
  private Integer capacity;
  private String memo;

  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;

}
