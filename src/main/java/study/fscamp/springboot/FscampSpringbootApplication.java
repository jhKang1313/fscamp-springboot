package study.fscamp.springboot;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.event.EventListener;
import study.fscamp.springboot.service.StudentService;

@RequiredArgsConstructor
@SpringBootApplication
public class FscampSpringbootApplication {

	private final StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(FscampSpringbootApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		studentService.printStudent("jack");
		studentService.printStudent("jack");
		studentService.printStudent("jack");
		studentService.printStudent("jack");
	}
}
