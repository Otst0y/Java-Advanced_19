package lesson_19;

import lesson_19.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	@Autowired
	StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
