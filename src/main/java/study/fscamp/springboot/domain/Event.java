package study.fscamp.springboot.domain;

import lombok.Data;
import study.fscamp.springboot.constant.EventStatus;

import java.time.LocalDateTime;

@Data
public class Event {
  private Long id;

  private Long placeId;
  private String eventName;
  private EventStatus eventStatus;
  private Integer currentNumberOfPeople;
  private Integer capacity;
  private String memo;

  private LocalDateTime eventStartDatetime;
  private LocalDateTime eventEndDatetime;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
}
