package study.fscamp.springboot;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import study.fscamp.springboot.service.StudentService;

@SpringBootApplication
public class FscampSpringbootApplication {

	private final StudentService studentService;
	private final String username;
	private final String password;

	public FscampSpringbootApplication(
			@Value("${spring.datasource.username:vault off}") String username,
			@Value("${spring.datasource.password:vault off}") String password,
			StudentService studentService
	) {
		this.username = username;
		this.password = password;
		this.studentService = studentService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FscampSpringbootApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void init() {
//		System.out.println("vault => " + username + ":" + password);
//		studentService.printStudent("jack");
//		studentService.printStudent("jack");
//		studentService.printStudent("jack");
//		studentService.printStudent("jack");
//	}
	@Bean
	public ApplicationRunner applicationRunner(StudentService studentService) {
		return args -> {
			System.out.println("vault => " + username + ":" + password);
		};
	}
}
