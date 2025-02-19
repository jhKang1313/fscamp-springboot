package study.fscamp.springboot.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import study.fscamp.springboot.constant.EventStatus;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
@ToString
@Table(indexes = {
    @Index(columnList = "placeId"),
    @Index(columnList = "eventName")
})
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(nullable = false)
  private Long placeId;

  @Setter
  @Column(nullable = false)
  private String eventName;

  @Setter
  @Column(nullable = false, columnDefinition = "varchar default 'OPENED'")
  @Enumerated(EnumType.STRING)
  private EventStatus eventStatus;

  @Setter
  @Column(nullable = false, columnDefinition = "datetime")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime eventStartDatetime;

  @Setter
  @Column(nullable = false, columnDefinition = "datetime")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime eventEndDatetime;

  @Setter
  @Column(nullable = false, columnDefinition = "integer default 0")
  private Integer currentNumberOfPeople;

  @Setter
  @Column(nullable = false)
  private Integer capacity;

  @Setter
  private String memo;

  // insertable : JPA 를 통해서 insert 문에 포함되지 않음. 직접 세팅되지 않음
  @Column(nullable = false, insertable = false, updatable = false,
          columnDefinition = "datetime default CURRENT_TIMESTAMP")

  @CreatedDate
  private LocalDateTime createdAt;

  @Column(nullable = false, insertable = false, updatable = false,
          columnDefinition = "datetime default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
  // columnDefinition : 특정 DB에 종속적인 표현이라 지양
  @LastModifiedDate
  private LocalDateTime modifiedAt;


  public Event(Long placeId, String eventName, EventStatus eventStatus, LocalDateTime eventStartDatetime, LocalDateTime eventEndDatetime, Integer currentNumberOfPeople, Integer capacity, String memo) {
    this.placeId = placeId;
    this.eventName = eventName;
    this.eventStatus = eventStatus;
    this.eventStartDatetime = eventStartDatetime;
    this.eventEndDatetime = eventEndDatetime;
    this.currentNumberOfPeople = currentNumberOfPeople;
    this.capacity = capacity;
    this.memo = memo;
  }

  public Event() {}

  public static Event of(Long placeId, String eventName, EventStatus eventStatus, LocalDateTime eventStartDatetime, LocalDateTime eventEndDatetime, Integer currentNumberOfPeople, Integer capacity, String memo){
    return new Event(
        placeId,
        eventName,
        eventStatus,
        eventStartDatetime,
        eventEndDatetime,
        currentNumberOfPeople,
        capacity,
        memo
    );
  }
}
