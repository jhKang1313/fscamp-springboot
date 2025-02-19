package study.fscamp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.fscamp.springboot.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
